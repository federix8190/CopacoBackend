package py.com.copaco.core.backend.rest.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ClientResponseFailure;
import org.jboss.resteasy.util.GenericType;

import py.com.copaco.core.backend.exception.ApplicationException;
import py.com.copaco.core.backend.exception.ApplicationRuntimeException;
import py.com.copaco.core.backend.exception.ServiceRequestedForbiden;
import py.com.copaco.core.backend.rest.FailRespuesta;
import py.com.copaco.core.backend.security.SessionSecurity;

public class RESTClientFactoryInvocationHandler implements InvocationHandler {

	Object proxyAlWebservice;
	Class<?> laInterfaz;
	
	private SessionSecurity sessionSecurity;

	public RESTClientFactoryInvocationHandler(Object p,Class<?> laInterfaz, SessionSecurity sessionSecurity) {

		this.proxyAlWebservice = p;
		this.laInterfaz = laInterfaz;
		this.sessionSecurity=sessionSecurity;
	}

	/**
	 * Este metodo se llama automaticamente cada vez que se invoque cualquier
	 * metodo de la interface implementada por el proxy
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		// TODO: Aca se hace pasa mano al proxy de verdad, antes y despues se
		// puede enviar info al log.
		Object respuesta = null;
		try {

//			/**
//			 * Verificar si el usuario logueado tiene permisos para invocar a la url y metodo
//			 */
//			Path classLevelPath = laInterfaz.getAnnotation(Path.class);
//			
//			if (classLevelPath == null)
//				throw new Exception("No se encontro el annotation Path en la interfaz " + laInterfaz.toString());
//			
//			String url = classLevelPath.value();
//			
//			Method targetMethod = laInterfaz.getMethod(method.getName(), method.getParameterTypes());
//			
//			Path methodLevelPath = targetMethod.getAnnotation(Path.class);
//			
//			if (methodLevelPath != null)
//				url += methodLevelPath.value();
//				
//			
//			String httpMethod = "GET";
//			
//			if (targetMethod.getAnnotation(POST.class) != null)
//				httpMethod = "POST";
//			else if (targetMethod.getAnnotation(PUT.class) != null)
//				httpMethod = "PUT";
//			else if (targetMethod.getAnnotation(DELETE.class) != null)
//				httpMethod = "DELETE";
//
//			
//			// lista de aceptados que pasan por el proxy.
//			List<String> listaAceptados = new ArrayList<String>();
//			listaAceptados.add("py.com.copaco.billing.security.web.resources.SessionSecurityResourceInterface");
//			listaAceptados.add("py.com.copaco.billing.security.web.resources.SingletonSecurityResourceInterface");
//			
//			
//			
//			//if(!laInterfaz.getName().equals("py.com.copaco.billing.security.web.resources.SessionSecurityResourceInterface"))
//			if( !listaAceptados.contains(laInterfaz.getName()) ){
//			
//				/*if(! sessionSecurity.existeUrlXMetodo(url, httpMethod)){
//					
//					throw new ServiceRequestedForbiden("No tiene permisos para acceder al recurso:  " + url);
//				}*/
//			}
//			
//			
//			
//			
//			
//			//Invocar al servicio
			respuesta = method.invoke(this.proxyAlWebservice, args);

		} catch (InvocationTargetException e) {
			// Ocurrió un error que no fue manejado, o se disparó, en el lado
			// servidor.
			try {
				Throwable realException = e.getTargetException();
				if (!(realException instanceof ClientResponseFailure))
					throw realException;

				ClientResponseFailure clientResponseFailure = (ClientResponseFailure) realException;
				ClientResponse<?> clientResponse = clientResponseFailure
						.getResponse();
				if (clientResponse.getStatus() == 404)
					throw new NotFoundException();
				if (clientResponse.getHeaders().get("Content-type")
						.contains("text/plain")) {
					throw new RuntimeException(
							clientResponse.getEntity(String.class),
							realException);
				}
				handleClientException(clientResponse);
			} catch (Exception e2) {
				if (e2 instanceof ApplicationException)
					throw e2;
				if (e2 instanceof ApplicationRuntimeException)
					throw e2;
				if (e2 instanceof NotFoundException)
					throw e2;
				e2.printStackTrace();
				throw e2;
			}
		}

		return respuesta;
	}

	void handleClientException(ClientResponse<?> response) throws Throwable {

		throw response.getEntity(new GenericType<FailRespuesta<Exception>>() {
		}).getData();
	}
}
