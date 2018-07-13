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
 * The persistent class for the oficina database table.
 * 
 */
@Entity
@Cacheable
@Data
@EqualsAndHashCode(of = "codOficina")
@ToString(of = "codOficina")
public class Oficina implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "oficina_seq", sequenceName = "oficina_seq", allocationSize = 1)
	@GeneratedValue(generator = "oficina_seq")
	@Column(name = "cod_oficina")
	private Integer codOficina;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	private String nombre;

	// bi-directional many-to-one association to DistritoOficina
	@ManyToOne
	@JoinColumn(name = "cod_distrito_oficina")
	private DistritoOficina distritoOficina;
	
	@ManyToOne
	@JoinColumn(name = "cod_ciudad")
	private Ciudad ciudad;

	@Column(name = "cod_sigla_oficina")
	private String codSiglaOficina;
}