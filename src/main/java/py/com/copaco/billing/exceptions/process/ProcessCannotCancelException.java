package py.com.copaco.billing.exceptions.process;

/**
 * 
 * @author Arturo Volpe
 * @since 1.0
 * @version 1.0 Oct 14, 2014
 * 
 */
public class ProcessCannotCancelException extends ProcessException {

	private static final long serialVersionUID = 5555921895275757932L;

	ProcessCannotCancelException(String message) {
		super(message);
	}

	public ProcessCannotCancelException(Integer processId) {
		this(
				"No se puede parar el proceso "
						+ processId
						+ ", si "
						+ "el proceso controla si debe ser cancelado se cancelara, revisar el estado del proceso");
	}

}
