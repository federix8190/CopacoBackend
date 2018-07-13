package py.com.copaco.core.backend.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import py.com.copaco.core.backend.exception.ApplicationRuntimeException;

@Provider
public class ApplicationRuntimeExceptionMapper implements
        ExceptionMapper<ApplicationRuntimeException> {

    @Override
    public Response toResponse(ApplicationRuntimeException e) {

        FailRespuesta<ApplicationRuntimeException> laRespuesta = new FailRespuesta<>();

        ApplicationRuntimeException ae = (ApplicationRuntimeException) e;
        laRespuesta.setData(ae);

        return laRespuesta.convertToHttpResponse();

    }

}
