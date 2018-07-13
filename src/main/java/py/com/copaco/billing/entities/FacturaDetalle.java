package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Adriana Coronel
 * @since 2.0
 * @version 1.0 Dec 23, 2015 The persistent class for the factura_det database
 *          table.
 */

@Entity
@Table(name = "factura_det")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codFacturaDet", callSuper = false)
public class FacturaDetalle extends BaseEntity<BigInteger> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "factura_det_seq", sequenceName = "factura_det_seq", allocationSize = 1)
	@GeneratedValue(generator = "factura_det_seq")
	@Column(name = "cod_factura_det")
	private BigInteger codFacturaDet;

	// bi-directional many-to-one association to Despacho Detalle
	@ManyToOne
	@JoinColumn(name = "cod_factura")
	private Factura factura;

	@ManyToOne
	@JoinColumn(name = "cod_debito")
	private ValorVariable debitoContado;

	@Column(name = "precio_unit")
	private Double precioUnit;

	@Column(name = "cantidad")
	private Integer cantidad;
	
	@Column(name = "total")
	private Double total;

	@Column(name = "impuesto")
	private Double impuesto;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Override
	public BigInteger getId() {
		return codFacturaDet;
	}
}