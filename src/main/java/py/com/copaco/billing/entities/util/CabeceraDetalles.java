package py.com.copaco.billing.entities.util;

import java.io.Serializable;
import java.util.List;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * @deprecated Usar {@link JsonIgnoreBackend} en vez de esto
 */
@Deprecated
public class CabeceraDetalles<C, D, E> implements Serializable {

	private static final long serialVersionUID = 1L;

	private C cabecera;
	private List<D> detalles;
	private List<E> detalles2;

	public C getCabecera() {
		return cabecera;
	}

	public void setCabecera(C cabecera) {
		this.cabecera = cabecera;
	}

	public List<D> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<D> detalles) {
		this.detalles = detalles;
	}

	public List<E> getDetalles2() {
		return detalles2;
	}

	public void setDetalles2(List<E> detalles2) {
		this.detalles2 = detalles2;
	}

}
