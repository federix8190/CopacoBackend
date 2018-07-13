package py.com.copaco.billing.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * @author Claudia Valenzuela
 * @since 1.0
 * @version 26/08/2015
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codReclamo", callSuper = false)
@SuppressWarnings("serial")
@Table(name = "reclamo")
public class Reclamo extends BaseEntity<Integer> {

	@Id
	@Column(name = "cod_reclamo")
	@SequenceGenerator(name = "reclamo_seq", sequenceName = "reclamo_seq", allocationSize = 1)
	@GeneratedValue(generator = "reclamo_seq")
	private Integer codReclamo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_inicio")
	@NotNull
	private Date fechaInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_fin")
	private Date fechaFin;

	private String descripcion;

	@NotNull
	@Size(max = 2)
	private String estado;

	@NotNull
	private Integer prioridad;

	@NotNull
	@Size(max = 3)
	@Column(name = "tipo_reclamo")
	private String tipoReclamo;

	@Size(max = 100)
	@Column(name = "nombre_contacto")
	private String nombreContacto;

	@Size(max = 20)
	@Column(name = "telefono_contacto")
	private String telefonoContacto;

	@Size(max = 50)
	@Column(name = "mail_contacto")
	private String mailContacto;

	@Size(max = 200)
	@Column(name = "observacion_contacto")
	private String observacionContacto;

	@Column(name = "process_instance_id")
	private Integer processInstanceId;

	@Column(name = "cod_reclamo_monitor")
	private Integer codReclamoMonitor;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "cod_lv_error_reportado")
	private ListaValoresDet errorReportado;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "cod_contrato_servicio")
	private ContratoServicio contratoServicio;

	@OneToOne(mappedBy = "reclamo")
	private Solucion solucion;

	@NotNull
	@Column(name = "cod_usuario_registra")
	private String codUsuarioRegistra;

	@NotNull
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "reclamo", cascade = CascadeType.ALL)
	private List<ReincidenciaReclamo> reincidencias;

	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "reclamo", cascade = CascadeType.ALL)
	private List<Diagnostico> diagnosticos;

	@ManyToOne
	@JoinColumn(name = "cod_reclamo_pex")
	private ReclamoPex reclamoPex;

	@Override
	public Integer getId() {
		return codReclamo;
	}
}
