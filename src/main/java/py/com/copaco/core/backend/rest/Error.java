package py.com.copaco.core.backend.rest;

import java.util.List;

public class Error {

	private String codigo;
	private List<String> mensajes;

	public Error() {

	}

	/**
	 * 
	 * @param codigo
	 * @param mensaje
	 */
	public Error(String codigo, List<String> mensajes) {

		this.codigo = codigo;
		this.mensajes = mensajes;
	}

	/**
	 * 
	 * @return
	 */
	public String getCodigo() {

		return codigo;
	}

	/**
	 * 
	 * @param codigo
	 */
	public void setCodigo(String codigo) {

		this.codigo = codigo;
	}

	/**
	 * 
	 * @return
	 */
	public List<String> getMensajes() {

		return mensajes;
	}

	/**
	 * 
	 * @param mensaje
	 */
	public void setMensajes(List<String> mensajes) {

		this.mensajes = mensajes;
	}
}
