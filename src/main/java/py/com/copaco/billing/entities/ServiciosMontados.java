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
import lombok.ToString;



/**
 * @author Monserrat Mora
 * @version 3.0 Dic 10, 2015
 * 
 */

@Entity
@Table(name="servicios_montados")
@Data
@EqualsAndHashCode(of="codServicioMontado", callSuper=false)
@ToString(of="codServicioMontado")
public class ServiciosMontados extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "servicio_montado_seq", sequenceName = "servicio_montado_seq", allocationSize = 1)
	@GeneratedValue(generator = "servicio_montado_seq")
	
	@Column(name="cod_servicio_montado")
	private Integer codServicioMontado;

	
	@ManyToOne
	@JoinColumn(name="cod_servicio")
	private Servicio servicio;
	
	@ManyToOne
	@JoinColumn(name="servicio_montable")
	private Servicio servicioMontable;
	
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	
	@Override
	public Integer getId() {
		return this.codServicioMontado;
	}

}
