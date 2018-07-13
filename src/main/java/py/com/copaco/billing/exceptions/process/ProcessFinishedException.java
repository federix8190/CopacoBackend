package py.com.copaco.billing.exceptions.process;

import py.com.copaco.billing.entities.InstanciaProceso;

/**
 * 
 * @author Arturo Volpe
 * @since 1.0
 * @version 1.0 Oct 14, 2014
 * 
 */
public class ProcessFinishedException extends ProcessException {

	private static final long serialVersionUID = 5555921895275757932L;

	private static final String TEMPLATE = "La instancia '##INSTANCIA##' del proceso '##PROCESS##' ya finalizo";

	ProcessFinishedException(String message) {
		super(message);
	}

	public ProcessFinishedException(InstanciaProceso id) {
		this(TEMPLATE.replace("##INSTANCIA##",
				id.getCodInstanciaProceso().toString()).replace("##PROCESS##",
				id.getProceso().getDescripcion()));
	}

}
