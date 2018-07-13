package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * Clase que representa a la tabla reclamo_facturacion_det en la BD
 * 
 * @author Luis Fernandez
 * @version 1.0 May 27, 2015
 *
 */
@Entity
@Table(name = "reclamo_facturacion_det")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codReclamoFacturacionDet", callSuper = true)
public class ReclamoFacturacionDet extends BaseEntity<Integer> implements
		Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "reclamo_facturacion_det_seq", sequenceName = "reclamo_facturacion_det_seq", allocationSize = 1)
	@GeneratedValue(generator = "reclamo_facturacion_det_seq")
	@Column(name = "cod_reclamo_facturacion_det")
	private Integer codReclamoFacturacionDet;

	@Getter
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_evento")
	private Evento evento;

	@Getter
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_cargo_periodo_det")
	private CargoPeriodoDetalle cargoPeriodoDet;

	private String estado;

	private String moneda;

	private BigDecimal monto;

	@Column(name = "sys_cod_evt_ace")
	private Integer evtAce;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Getter
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne
	@JoinColumn(name = "cod_reclamo_facturacion_cab")
	private ReclamoFacturacionCab reclamoFacturacionCab;

	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "reclamoFacturacionDet")
	private List<Comentario> listaComentarios;
	
	@Column(name = "mora_fact")
	private String moraFact;

	@Override
	public Integer getId() {
		return codReclamoFacturacionDet;
	}

}
