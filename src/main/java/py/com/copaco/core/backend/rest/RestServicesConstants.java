package py.com.copaco.core.backend.rest;

public interface RestServicesConstants {

	/**
	 * Nombre del parametro que indica los nombres de las columnas por las
	 * cuales se debe ordenar la lista resultante. El valor de este parametro
	 * debe ser una lista de nombres separados por coma y sin espacios, por
	 * ejemplo: "numeroContrato,numeroLinea".
	 */
	static final String ORDER_BY = "orderBy";

	/**
	 * Nombre del parametro que indica la direccion de ordenamiento por las
	 * cuales se debe ordenar la lista resultante. El valor de este parametro
	 * debe ser una lista de nombres separados por coma y sin espacios, por
	 * ejemplo: "ASC,DESC,ASC,ASC".
	 */
	static final String ORDER_DIR = "orderDir";

	/**
	 * Nombre del parametro que indica el numero de registro de inicio en las
	 * consultas paginadas.
	 */
	static final String PARAM_INICIO = "inicio";

	/**
	 * Nombre del parametro del query que indica la cantidad de registros a
	 * retornar en las consultas paginadas.
	 */
	static final String TOTAL_REGISTROS = "cantidad";

	/**
	 * Valor por defecto para el parametro {@link #PARAM_INICIO}.
	 */
	static final String VALUE_INICIO = "0";

	/**
	 * Valor por defecto para el parametro {@link #TOTAL_REGISTROS}.
	 */
	static final String VALUE_REGISTROS = "10";

	/**
	 * Valor por defecto para el parametro {@link #page}.
	 */
	static final String PAGINA_INICIO = "1";

}
