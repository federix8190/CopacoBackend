package py.com.copaco.core.backend.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Arturo Volpe
 * @since 1.0
 * @version 1.0 Sep 16, 2014
 * 
 */
public class NotUniqueException extends ApplicationRuntimeException {

	private static final long serialVersionUID = 8098835307346695426L;

	@Getter
	@Setter
	private String constraint;

	public NotUniqueException(String constraint) {
		super("Not unique field: " + constraint);
		this.constraint = constraint;
		setCodigoError(300);
	}
}
