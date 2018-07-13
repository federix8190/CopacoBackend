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
 * 
 * @author Eduardo Mendez
 * @since 1.0
 * @version 1.0 Feb 2, 2015
 * 
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codRolPermiso", callSuper = true)
@Table(name="rol_permiso")
public class RolPermiso extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "rol_permiso_seq", sequenceName = "rol_permiso_seq", allocationSize = 1)
	@GeneratedValue(generator = "rol_permiso_seq")
	@Column(name="cod_rol_permiso")
	private Integer codRolPermiso;

	
	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="cod_rol")
	private Rol rol;

	//bi-directional many-to-one association to PermisoObjeto
	@ManyToOne
	@JoinColumn(name="cod_permiso_objeto")
	private PermisoObjeto permisoObjeto;
		
	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;


	@Override
	public Integer getId() {
		return codRolPermiso;
	}

}