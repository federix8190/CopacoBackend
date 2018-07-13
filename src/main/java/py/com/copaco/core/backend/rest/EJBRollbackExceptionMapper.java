package py.com.copaco.core.backend.rest;

import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.RollbackException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.GenericJDBCException;

import py.com.copaco.core.backend.exception.ApplicationRuntimeException;
import py.com.copaco.core.backend.exception.NotUniqueException;
import py.com.copaco.core.backend.model.ConstraintToExceptionMapper;

/**
 * 
 * @author Arturo Volpe
 * @since 1.0
 * @version 1.0 Sep 16, 2014
 * 
 */
@Provider
public class EJBRollbackExceptionMapper implements
		ExceptionMapper<EJBException> {

	@Inject
	private ConstraintToExceptionMapper mapper;

	@Override
	public Response toResponse(EJBException exception) {
		Response response = null;
		if (exception.getCause() instanceof RollbackException)
			response = handleRollbackException((RollbackException) exception
					.getCause());
		if (exception.getCause() instanceof PersistenceException)
			response = handlePersistenceException((PersistenceException) exception
					.getCause());
		return response;
	}

	private Response handleRollbackException(RollbackException exception) {

		if (exception.getCause() instanceof PersistenceException)
			return handlePersistenceException((PersistenceException) exception
					.getCause());
		return null;
	}

	private Response handlePersistenceException(PersistenceException exception) {
		if (exception.getCause() instanceof ConstraintViolationException)
			return handleConstraintViolationException((ConstraintViolationException) exception
					.getCause());
		if (exception.getCause() instanceof GenericJDBCException)
			return handleGenericJDBCException((GenericJDBCException) exception
					.getCause());
		return null;
	}

	private Response handleGenericJDBCException(GenericJDBCException cause) {
		Throwable previous = cause;
		Throwable next = previous.getCause();
		while (next != null && next != previous) {
			if (next.getMessage().contains(
					"duplicate value for a record with unique key")) {
				return throwUnique(next, "undefined");
			}
			previous = next;
			next = next.getCause();
			
		}
		return null;
	}

	private Response throwUnique(Throwable exception, String name) {

		return new FailRespuesta<ApplicationRuntimeException>(
				new NotUniqueException(name)).convertToHttpResponse();
	}

	private Response handleConstraintViolationException(
			ConstraintViolationException exception) {

		return new FailRespuesta<ApplicationRuntimeException>(
				mapper.mapException(exception.getConstraintName(), exception))
				.convertToHttpResponse();
	}
}
