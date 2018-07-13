package py.com.copaco.billing.entities;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The persistent class for the barrio database table.
 * 
 */
@Entity
@Cacheable
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codBarrio", callSuper = false)
@ToString(of = "codBarrio")
public class Barrio extends BaseEntity<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "barrio_seq", sequenceName = "barrio_seq", allocationSize = 1)
	@GeneratedValue(generator = "barrio_seq")
	@Column(name = "cod_barrio")
	private Integer codBarrio;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return codBarrio;
	}

}
