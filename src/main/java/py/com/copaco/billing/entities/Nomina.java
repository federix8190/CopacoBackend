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
 * 
 * @author Mauro Vera
 * @since 1.0
 * @version 1.0 Ago 21, 2015
 * 
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codNomina", callSuper = true)
public class Nomina extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8225429906534957155L;

	@Id
	@SequenceGenerator(name="nomina_seq", sequenceName="nomina_seq", allocationSize=1)
	@GeneratedValue(generator="nomina_seq")
	@Column(name="cod_nomina")
	private Integer codNomina;
	
	private Integer  carnet;
	
	@Column(name = "cedula_nro")
	private Integer  cedulaNro;
	
	private String  empleado;
	
	private String especialidad; 
	
	
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	
	@Override
	public Integer getId() {
		
		return this.codNomina;
	}


}
