package py.com.copaco.billing.exceptions.process;

import py.com.copaco.billing.entities.Proceso;
import py.com.copaco.core.backend.exception.ApplicationException;

/**
 * 
 * @author Arturo Volpe
 *
 */
public class CanNotStartProcessException extends ApplicationException {

	private static final long serialVersionUID = 1L;

	public CanNotStartProcessException(String message) {

		super(message);
		setCodigoError(500);
	}

	public CanNotStartProcessException(Proceso proc, Throwable cause) {

		super("No se puede iniciar el proceso: " + proc.getNombre(), cause);
		setCodigoError(500);
	}

}
