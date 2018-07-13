package py.com.copaco.billing.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
 * @version 1.0 Mar 27, 2015
 */
@Entity
@Data
@EqualsAndHashCode(of = "codPrefijo", callSuper = false)
@ToString(of = "codPrefijo")
public class Prefijo extends BaseEntity<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "prefijo_seq", sequenceName = "prefijo_seq", allocationSize = 1)
	@GeneratedValue(generator = "prefijo_seq")
	@Column(name = "cod_prefijo")
	private Integer codPrefijo;

	private String prefijo;

	private String descripcion;
	
	@Column(name = "bloqueo_defecto")
	private Integer bloqueoDefecto;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	
	
	@Override
	public Integer getId() {
		return this.codPrefijo;
	}

}
