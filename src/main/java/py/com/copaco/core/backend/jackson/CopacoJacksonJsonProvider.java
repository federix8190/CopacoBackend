/**
 * 
 */
package py.com.copaco.core.backend.jackson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;

import javax.enterprise.context.RequestScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectMapper.DefaultTyping;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

/**
 * @author Mirta Gonzalez
 * @author Arturo Volpe
 * @since 2.0
 * @version 2.0 02/09/2014
 */

@Provider
@Produces(MediaType.APPLICATION_JSON)

public class CopacoJacksonJsonProvider implements ContextResolver<ObjectMapper> {
	private final ObjectMapper objectMapper;

	public CopacoJacksonJsonProvider() {
		objectMapper = new ObjectMapper();
		objectMapper.configure(
				SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);

		AnnotationIntrospector intr = new AnnotationIntrospector.Pair(
				new JaxbAnnotationIntrospector(),
				new CopacoJacksonAnnotationIntrospector());

		objectMapper.setAnnotationIntrospector(intr);
		objectMapper.enableDefaultTypingAsProperty(
				DefaultTyping.OBJECT_AND_NON_CONCRETE, "class");
		objectMapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	@Override
	public ObjectMapper getContext(Class<?> objectType) {	
		return objectMapper;
	}

	/**
	 * {@link JacksonAnnotationIntrospector} que permite utilizar la anotación
	 * {@link JsonIgnoreBackend}.
	 * 
	 * <p>
	 * Entra en acción si (estar activo significa que se ignora aquello que
	 * tiene {@link JsonIgnoreBackend}):
	 * <ol>
	 * <li>Existe un <code>web.xml</code> con lo siguiente:
	 * 
	 * <pre>
	 * 	{@literal <}env-entry{@literal >}
	 * 		{@literal <}env-entry-name{@literal >}py.com.copaco.core.jackson.ENABLED{@literal <}/env-entry-name{@literal >}
	 * 		{@literal <}env-entry-type{@literal >}java.lang.Boolean{@literal <}/env-entry-type{@literal >}
	 * 		{@literal <}env-entry-value{@literal >}true{@literal <}/env-entry-value{@literal >}
	 * 	{@literal <}/env-entry{@literal >}
	 * </pre>
	 * 
	 * Entonces estará activo.</li>
	 * <li>Si no existe esta propiedad, entonces estará activo (el valor por
	 * defecto cuando existe un <code>web.xml</code> es que este activo.</li>
	 * <li>Si no existe un web.xml estara desactivado</li>
	 * </ol>
	 * 
	 * @author Arturo Volpe
	 * 
	 */
	private static class CopacoJacksonAnnotationIntrospector extends
			JacksonAnnotationIntrospector {

		private boolean enabled;

		public CopacoJacksonAnnotationIntrospector() {
			//enabled = true;
			
			
			/*Context env;
			try {
				env = (Context) new InitialContext().lookup("java:comp/env");
				//System.out.println("Name in namespace "+env.getNameInNamespace());
			} catch (NamingException e) {
				throw new RuntimeException("Can't get initial context", e);
			}
			try {
				Boolean isEnabled = (Boolean) env
						.lookup("py.com.copaco.core.jackson.ENABLED");
				enabled = isEnabled;
			} catch (NamingException e) {
				enabled = true;
			}*/
		}

		@Override
		protected boolean _isIgnorable(Annotated a) {
			return super._isIgnorable(a) || hasJsonIgnoreBackend(a);
		}

		/**
		 * XXX debería ser suficiente con el otro flujo pero no es así, se
		 * requiere buscar el método java, y quitar sus anotaciones. EL problema
		 * es que este copacoJackson esta cacheado, y la clase que el tiene
		 * JsonIgnoreBackend, es diferente, a la calse JsonIgnoreBackend que
		 * tiene el objeto a ser serializado.
		 * <p>
		 * Esto proboca que si hacemos:
		 * 
		 * <pre>
		 * a.getAnnotated().getAnnotation(JsonIgnoreBackend.class)
		 * </pre>
		 * 
		 * Retorne <code>null</code>, cuando sí tiene una anotación con el
		 * nombre {@link JsonIgnoreBackend}, pero no cargada por el mismo
		 * classloader que el objeto que estamos analizando ahora.
		 * </p>
		 * <p>
		 * Como cada ear tiene un classloader independiente, el primer ear, si
		 * comparte la misma anotación, pero los siguientes ear deployados,
		 * tendrán {@link JsonIgnoreBackend} cargados por su classloader, y por
		 * consiguiente, distintos al que cargo esta clase (que es el primero).
		 * </p>
		 * <p>
		 * <b>Por eso, se utiliza una comparación de cadenas, ya que el nombre
		 * es el mismo, y finalmente la anotación será la misma</b>. Esto impide
		 * que se pueda realizar lo siguiente:
		 * 
		 * <pre>
		 * for (Annotation anotation : meth.getAnnotations()) {
		 * 	if (anotation.annotationType().getSimpleName()
		 * 			.equals(JsonIgnoreBackend.class.getSimpleName())) {
		 * 		JsonIgnoreBackend jib = (JsonIgnoreBackend) anotation;
		 * 	}
		 * }
		 * </pre>
		 * 
		 * Lance un {@link ClassCastException}.
		 * </p>
		 * 
		 * TODO: manejar la herencia de {@link Annotated}.
		 * 
		 * @param a
		 *            annotated a ser validado,
		 *            {@link Annotated#getAnnotation(Class)} es utilizado para
		 *            recuperar la anotación, siempre.
		 * @return <code>true</code> si tiene la anotación y esta habilitado,
		 *         false en caso contrario.
		 */
		protected boolean hasJsonIgnoreBackend(Annotated a) {
			
			
			/*if (!enabled)
				return false;*/
			if (a instanceof AnnotatedMethod) {
				AnnotatedMethod am = (AnnotatedMethod) a;
				Method meth = (Method) am.getMember();
				
				//System.out.println("Entro 1 "+meth);
				if(meth!=null){
					//System.out.println("Entro 2 "+meth.getDeclaringClass());
					if(meth.getDeclaringClass()!=null){
						//System.out.println("Entro 3 "+meth.getDeclaringClass().getClassLoader());
					}
				}
				if(meth!=null && meth.getDeclaringClass()!=null && meth.getDeclaringClass().getClassLoader()!=null){
					URL result = meth.getDeclaringClass().getClassLoader().getResource("/py/com/copaco/billing/frontend/crm/backings/ContratoMB.class");
					//System.out.print("Entrooo");
					if(result!=null){
						//System.out.println("La url que retorna es: "+result.toString());
						enabled = false;
						return false;
						
					}
					else {
						enabled = true;
						//System.out.println("No viene del front");
					}
				}
				for (Annotation anotation : meth.getAnnotations())
					if (anotation.annotationType().getSimpleName()
							.equals(JsonIgnoreBackend.class.getSimpleName()))
						return true;
			}
			JsonIgnoreBackend ann = a.getAnnotation(JsonIgnoreBackend.class);
			return (ann != null && ann.value());
		}
	}

}