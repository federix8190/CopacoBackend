package py.com.copaco.core.backend.rest;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

/**
 * Wrap de la excepión lanzada para que contenga el mismo formato que todas las
 * respuesta.
 * 
 * @author Arturo Volpe
 * @since 1.0
 * @version 1.0 Sep 9, 2014
 * 
 */
public class FailRespuesta<T extends Exception> extends Respuesta<T> {

	public FailRespuesta() {

		this(null);
	}

	public FailRespuesta(T data) {

		super(data);
	}

	public Response convertToHttpResponse() {

		return Response
				.status(500)
				.header(HttpHeaders.CONTENT_TYPE,
						"application/json;charset=UTF-8").entity(this).build();

	}

}
