package py.com.copaco.core.backend.util;

public class FrontendUtils {

	private static final String TIPO_IDENT_CLASE = "class";
	private static final String TIPO_IDENT_ATRIBUTO = "atribute";

	public static String toCamelCase(String cadena, String tipo) throws Exception {
		String[] subCadenas = cadena.split("_");
		StringBuilder camelCase = null;
		String subCadena;
		if (!TIPO_IDENT_ATRIBUTO.equalsIgnoreCase(tipo)
				&& !TIPO_IDENT_CLASE.equalsIgnoreCase(tipo)) {
			throw new Exception(
					"Tipo de cadena destino desconocido, verifique.");
		}
		camelCase = new StringBuilder();
		for (int i = 0; i < subCadenas.length; i++) {
			subCadena = subCadenas[i];
			if (TIPO_IDENT_ATRIBUTO.equalsIgnoreCase(tipo) && i == 0) {
				camelCase.append(subCadena.substring(0, 1).toLowerCase());
			} else {
				camelCase.append(subCadena.substring(0, 1).toUpperCase());
			}
			camelCase.append(subCadena.substring(1).toLowerCase());
		}
		return camelCase.toString();
	}

}
