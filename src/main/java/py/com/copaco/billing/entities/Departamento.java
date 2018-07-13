package py.com.copaco.billing.entities;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
@Cacheable
@Data
@EqualsAndHashCode(of = "codDepartamento", callSuper = false)
@ToString(of = "codDepartamento")
public class Departamento extends BaseEntity<String> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_departamento")
	private String codDepartamento;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public String getId() {
		return this.codDepartamento;
	}

}