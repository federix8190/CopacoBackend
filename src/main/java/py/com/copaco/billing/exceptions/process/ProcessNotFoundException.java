package py.com.copaco.billing.exceptions.process;

import javax.ejb.ApplicationException;

/**
 * 
 * @author Arturo Volpe
 * @since 1.0
 * @version 1.0 Oct 14, 2014
 * 
 */
@ApplicationException(rollback = false)
public class ProcessNotFoundException extends ProcessException {

	private static final long serialVersionUID = 5555921895275757932L;

	public ProcessNotFoundException(Integer processId) {
		super("Proceso no encontrado " + processId);
	}

	public ProcessNotFoundException(String nombreId) {
		super("Proceso no encontrado con nombre " + nombreId);
	}

}
