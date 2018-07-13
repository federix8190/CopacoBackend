package py.com.copaco.billing.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * @author Willian Martinez
 * @since 1.0
 * @version 1.0 Mar 11, 2015
 */
@Entity
@Data
@EqualsAndHashCode(of = "codArmario", callSuper = false)
@ToString(of = "codArmario")
public class Armario extends BaseEntity<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "armario_seq", sequenceName = "armario_seq", allocationSize = 1)
	@GeneratedValue(generator = "armario_seq")
	@Column(name = "cod_armario")
	private Integer codArmario;

	private String nombre;

	@Column(name = "cap_primarios")
	private Integer capPrimarios;

	@Column(name = "cap_secundarios")
	private Integer capSecundarios;

	@ManyToOne
	@JoinColumn(name = "cod_distribuidor")
	private Distribuidor distribuidor;

	@OneToOne
	@JoinColumn(name = "cod_direccion")
	private Direccion direccion;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	private Integer capacidad;
	
	@Column(name = "cant_lineas_activas")
	private Integer cantLineasActivas;

	@Override
	public Integer getId() {
		return this.codArmario;
	}
}
