package py.com.copaco.billing.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @version 1.0 Ene 05, 2016
 * 
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codVehiculo", callSuper = true)
public class Vehiculo extends BaseEntity<Integer>{
	
	@Id
	@SequenceGenerator(name="vehiculo_seq", sequenceName="vehiculo_seq", allocationSize=1)
	@GeneratedValue(generator="vehiculo_seq")
	@Column(name="cod_vehiculo")
	private Integer codVehiculo;
	
	@JoinColumn(name="codigo")
	private String codigo;
	
	@Column(name="numero")
	private Integer numero;
	
	@Column(name="marca")
	private String marca;
	
	@Column(name="modelo")
	private String modelo;
	
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return this.codVehiculo;
	}
	

}
