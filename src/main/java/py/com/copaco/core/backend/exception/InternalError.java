package py.com.copaco.core.backend.exception;

public class InternalError extends ApplicationException {

	private static final long serialVersionUID = -3139036056656795230L;

	public InternalError(String message) {

		this(message, null);
	}

	public InternalError(String message, Throwable cause) {

		super(message, cause);
		setCodigoError(500);
	}

}