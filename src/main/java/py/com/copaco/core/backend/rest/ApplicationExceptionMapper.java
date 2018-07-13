package py.com.copaco.core.backend.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import py.com.copaco.core.backend.exception.ApplicationException;

@Provider
public class ApplicationExceptionMapper implements
		ExceptionMapper<ApplicationException> {

	@Override
	public Response toResponse(ApplicationException e) {

		FailRespuesta<ApplicationException> laRespuesta = new FailRespuesta<ApplicationException>();
		ApplicationException ae = (ApplicationException) e;
		laRespuesta.setData(ae);
		return laRespuesta.convertToHttpResponse();

	}

}
