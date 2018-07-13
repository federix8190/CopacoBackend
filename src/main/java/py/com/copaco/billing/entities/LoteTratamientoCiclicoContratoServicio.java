package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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
import lombok.ToString;

/**
 *
 * @author Adriana Coronel
 * @since 1.0
 * @version 1.0 Aug 27, 2015
 *
 */


@Entity
@Table(name = "lote_tratamiento_ciclico_contrato_servicio")
@Data
@ToString(of = "codLoteTratamientoCiclicoContratoServicio")
@NoArgsConstructor
@EqualsAndHashCode(of = "codLoteTratamientoCiclicoContratoServicio", callSuper = true)
public class LoteTratamientoCiclicoContratoServicio extends BaseEntity<Integer> implements
		Serializable {

	private static final long serialVersionUID = 7838590699745025102L;

	@Id
	@SequenceGenerator(name = "lote_tratamiento_ciclico_contrato_servicio_seq", sequenceName = "lote_tratamiento_ciclico_contrato_servicio_seq", allocationSize = 1)
	@GeneratedValue(generator = "lote_tratamiento_ciclico_contrato_servicio_seq")
	@Column(name = "cod_lote_tratamiento_ciclico_contrato_servicio")
	private Integer codLoteTratamientoCiclicoContratoServicio;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "cod_lote_tratamiento")
	private LoteTratamiento loteTratamiento;
	
	@ManyToOne
	@JoinColumn(name = "cod_ciclico_contrato_servicio")
	private CiclicoContratoServicio ciclicoContratoServicio;
	
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return codLoteTratamientoCiclicoContratoServicio;
	}

}
