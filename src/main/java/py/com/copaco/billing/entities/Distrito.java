package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
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
import lombok.ToString;

/**
 * The persistent class for the distrito database table.
 * 
 */
@Entity
@Cacheable
@Data
@EqualsAndHashCode(of = "codDistrito")
@ToString(of = "codDistrito")
public class Distrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "distrito_seq", sequenceName = "distrito_seq", allocationSize = 1)
	@GeneratedValue(generator = "distrito_seq")
	@Column(name = "cod_distrito")
	private Integer codDistrito;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@ManyToOne
	@JoinColumn(name = "cod_departamento")
	private Departamento departamento;

}