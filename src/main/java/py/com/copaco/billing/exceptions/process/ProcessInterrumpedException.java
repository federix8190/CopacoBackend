package py.com.copaco.billing.exceptions.process;

/**
 * 
 * @author Arturo Volpe
 * @since 1.0
 * @version 1.0 Oct 16, 2014
 */
public class ProcessInterrumpedException extends ProcessException {

	private static final long serialVersionUID = 1L;

	public ProcessInterrumpedException(String message) {
		super("Proceso interrumpido. " + message);
	}

}
