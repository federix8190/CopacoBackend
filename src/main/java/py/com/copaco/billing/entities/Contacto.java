package py.com.copaco.billing.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the contacto database table.
 * 
 */
@Entity
public class Contacto extends BaseEntity<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "contacto_seq", sequenceName = "contacto_seq", allocationSize = 1)
	@GeneratedValue(generator = "contacto_seq")
	@Column(name="cod_contacto")
	private Integer codContacto;

	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Column(name="nombres_apellidos")
	private String nombresApellidos;

	@Column(name="nro_documento")
	private String nroDocumento;

	private String observaciones;
	
	@Column(name="telefono_celular")
	private String telefonoCelular;

	@Column(name="telefono_celular_alternativo")
	private String telefonoCelularAlternativo;

	@Column(name="telefono_linea_fija")
	private String telefonoLineaFija;

	//bi-directional many-to-one association to ListaValoresDet
	@ManyToOne
	@JoinColumn(name="cod_lv_tipo")
	private ListaValoresDet listaValoresDet;
		
	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cod_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to TipoDocumento
	@ManyToOne
	@JoinColumn(name="cod_tipo_documento")
	private TipoDocumento tipoDocumento;

	public Contacto() {
	}

	public Integer getCodContacto() {
		return this.codContacto;
	}

	public void setCodContacto(Integer codContacto) {
		this.codContacto = codContacto;
	}

	public String getCodUsuarioModificacion() {
		return this.codUsuarioModificacion;
	}

	public void setCodUsuarioModificacion(String codUsuarioModificacion) {
		this.codUsuarioModificacion = codUsuarioModificacion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getNombresApellidos() {
		return this.nombresApellidos;
	}

	public void setNombresApellidos(String nombresApellidos) {
		this.nombresApellidos = nombresApellidos;
	}

	public String getNroDocumento() {
		return this.nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getTelefonoCelular() {
		return this.telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public String getTelefonoCelularAlternativo() {
		return this.telefonoCelularAlternativo;
	}

	public void setTelefonoCelularAlternativo(String telefonoCelularAlternativo) {
		this.telefonoCelularAlternativo = telefonoCelularAlternativo;
	}

	public String getTelefonoLineaFija() {
		return this.telefonoLineaFija;
	}

	public void setTelefonoLineaFija(String telefonoLineaFija) {
		this.telefonoLineaFija = telefonoLineaFija;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public ListaValoresDet getListaValoresDet() {
		return listaValoresDet;
	}

	public void setListaValoresDet(ListaValoresDet listaValoresDet) {
		this.listaValoresDet = listaValoresDet;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoDocumento getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return this.codContacto;
	}

}