package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

import lombok.Getter;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
public class Cliente extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_seq", allocationSize = 1)
	@GeneratedValue(generator = "cliente_seq")
	@Column(name = "cod_cliente")
	private Integer codCliente;

	private String activo;

	private String exento;

	private String apellidos;
	
	private String profesion;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Column(name = "cod_usuario_creacion")
	@Getter
	@Setter
	private String codUsuarioCreacion;
	
	private String email;

	@Column(name = "email_alternativo")
	private String emailAlternativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	@Getter
	@Setter
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_radicacion_temporal")
	private Date fechaRadicacionTemporal;

	private String nombres;
	
	@Column(name = "cedula_tributaria")
	@Getter
	@Setter
	private String cedulaTributaria;

	@Column(name = "numero_documento")
	private String numeroDocumento;

	@Column(name = "radicacion")
	private String radicacion;

	@Column(name = "tipo_persona")
	private String tipoPersona;
	
	@Column(name = "motivo_modificacion")
	private String motivoModificacion;
	
	@Column(name = "entidad_retentora")
	private String entidadRetentora;

	// bi-directional many-to-one association to Direccion
	@ManyToOne
	@JoinColumn(name = "cod_direccion")
	private Direccion direccion;

	// bi-directional many-to-one association to ListaValoresDet
	@ManyToOne
	@JoinColumn(name = "cod_lv_tipo")
	private ListaValoresDet listaValoresDet1;

	// bi-directional many-to-one association to ListaValoresDet
	@ManyToOne
	@JoinColumn(name = "tipo_privado_lv")
	private ListaValoresDet listaValoresDet2;

	// bi-directional many-to-one association to ListaValoresDet
	@ManyToOne
	@JoinColumn(name = "pais_lv")
	private ListaValoresDet listaValoresDet3;

	// bi-directional many-to-one association to ListaValoresDet
	@ManyToOne
	@JoinColumn(name = "tipo_estado_lv")
	private ListaValoresDet listaValoresDet4;

	// bi-directional many-to-one association to ListaValoresDet
	@ManyToOne
	@JoinColumn(name = "nivel_pago_lv")
	private ListaValoresDet listaValoresDet5;

	// bi-directional many-to-one association to TipoDocumento
	@ManyToOne
	@JoinColumn(name = "cod_tipo_documento")
	private TipoDocumento tipoDocumento;

	// bi-directional many-to-one association to Contacto
	@OneToMany(mappedBy = "cliente")
	private List<Contacto> contactos;

	// bi-directional many-to-one association to Direccion
	@OneToMany(mappedBy = "cliente")
	private List<Direccion> direccions;



	public Cliente() {
	}

	public String getMotivoModificacion(){
		return motivoModificacion;
	}

	public void setMotivoModificacion(String motivoModificacion){
		this.motivoModificacion = motivoModificacion;
	}

	public Integer getCodCliente() {
		return this.codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getApellidos() {
		
		if(this.apellidos == null)
			return "";
		else
			return this.apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getProfesion() {
		return this.profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getCodUsuarioModificacion() {
		return this.codUsuarioModificacion;
	}

	public void setCodUsuarioModificacion(String codUsuarioModificacion) {
		this.codUsuarioModificacion = codUsuarioModificacion;
	}

	public String getExento() {
		return exento;
	}

	public void setExento(String exento) {
		this.exento = exento;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailAlternativo() {
		return emailAlternativo;
	}

	public void setEmailAlternativo(String emailAlternativo) {
		this.emailAlternativo = emailAlternativo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaRadicacionTemporal() {
		return fechaRadicacionTemporal;
	}

	public void setFechaRadicacionTemporal(Date fechaRadicacionTemporal) {
		this.fechaRadicacionTemporal = fechaRadicacionTemporal;
	}

	public String getRadicacion() {
		return radicacion;
	}

	public void setRadicacion(String radicacion) {
		this.radicacion = radicacion;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public ListaValoresDet getListaValoresDet1() {
		return listaValoresDet1;
	}

	public void setListaValoresDet1(ListaValoresDet listaValoresDet1) {
		this.listaValoresDet1 = listaValoresDet1;
	}

	public ListaValoresDet getListaValoresDet2() {
		return listaValoresDet2;
	}

	public void setListaValoresDet2(ListaValoresDet listaValoresDet2) {
		this.listaValoresDet2 = listaValoresDet2;
	}

	public ListaValoresDet getListaValoresDet3() {
		return listaValoresDet3;
	}

	public void setListaValoresDet3(ListaValoresDet listaValoresDet3) {
		this.listaValoresDet3 = listaValoresDet3;
	}

	public ListaValoresDet getListaValoresDet4() {
		return listaValoresDet4;
	}

	public void setListaValoresDet4(ListaValoresDet listaValoresDet4) {
		this.listaValoresDet4 = listaValoresDet4;
	}

	public ListaValoresDet getListaValoresDet5() {
		return listaValoresDet5;
	}

	public void setListaValoresDet5(ListaValoresDet listaValoresDet5) {
		this.listaValoresDet5 = listaValoresDet5;
	}

	@JsonIgnore
	public List<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public Contacto addContacto(Contacto contacto) {
		getContactos().add(contacto);
		contacto.setCliente(this);

		return contacto;
	}

	public Contacto removeContacto(Contacto contacto) {
		getContactos().remove(contacto);
		contacto.setCliente(null);

		return contacto;
	}

	public TipoDocumento getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@JsonIgnore
	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}

	public Direccion addDireccion(Direccion direccion) {
		getDireccions().add(direccion);
		direccion.setCliente(this);

		return direccion;
	}

	public Direccion removeDireccion(Direccion direccion) {
		getDireccions().remove(direccion);
		direccion.setCliente(null);

		return direccion;
	}

	

	@Override
	public Integer getId() {
		return codCliente;
	}

	public String getEntidadRetentora() {
		return entidadRetentora;
	}

	public void setEntidadRetentora(String entidadRetentora) {
		this.entidadRetentora = entidadRetentora;
	}
}
