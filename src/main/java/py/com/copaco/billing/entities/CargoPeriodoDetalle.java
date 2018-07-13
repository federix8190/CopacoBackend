package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Mauro Vera
 * @since 1.0
 * @version 1.0 Sep 24, 2014
 *
 */

/**
 *
 * @author Mirta Gonzalez
 * @since 2.0
 * @version 22/10/2014
 */

@Entity
@Table(name = "cargo_periodo_det")
@Data
@ToString(of = "codCargoPeriodoDetalle")
@NoArgsConstructor
@EqualsAndHashCode(of = "codCargoPeriodoDetalle", callSuper = true)
public class CargoPeriodoDetalle extends BaseEntity<Integer> implements
		Serializable {

	private static final long serialVersionUID = 7838590699745025102L;

	@Id
	@SequenceGenerator(name = "cargo_periodo_det_seq", sequenceName = "cargo_periodo_det_seq", allocationSize = 1)
	@GeneratedValue(generator = "cargo_periodo_det_seq")
	@Column(name = "cod_cargo_periodo_det")
	private Integer codCargoPeriodoDetalle;

	@Column(name = "cantidad")
	private Integer cantidad;

	//@ManyToOne(fetch=FetchType.LAZY)
	@ManyToOne()
	@JoinColumn(name = "cod_cargo_periodo_cab")
	private CargoPeriodoCabecera cargoPeriodoCabecera;

	@ManyToOne
	@JoinColumn(name = "cod_concepto")
	private Concepto concepto;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Column(name = "monto")
	private Double monto;

	@Column(name = "unidades_tasadas")
	private Integer unidadesTasadas;

	@Column(name = "moneda")
	private String moneda;

	@Column(name = "monto_moneda_local")
	private Double montoMonedaLocal;

	@Column(name = "importe_impuesto")
	private Double importeImpuesto;

	@Column(name = "importe_impuesto_moneda_local")
	private Double importeImpuestoMonedaLocal;
	
	@ManyToOne
	@JoinColumn(name = "cod_contrato_servicio")
	private ContratoServicio contratoServicio;
	
	@Column(name = "tipo_impuesto")
	private String tipoImpuesto;

	@Override
	public Integer getId() {
		return codCargoPeriodoDetalle;
	}

    /**
     * Define si una moneda es local.
     */
	@JsonIgnore
	public boolean isLocal() {
		return "PYG".equals(moneda);
	}

}
