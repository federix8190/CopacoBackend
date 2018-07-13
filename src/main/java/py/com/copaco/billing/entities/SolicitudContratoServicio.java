package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The persistent class for the solicitud_contrato_servicio database table.
 * 
 */
@Entity
@Table(name = "solicitud_contrato_servicio")
@Data
@EqualsAndHashCode(of = "codSolicitudContratoServicio", callSuper = false)
@ToString(of = "codSolicitudContratoServicio")

public class SolicitudContratoServicio extends BaseEntity<Integer> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "solicitud_contrato_servicio_seq", sequenceName = "solicitud_contrato_servicio_seq", allocationSize = 1)
	@GeneratedValue(generator = "solicitud_contrato_servicio_seq")
	@Column(name = "cod_solicitud_contrato_servicio_pk")
	private Integer codSolicitudContratoServicio;
	
	@Column(name = "bloqueo_numero")
	private String bloqueoNumero;
	
	@Column(name = "cambio_numero")
	private String cambioNumero;
	
	@Column(name = "tipo_acceso")
	private String tipoAcceso;
	
	@Column(name= "reserva")
	private String reserva;
	
	@ManyToOne
	@JoinColumn(name = "cod_solicitud")
	private Solicitud solicitud;
	
	/*@Column(name= "cod_solicitud")
	private Integer solicitud;*/
	
	@ManyToOne
	@JoinColumn(name = "cod_servicio")
	private Servicio servicio;
	
	//@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@ManyToOne
	@JoinColumn(name = "cod_direccion_inst")
	//@Column(name= "cod_direccion_inst")
	private Direccion direccionInstalacion;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "cod_montar_contrato_servicio")
	private ContratoServicio montarContratoServicio;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.ALL, CascadeType.PERSIST})
	@JoinColumn(name = "cod_montar_solicitud_contrato_servicio")
	private SolicitudContratoServicio montarSolicitudContratoServicio;
	
	@ManyToOne
	@JoinColumn(name = "cod_contrato_servicio")
	private ContratoServicio contratoServicio;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "cod_red_alambrica_tmp_1")
	private RedAlambricaTmp redAlambricaTmp1;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "cod_red_alambrica_tmp_2")
	private RedAlambricaTmp redAlambricaTmp2;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "cod_red_alambrica_tmp_3")
	private RedAlambricaTmp redAlambricaTmp3;
	
	/*@ManyToOne
	@JoinColumn(name = "cod_red_adsl")
	private RedADSL redADSL;*/
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "cod_red_inalambrica")
	private RedInalambrica redInalambrica;
	
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return this.codSolicitudContratoServicio;
	}
	
}
