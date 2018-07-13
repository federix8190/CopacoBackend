package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Lila Perez
 * @since 2.0
 * @version 1.0 Oct 22, 2014
 * The persistent class for the numeracion_factura database table.
 */

@Entity
@Table(name="numeracion_factura")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codNumeracionFactura", callSuper = false)
public class NumeracionFactura extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "numeracion_factura_seq", sequenceName = "numeracion_factura_seq", allocationSize = 1)
	@GeneratedValue(generator = "numeracion_factura_seq")
	@Column(name="cod_numeracion_factura")
	private Integer codNumeracionFactura;

	@Column(name="timbrado")
	private String timbrado;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_uso_desde")
	private Date fechaUsoDesde;	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_uso_hasta")
	private Date fechaUsoHasta;	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="vigencia_desde")
	private Date vigenciaDesde;	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="vigencia_hasta")
	private Date vigenciaHasta;	
	
	@Column(name="cod_sucursal")
	private Integer codSucursal;
	
	@Column(name="cod_boca_emision")
	private Integer codBocaEmision;
	
	@Column(name="num_desde")
	private Integer numDesde;
	
	@Column(name="num_hasta")
	private Integer numHasta;

	@Column(name="num_actual")
	private Integer numActual;
	
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return codNumeracionFactura;
	}
}