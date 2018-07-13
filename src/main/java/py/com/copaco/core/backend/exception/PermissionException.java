package py.com.copaco.core.backend.exception;

import lombok.Getter;
import lombok.Setter;

public class PermissionException extends ApplicationException {


	private static final long serialVersionUID = -1589232504988471546L;

	/**
	 * 
	 */
	@Getter
	@Setter
	private String constraint;
	
	public PermissionException(String constraint) {
		super("Permission required to: " + constraint);
		this.constraint = constraint;
		setCodigoError(403);
	}

}