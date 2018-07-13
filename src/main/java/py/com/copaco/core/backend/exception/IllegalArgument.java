package py.com.copaco.core.backend.exception;

import lombok.Getter;
import lombok.Setter;

public class IllegalArgument extends ApplicationException {

	private static final long serialVersionUID = -8765864922699868014L;

	@Getter
	@Setter
	private String argumento;

	public IllegalArgument() {
		this(null, null);
	}

	public IllegalArgument(String message, String argumento) {

		super(message);
		setCodigoError(400);
		setArgumento(argumento);
	}
}