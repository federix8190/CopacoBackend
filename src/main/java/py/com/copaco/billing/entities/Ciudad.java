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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The persistent class for the ciudad database table.
 * 
 * Modificado:
 * @author Monserrat Mora
 * @since 2.0
 * @version 2.0 Sep 17, 2015
 * 
 */
@Entity
@Cacheable
@Data
@NoArgsConstructor
@ToString(of = "codCiudad")
@EqualsAndHashCode(of = "codCiudad", callSuper = true)
public class Ciudad extends BaseEntity<Integer> implements Serializable, Comparable<Ciudad> {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ciudad_seq", sequenceName = "ciudad_seq", allocationSize = 1)
	@GeneratedValue(generator = "ciudad_seq")
	@Column(name = "cod_ciudad")
	private Integer codCiudad;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String descripcion;
	
	private String codigo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@ManyToOne
	@JoinColumn(name = "cod_distrito")
	private Distrito distrito;

	public Integer getId() {
		return codCiudad;
	}

	@PrePersist
	@PreUpdate
	public void audit() {
		setFechaModificacion(new Date());
		if(getCodUsuarioModificacion()==null || getCodUsuarioModificacion().isEmpty())
			setCodUsuarioModificacion("ADMIN");
	}

	@Override
	public int compareTo(Ciudad c) {
		return this.getDescripcion().compareToIgnoreCase(c.getDescripcion());
	}
}