package py.com.copaco.core.backend.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import py.com.copaco.core.backend.exception.ApplicationException;
import py.com.copaco.core.backend.exception.InternalError;

/**
 * 
 * @author Arturo Volpe
 * @since 1.0
 * @version 1.0 Sep 16, 2014
 * 
 */
@Provider
public class DefaultExceptionMapper implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception e) {

		FailRespuesta<ApplicationException> laRespuesta = new FailRespuesta<ApplicationException>();

		ApplicationException ae = new InternalError(e.getMessage(), e);
		laRespuesta.setData(ae);
		ae.printStackTrace();

		return laRespuesta.convertToHttpResponse();

	}

}
