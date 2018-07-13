package py.com.copaco.billing.exceptions.process;

/**
 * 
 * @author Arturo Volpe
 * @since 1.0
 * @version 1.0 Oct 14, 2014
 * 
 */
public class ProcessStartedException extends ProcessException {

	private static final long serialVersionUID = 5555921895275757932L;

	public ProcessStartedException(Integer processId) {
		super("El proceso ya inicio y no admite varias ejecuciones paralelas: " + processId);
	}

}
