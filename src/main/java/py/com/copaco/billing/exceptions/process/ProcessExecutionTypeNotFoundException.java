package py.com.copaco.billing.exceptions.process;

/**
 * 
 * @author Arturo Volpe
 * @since 1.0
 * @version 1.0 Oct 14, 2014
 * 
 */
public class ProcessExecutionTypeNotFoundException extends ProcessException {

	private static final long serialVersionUID = 5555921895275757932L;

	public ProcessExecutionTypeNotFoundException(String tipo) {
		super("Tipo de ejecución de proceso no encontrado " + tipo);
	}

}
