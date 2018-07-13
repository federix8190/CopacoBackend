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

import org.hibernate.annotations.Formula;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(of="codConexionCableEquipo", callSuper=false)
@ToString(of="codConexionCableEquipo")
@Table(name="conexion_cable_equipo")
public class ConexionCableEquipo extends BaseEntity<Integer>{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="conexion_cable_equipo_seq", sequenceName="conexion_cable_equipo_seq", allocationSize=1)
	@GeneratedValue(generator="conexion_cable_equipo_seq")
	@Column(name="cod_conexion_cable_equipo")
	private Integer codConexionCableEquipo;
	
	@Column(name="del_par")
	private Integer delPar;
	
	@Column(name="al_par")
	private Integer alPar;
	
	@ManyToOne
	@JoinColumn(name="cod_armario")
	private Armario armario;
	
	@ManyToOne
	@JoinColumn(name="cod_distribuidor")
	private Distribuidor distribuidor;
	
	
	@ManyToOne
	@JoinColumn(name="cod_caja")
	private Caja caja;
	
	@ManyToOne
	@JoinColumn(name="cod_cable")
	private Cable cable;
	
	@ManyToOne
	@JoinColumn(name="cod_central")
	private Central central;
	
	
	@Column(name="cant_pares")
	private Integer cantPares;
	
	
	
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Formula("cant_pares")
	private Integer cantParesOriginal ;
	
	@Override
	public Integer getId() {
		return this.codConexionCableEquipo;
	}

}
