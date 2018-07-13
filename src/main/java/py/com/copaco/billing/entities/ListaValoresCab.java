package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
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
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * The persistent class for the lista_valores_cab database table.
 * 
 */
@Entity
@Table(name = "lista_valores_cab")
@Data
@Cacheable
@ToString(of = "codListaValoresCab")
@EqualsAndHashCode(of = "codListaValoresCab")
public class ListaValoresCab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "lista_valores_cab_seq", sequenceName = "lista_valores_cab_seq", allocationSize = 1)
	@GeneratedValue(generator = "lista_valores_cab_seq")
	@Column(name = "cod_lista_valores_cab")
	private Integer codListaValoresCab;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	private String nombre;

	@JsonIgnore
	@OneToMany(mappedBy = "listaValoresCab")
	private List<ListaValoresDet> listaValoresDets;

}