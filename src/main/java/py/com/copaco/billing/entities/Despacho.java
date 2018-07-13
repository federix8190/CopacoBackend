package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * 
 * @author Monserrat Mora
 * @since 2.0
 * @version set 12, 2014
 * 
 * 
 */
@Entity
@EqualsAndHashCode(of = "codDespacho", callSuper = false)
@ToString(of = "codDespacho")
public class Despacho extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "despacho_seq", sequenceName = "despacho_seq", allocationSize = 1)
	@GeneratedValue(generator = "despacho_seq")
	@Column(name = "cod_despacho")
	private Integer codDespacho;

	private String activo;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	/*@OneToMany(mappedBy = "despacho")
	@JsonIgnoreBackend
	private List<Cuenta> cuentas;*/

	@ManyToOne
	@JoinColumn(name = "cod_lv_estado")
	private ListaValoresDet listaValoresDet;

	@OneToMany(mappedBy = "despacho", cascade = CascadeType.ALL)
	private List<DespachoDetalle> despachoDetalles;

	public Despacho() {
	}

	public Integer getCodDespacho() {
		return this.codDespacho;
	}

	public void setCodDespacho(Integer codDespacho) {
		this.codDespacho = codDespacho;
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

	/*public List<Cuenta> getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Cuenta addCuenta(Cuenta cuenta) {
		getCuentas().add(cuenta);
		cuenta.setDespacho(this);

		return cuenta;
	}

	public Cuenta removeCuenta(Cuenta cuenta) {
		getCuentas().remove(cuenta);
		cuenta.setDespacho(null);

		return cuenta;
	}*/

	public ListaValoresDet getListaValoresDet() {
		return this.listaValoresDet;
	}

	public void setListaValoresDet(ListaValoresDet listaValoresDet) {
		this.listaValoresDet = listaValoresDet;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	@JsonIgnoreBackend
	public List<DespachoDetalle> getDespachoDetalles() {
		return this.despachoDetalles;
	}
	
	@JsonProperty
	public void setDespachoDetalles(List<DespachoDetalle> despachoDetalles) {
		this.despachoDetalles = despachoDetalles;
	}

	public DespachoDetalle addDespachoDetalle(DespachoDetalle despachoDetalle) {
		getDespachoDetalles().add(despachoDetalle);
		despachoDetalle.setDespacho(this);

		return despachoDetalle;
	}

	public DespachoDetalle removeDespachoDetalle(DespachoDetalle despachoDetalle) {
		getDespachoDetalles().remove(despachoDetalle);
		despachoDetalle.setDespacho(null);

		return despachoDetalle;
	}

	@Override
	public Integer getId() {
		return getCodDespacho();
	}

}
