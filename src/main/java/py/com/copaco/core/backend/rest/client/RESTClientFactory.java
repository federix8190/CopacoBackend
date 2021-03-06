package py.com.copaco.core.backend.rest.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map.Entry;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.jboss.resteasy.client.ClientExecutor;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.BaseClientResponse;
import org.jboss.resteasy.client.core.BaseClientResponse.BaseClientResponseStreamFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.jboss.resteasy.util.CaseInsensitiveMap;

import py.com.copaco.core.backend.jackson.CopacoJacksonJsonProvider;
import py.com.copaco.core.backend.security.SessionSecurity;
import static org.jboss.resteasy.util.HttpHeaderNames.*;

@ApplicationScoped
@Lock(LockType.READ)
public class RESTClientFactory {

    @Inject
    private SessionSecurity sessionSecurity;

    static {

        ResteasyProviderFactory pf = ResteasyProviderFactory.getInstance();
        JacksonJsonProvider jacksonJsonProvider = new JacksonJsonProvider(
                new CopacoJacksonJsonProvider().getContext(null));
        pf.addMessageBodyReader(jacksonJsonProvider);
        pf.addMessageBodyWriter(jacksonJsonProvider);
        RegisterBuiltin.register(pf);

    }

    @Inject
    private RESTUrlProvider urlProvider;

    @SuppressWarnings("unchecked")
    public <T> T getRESTClient(Class<T> laInterfazRest, String sistema) {

        String realUrl = urlProvider.getUrl(sistema);
        T elCliente = ProxyFactory.create(laInterfazRest, realUrl,
                new ClientExecutor() {
            public ClientResponse execute(ClientRequest request)
                    throws Exception {
                String uri = request.getUri();
                String httpMethod = request.getHttpMethod();

                HttpURLConnection connection = (HttpURLConnection) new URL(
                        uri).openConnection();
                connection.setRequestMethod(httpMethod);
                setupRequest(request, connection);
                return execute(request, connection);
            }

            private void setupRequest(ClientRequest request,
                    HttpURLConnection connection)
                    throws ProtocolException {
                boolean isGet = "GET".equals(request.getHttpMethod());
                connection.setInstanceFollowRedirects(isGet
                        && request.followRedirects());
                connection.setDoOutput(request.getBody() != null
                        || !request.getFormParameters().isEmpty());

                if (request.getBody() != null
                        && !request.getFormParameters().isEmpty()) {
                    throw new RuntimeException(
                            "You cannot send both form parameters and an entity body");
                }

                if (!request.getFormParameters().isEmpty()) {
                    throw new RuntimeException(
                            "URLConnectionClientExecutor doesn't support form parameters yet");
                }
            }

            private void commitHeaders(ClientRequest request,
                    HttpURLConnection connection) {
                for (Entry<String, List<String>> entry : request
                        .getHeaders().entrySet()) {
                    String value = null;
                    if (entry.getValue().size() == 1) {
                        value = entry.getValue().get(0);
                    } else {
                        StringBuilder b = new StringBuilder();
                        String add = "";
                        for (String v : entry.getValue()) {
                            b.append(add).append(v);
                            add = ",";
                        }
                        value = b.toString();
                    }
                    connection.addRequestProperty(entry.getKey(), value);
                }
            }

            public ClientRequest createRequest(String uriTemplate) {
                return new ClientRequest(uriTemplate, this);
            }

            public ClientRequest createRequest(UriBuilder uriBuilder) {
                return new ClientRequest(uriBuilder, this);
            }

            private ClientResponse execute(ClientRequest request,
                    final HttpURLConnection connection)
                    throws IOException {
                outputBody(request, connection);
                final int status = connection.getResponseCode();
                BaseClientResponse response = new BaseClientResponse(
                        new BaseClientResponseStreamFactory() {
                    public InputStream getInputStream()
                            throws IOException {
                        return (status < 300) ? connection
                                .getInputStream() : connection
                                        .getErrorStream();
                    }

                    public void performReleaseConnection() {
                        try {
                            getInputStream().close();
                        } catch (IOException e) {
                        }
                        connection.disconnect();
                    }
                }, this);
                response.setProviderFactory(request
                        .getProviderFactory());
                response.setStatus(status);
                response.setHeaders(getHeaders(connection));
                return response;
            }

            public void close() {
                // empty
            }

            private MultivaluedMap<String, String> getHeaders(
                    final HttpURLConnection connection) {
                MultivaluedMap<String, String> headers = new CaseInsensitiveMap<String>();

                for (Entry<String, List<String>> header : connection
                        .getHeaderFields().entrySet()) {
                    if (header.getKey() != null) {
                        for (String value : header.getValue()) {
                            headers.add(header.getKey(), value);
                        }
                    }
                }
                return headers;
            }

            private void outputBody(final ClientRequest request,
                    final HttpURLConnection connection) {
                if (request.getBody() != null) {
                    // System.out.println(request.getBody());
                    if (connection.getRequestProperty(CONTENT_TYPE) == null) {
                        String type = request.getBodyContentType()
                                .toString();
                        connection.addRequestProperty(CONTENT_TYPE,
                                type);
                    }
                    try {
                        commitHeaders(request,
                                connection);
                        OutputStream os = connection.getOutputStream();
                        /*CommitHeaderOutputStream commit = new CommitHeaderOutputStream(
										os,
										new CommitHeaderOutputStream.CommitCallback() {
											@Override
											public void commit() {
												commitHeaders(request,
														connection);
											}
										});*/
                        request.writeRequestBody(
                                request.getHeadersAsObjects(), os);
                        os.flush();
                        os.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    commitHeaders(request, connection);
                }
            }
        });

        Object nuestroProxy = Proxy.newProxyInstance(laInterfazRest
                .getClassLoader(), new Class[]{laInterfazRest},
                new RESTClientFactoryInvocationHandler(elCliente,
                        laInterfazRest, sessionSecurity));

        return (T) nuestroProxy;

    }

}
