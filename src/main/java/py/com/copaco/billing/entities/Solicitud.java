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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * The persistent class for the solicitud database table.
 * 
 */
@Entity
@Table(name = "solicitud")
@Data
@EqualsAndHashCode(of = "codSolicitud", callSuper = false)
@ToString(of = "codSolicitud")

public class Solicitud extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "solicitud_seq", sequenceName = "solicitud_seq", allocationSize = 1)
	@GeneratedValue(generator = "solicitud_seq")
	@Column(name = "cod_solicitud")
	private Integer codSolicitud;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_solicitud")
	private Date fecha;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_aprobacion")
	private Date fechaAprobacion;

	@Column(name = "numero_referencia")
	private String numeroReferencia;

	/*Indica que si la solicitud se realizara con reserva previa de recursos antes de la 
	 * antes del analisis de requerimientos*/
	@Column(name = "con_reserva")
	private String conReserva;
	
	@Column(name = "asume_deuda")
	private String asumeDeuda;
	
	@Column(name = "transfiere_deuda")
	private String transfiereDeuda;

	@Column(name = "control_calidad")
	private String controlCalidad;

	@ManyToOne
	@JoinColumn(name = "cod_lv_estado")
	private ListaValoresDet lvEstado;

	@ManyToOne
	@JoinColumn(name = "cod_lv_tipo")
	private ListaValoresDet lvTipo;

	@ManyToOne
	@JoinColumn(name = "cod_cliente_actual")
	private Cliente clienteActual;

	@ManyToOne
	@JoinColumn(name = "cod_cuenta_actual")
	private Cuenta cuentaActual;

	@ManyToOne
	@JoinColumn(name = "cod_cliente_nuevo")
	private Cliente clienteNuevo;

	@ManyToOne
	@JoinColumn(name = "cod_cliente_diferido")
	private Cliente clienteDiferido;

	@ManyToOne
	@JoinColumn(name = "cod_cuenta_nuevo")
	private Cuenta cuentaNuevo;

	@ManyToOne
	@JoinColumn(name = "cod_lv_motivo_estado")
	private ListaValoresDet lvMotivoEstado;

	@ManyToOne
	@JoinColumn(name = "cod_lv_cesion_titularidad")
	private ListaValoresDet lvCesionTitularidad;

	@Column(name = "nombres_cliente_nuevo")
	private String nombresClienteNuevo;

	@Column(name = "apellidos_cliente_nuevo")
	private String apellidosClienteNuevo;

	@Column(name = "email_cliente_nuevo")
	private String emailClienteNuevo;

	@Column(name = "tipo_persona_cliente_nuevo")
	private String tipoPersonaClienteNuevo;

	@Column(name = "exento_cliente_nuevo")
	private String exentoClienteNuevo;

	@Column(name = "telefono_cliente_nuevo")
	private String telefonoClienteNuevo;

	@Column(name = "nro_documento_cliente_nuevo")
	private String nroDocumentoClienteNuevo;

	@ManyToOne
	@JoinColumn(name = "cod_tipo_cuenta_nuevo")
	private TipoCuenta tipoCuentaNuevo;

	@ManyToOne
	@JoinColumn(name = "cod_tipo_documento_cliente_nuevo")
	private TipoDocumento tipoDocumentoClienteNuevo;

	@Column(name = "nombres_cliente_diferido")
	private String nombresClienteDiferido;

	@Column(name = "apellidos_cliente_diferido")
	private String apellidosClienteDiferido;

	@Column(name = "email_cliente_diferido")
	private String emailClienteDiferido;

	@Column(name = "tipo_persona_cliente_diferido")
	private String tipoPersonaClienteDiferido;

	@Column(name = "nro_documento_cliente_diferido")
	private String nroDocumentoClienteDiferido;

	@Column(name = "exento_cliente_diferido")
	private String exentoClienteDiferido;

	@Column(name = "telefono_cliente_diferido")
	private String telefonoClienteDiferido;

	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "solicitud", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<SolicitudContrato> listaSolicitudContrato;

	@ManyToOne
	@JoinColumn(name = "cod_oferta")
	private Oferta oferta;

	@ManyToOne
	@JoinColumn(name = "cod_tipo_documento_cliente_diferido")
	private TipoDocumento tipoDocumentoClienteDiferido;

	// bi-directional many-to-one association to SolicitudContratoServicio
	//@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	//@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "solicitud", cascade = { CascadeType.ALL})
	private List<SolicitudContratoServicio> solicitudContratosServicios;

	@ManyToOne
	@JoinColumn(name = "cod_tipo_documento_codeudor")
	private TipoDocumento tipoDocumentoCodeudor;

	@Column(name = "numero_documento_codeudor")
	private String nroDocumentoCodeudor;

	@Column(name = "nombres_codeudor")
	private String nombresCodeudor;

	@Column(name = "apellidos_codeudor")
	private String apellidosCodeudor;

	@Column(name = "email_codeudor")
	private String emailCodeudor;

	@Column(name = "numero_telefono_codeudor")
	private String telefonoCodeudor;

	@ManyToOne
	@JoinColumn(name = "cod_tipo_documento_contacto")
	private TipoDocumento tipoDocumentoContacto;

	@Column(name = "numero_documento_contacto")
	private String nroDocumentoContacto;

	@Column(name = "nombres_contacto")
	private String nombresContacto;

	@Column(name = "apellidos_contacto")
	private String apellidosContacto;

	@Column(name = "email_contacto")
	private String emailContacto;

	@Column(name = "numero_telefono_contacto")
	private String telefonoContacto;
	
	@Column(name = "instanceid")
	private Long instanciaId;

	@Override
	public Integer getId() {
		return this.codSolicitud;
	}
	
	@JsonProperty
	public void setSolicitudContratosServicios(List<SolicitudContratoServicio> lista){
		this.solicitudContratosServicios = lista;
	}
	
	@JsonIgnoreBackend
	public List<SolicitudContratoServicio> getSolicitudContratosServicios(){
		return this.solicitudContratosServicios;
	}

}
