package py.com.copaco.core.backend.exception;

public class NotFound extends ApplicationException {

	private static final long serialVersionUID = 1149303182428995606L;

	public NotFound(String message) {

		super(message);
		setCodigoError(404);
	}

}