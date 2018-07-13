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
public class ReferencedKeyException extends ApplicationRuntimeException {

	private static final long serialVersionUID = 59507779212543046L;

	@Getter
	@Setter
	private String constraint;

	public ReferencedKeyException(String constraint) {
		super("Table is referenced: " + constraint);
		this.constraint = constraint;
		setCodigoError(300);
	}
}
