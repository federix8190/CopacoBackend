package py.com.copaco.billing.entities;

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
import lombok.ToString;

/**
 * 
 * @author Adolfo Martinez
 * @since 2.0
 * @version 2.0 2015/09/18
 * 
 */
@Entity
@Table(name = "facturacion_adelantada_det")
@Data
@EqualsAndHashCode(of = "ciclicoContratoServicio", callSuper = false)
@ToString(of = "ciclicoContratoServicio")
public class FacturacionAdelantadaDet extends BaseEntity<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "facturacion_adelantada_det_seq", sequenceName = "facturacion_adelantada_det_seq", allocationSize = 1)
	@GeneratedValue(generator = "facturacion_adelantada_det_seq")
	@Column(name = "cod_facturacion_adelantada_det")
	private Integer codFacturacionAdelantadaDet;

	@ManyToOne
	@JoinColumn(name = "cod_ciclico_contrato_servicio")
	private CiclicoContratoServicio ciclicoContratoServicio;

	@ManyToOne
	@JoinColumn(name = "cod_facturacion_adelantada")
	private FacturacionAdelantada facturacionAdelantada;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return this.codFacturacionAdelantadaDet;
	}

}
