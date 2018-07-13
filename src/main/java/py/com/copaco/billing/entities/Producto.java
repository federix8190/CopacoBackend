package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * @author Monserrat Mora
 * @since 2.0
 * @version set 12, 2014
 * 
 * Modificado por:
 * @author Monserrat Mora
 * @version Dic 15, 2015
 * cambios: 
 * se eliminan los campos cantidadMaxima, cantidadMinima, unidad_medida
 * se agrega el campo formaInstalacion
 */

@Entity
@EqualsAndHashCode(of = "codProducto", callSuper = false)
@ToString(of = "codProducto")
public class Producto extends BaseEntity<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_producto")
	private String codProducto;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String descripcion;

	private String activo;
	
	@Column(name = "forma_instalacion")
	private String formaInstalacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@OneToMany(mappedBy = "producto")
	private List<Oferta> ofertas;

	@ManyToOne
	@JoinColumn(name = "cod_lv_estado")
	private ListaValoresDet listaValoresDet1;

	@ManyToOne
	@JoinColumn(name = "cod_lv_tipo")
	private ListaValoresDet listaValoresDet2;

	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	private List<ServiciosProducto> serviciosProductos;

	public Producto() {
	}

	public String getCodProducto() {
		return this.codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getCodUsuarioModificacion() {
		return this.codUsuarioModificacion;
	}

	public void setCodUsuarioModificacion(String codUsuarioModificacion) {
		this.codUsuarioModificacion = codUsuarioModificacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	@JsonIgnoreBackend
	public List<Oferta> getOfertas() {
		return this.ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	public Oferta addOferta(Oferta oferta) {
		getOfertas().add(oferta);
		oferta.setProducto(this);

		return oferta;
	}

	public Oferta removeOferta(Oferta oferta) {
		getOfertas().remove(oferta);
		oferta.setProducto(null);

		return oferta;
	}

	public ListaValoresDet getListaValoresDet1() {
		return this.listaValoresDet1;
	}

	public void setListaValoresDet1(ListaValoresDet listaValoresDet1) {
		this.listaValoresDet1 = listaValoresDet1;
	}

	public ListaValoresDet getListaValoresDet2() {
		return this.listaValoresDet2;
	}

	public void setListaValoresDet2(ListaValoresDet listaValoresDet2) {
		this.listaValoresDet2 = listaValoresDet2;
	}

	@JsonIgnoreBackend
	public List<ServiciosProducto> getServiciosProductos() {
		return this.serviciosProductos;
	}

	@JsonProperty
	public void setServiciosProductos(List<ServiciosProducto> serviciosProductos) {
		this.serviciosProductos = serviciosProductos;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}
	
	public String getFormaInstalacion() {
		return formaInstalacion;
	}

	public void setFormaInstalacion(String formaInstalacion) {
		this.formaInstalacion = formaInstalacion;
	}

	@Override
	public String getId() {
		return getCodProducto();
	}

}