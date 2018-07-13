package py.com.copaco.billing.exceptions.process;

import py.com.copaco.core.backend.exception.ApplicationRuntimeException;

/**
 * 
 * @author Arturo Volpe
 * @since 1.0
 * @version 1.0 Oct 16, 2014
 */
public class ProcessException extends ApplicationRuntimeException {

	private static final long serialVersionUID = 1L;

	public ProcessException(String message) {
		super(message);
	}

	public ProcessException(String message, Throwable cause) {
		super(message, cause);
	}
}
