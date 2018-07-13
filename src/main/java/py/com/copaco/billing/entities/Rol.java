package py.com.copaco.billing.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;
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
@EqualsAndHashCode(of = "codRol", callSuper = true)
public class Rol extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "rol_seq", sequenceName = "rol_seq", allocationSize = 1)
	@GeneratedValue(generator = "rol_seq")
	@Column(name="cod_rol")
	private Integer codRol;

	private String nombre;
	
	private String descripcion;
	
	@OneToMany(mappedBy="rol", cascade= CascadeType.ALL)
	private List<RolPermiso> rolPermisos;


	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;


	@Override
	public Integer getId() {
		return codRol;
	}
	
	@JsonIgnoreBackend
	public List<RolPermiso> getRolPermisos() {
		return this.rolPermisos;
	}

	@JsonProperty
	public void setRolPermisos(List<RolPermiso> rolPermisos) {
		this.rolPermisos = rolPermisos;
	}

	public RolPermiso addRolPermiso(RolPermiso rolPermiso) {
		getRolPermisos().add(rolPermiso);
		rolPermiso.setRol(this);

		return rolPermiso;
	}

	public RolPermiso removeRolPermiso(RolPermiso rolPermiso) {
		getRolPermisos().remove(rolPermiso);
		rolPermiso.setRol(null);

		return rolPermiso;
	}

}