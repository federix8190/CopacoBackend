/**
 * 
 */
package py.com.copaco.core.backend.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Arturo Volpe
 * @version 1.0 Nov 4, 2014
 */
public class CheckFailException extends ApplicationRuntimeException {

	private static final long serialVersionUID = 59507779212543046L;

	@Getter
	@Setter
	private String constraint;

	public CheckFailException(String constraint) {
		super("Check failed: " + constraint);
		this.constraint = constraint;
		setCodigoError(300);
	}
}
