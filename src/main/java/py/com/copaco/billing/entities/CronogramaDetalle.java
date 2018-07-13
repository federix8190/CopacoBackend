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

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the cronograma_det database table.
 * 
 */
@Entity
@Table(name = "cronograma_det")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codCronogramaDet", callSuper = true)
public class CronogramaDetalle extends BaseEntity<Integer> implements
		Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "cronograma_det_seq", sequenceName = "cronograma_det_seq", allocationSize = 1)
	@GeneratedValue(generator = "cronograma_det_seq")
	@Column(name = "cod_cronograma_det")
	private Integer codCronogramaDet;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "consumo_cierre")
	private Date consumoCierre;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "consumo_desde")
	private Date consumoDesde;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "consumo_hasta")
	private Date consumoHasta;

	@Column(name = "dc_inicio_remision")
	private Integer dcInicioRemision;

	@Column(name = "dc_remision_recepcion")
	private Integer dcRemisionRecepcion;

	@Column(name = "dc_remision_vencimiento")
	private Integer dcRemisionVencimiento;

	@Column(name = "dc_vencimiento_recepcion")
	private Integer dcVencimientoRecepcion;

	@Column(name = "dh_inicio_remision")
	private Integer dhInicioRemision;

	@Column(name = "dh_remision_recepcion")
	private Integer dhRemisionRecepcion;

	@Column(name = "dh_remision_vencimiento")
	private Integer dhRemisionVencimiento;

	@Column(name = "dh_vencimiento_recepcion")
	private Integer dhVencimientoRecepcion;

	@Column(name = "dias_facturados")
	private Integer diasFacturados;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "factura_inicio")
	private Date facturaInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "factura_recepcion")
	private Date facturaRecepcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "factura_remision")
	private Date facturaRemision;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "factura_vencimiento")
	private Date facturaVencimiento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@ManyToOne
	@JoinColumn(name = "cod_cronograma_cab")
	private Cronograma cronograma;
	
	@Column(name = "mes_corriente")
	private String mesCorriente;
	

	// se agrega para probar los temas referentes a dialogos
	// detalles asociados a cada cronogramaDetalle

	@Getter(onMethod=@_({@JsonIgnoreBackend}))
	@Setter(onMethod=@_(@JsonProperty))
	@OneToMany(mappedBy = "cronogramaDetalle", cascade = CascadeType.ALL)
	private List<CronogramaDetalleServicio> detallesServicio;
	
	
	@Override
	public Integer getId() {

		return codCronogramaDet;
	}

}