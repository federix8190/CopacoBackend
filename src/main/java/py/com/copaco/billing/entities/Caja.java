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
 * The persistent class for the caja database table.
 * 
 * @author Clara López
 * @since 1.0
 * 
 * 
 */

@Entity
@Data
@EqualsAndHashCode(of="codCaja", callSuper=false)
@ToString(of="codCaja")
public class Caja extends BaseEntity<Integer>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="caja_seq", sequenceName="caja_seq", allocationSize=1)
	@GeneratedValue(generator="caja_seq")
	@Column(name="cod_caja")
	private Integer codCaja;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="cap_secundario")
	private Integer capSecundario;
	
	@ManyToOne
	@JoinColumn(name="cod_distribuidor")
	private Distribuidor distribuidor;
	
	@ManyToOne
	@JoinColumn(name="cod_armario")
	private Armario armario;
	
	@OneToOne
	@JoinColumn(name="cod_direccion")
	private Direccion direccion;
	
	@Column(name="tipo_caja")
	private String tipoCaja;
	
	@Column(name="cant_lineas_activas")
	private Integer cantLineasActivas;
	
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	

	@Override
	public Integer getId() {
		return this.codCaja;
	}

}
