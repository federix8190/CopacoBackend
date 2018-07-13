package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

@Entity
@Table(name = "distrito_oficina")
@Cacheable
@EqualsAndHashCode(of = "codDistritoOficina")
@ToString(of = "codDistritoOficina")
@Data
public class DistritoOficina implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "distrito_oficina_seq", sequenceName = "distrito_oficina_seq", allocationSize = 1)
	@GeneratedValue(generator = "distrito_oficina_seq")
	@Column(name = "cod_distrito_oficina")
	private Integer codDistritoOficina;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	private String nombre;

	@Getter(onMethod = @_(@JsonIgnoreBackend))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "distritoOficina", cascade = CascadeType.ALL)
	private List<Oficina> oficinas;

	@Column(name = "nro_distrito")
	private String nroDistrito;
}