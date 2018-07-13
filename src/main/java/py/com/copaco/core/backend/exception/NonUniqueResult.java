package py.com.copaco.core.backend.exception;

public class NonUniqueResult extends ApplicationException {

	private static final long serialVersionUID = 1149303182428995606L;

	public NonUniqueResult(String message) {

		super(message);
		setCodigoError(400);
	}

}