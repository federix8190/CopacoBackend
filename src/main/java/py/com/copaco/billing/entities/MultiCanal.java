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
 * The persistent class for the Multicanal database table.
 * 
 * @author Clara López
 * @since 1.0
 * @version 1.0, 23/03/15
 * 
 */

@Entity
@Data
@EqualsAndHashCode(of="codMuticanal", callSuper=false)
@ToString(of="codMuticanal")
public class MultiCanal extends BaseEntity<Integer>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="multicanal_seq", sequenceName="multicanal_seq", allocationSize=1)
	@GeneratedValue(generator="multicanal_seq")
	@Column(name="cod_multicanal")
	private Integer codMuticanal;
	
	private String  nombre;
	
	private String descripcion;
	
	@Column(name="nro_canales")
	private Integer nroCanales;
	
	@ManyToOne
	@JoinColumn(name="cod_caja")
	private Caja caja;
	
	@OneToOne
	@JoinColumn(name="cod_par")
	private Par par;
	
	@ManyToOne
	@JoinColumn(name="cod_lv_tipo")
	private ListaValoresDet tipoMulticanal;
	
	@OneToOne
	@JoinColumn(name="cod_direccion")
	private Direccion direccion;
	
	@Column(name="cant_lineas_activas")
	private Integer cantLineasActivas;
	
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	
	@Override
	public Integer getId() {
		
		return this.codMuticanal;
	}

}
