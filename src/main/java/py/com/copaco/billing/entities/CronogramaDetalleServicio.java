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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the cronograma_det database table.
 * 
 */
@Entity
@Table(name = "cronograma_det_servicio")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codCronogramaDetServicio", callSuper = true)
public class CronogramaDetalleServicio extends BaseEntity<Integer> implements
		Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "cronograma_det_servicio_seq", sequenceName = "cronograma_det_servicio_seq", allocationSize = 1)
	@GeneratedValue(generator = "cronograma_det_servicio_seq")
	@Column(name = "cod_cronograma_det_servicio")
	private Integer codCronogramaDetServicio;

	@ManyToOne
	@JoinColumn(name = "cod_cronograma_det")
	private CronogramaDetalle cronogramaDetalle;
	
	@ManyToOne
	@JoinColumn(name = "cod_servicio")
	private Servicio servicio;
	
	@ManyToOne
	@JoinColumn(name = "cod_prov_nivel")
	private ProvNivel nivel;
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_acreditacion")
	private Date fechaAcreditacion;


	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;


	@Override
	public Integer getId() {

		return codCronogramaDetServicio;
	}

}