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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
/**
 * Entity implementation class for Entity: Descuento
 * 
 */
/**
 * 
 * @author Mirta Gonzalez
 * @since 2.0
 * @version 22/10/2014
 */

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codDescuento", callSuper = true)
public class Descuento extends BaseEntity<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "descuento_seq", sequenceName = "descuento_seq", allocationSize = 1)
	@GeneratedValue(generator = "descuento_seq")
	@Column(name = "cod_descuento")
	private Integer codDescuento;

	private Double monto;

	@Column(name = "importe_impuesto")
	private Double importeImpuesto;
	
	@Column(name = "sys_reglas")
	private String sysReglas;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	// bi-directional many-to-one association to CargoPeriodoDetalle
	@ManyToOne
	@JoinColumn(name = "cod_cargo_periodo_cab")
	private CargoPeriodoCabecera cargoPeriodoCabecera;

	// bi-directional many-to-one association to Concepto
	@ManyToOne
	@JoinColumn(name = "cod_concepto_cargo_periodo_det")
	private Concepto conceptoCargoPeriodoDetalle;
	
	// bi-directional many-to-one association to Concepto
	@ManyToOne
	@JoinColumn(name = "cod_concepto_descuento")
	private Concepto conceptoDescuento;

	@Override
	public Integer getId() {
		return codDescuento;
	}

}
