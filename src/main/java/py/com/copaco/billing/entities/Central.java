package py.com.copaco.billing.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * 
 * The persistent class for the central database table.
 * 
 * @author Mauro Vera
 * @since 1.0
 * @version 1.0 Sep 16, 2014
 * 
 * @author Adolfo Martinez
 * @since 2.0
 * @version 2.0 06/03/15
 * 
 * @author Monserrat Mora
 * @since 2.0
 * @version 2.0 Sep 17, 2015
 * 
 */
@Entity
@Data
@EqualsAndHashCode(of = "codCentral", callSuper = false)
@ToString(of = "codCentral")
public class Central extends BaseEntity<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "central_seq", sequenceName = "central_seq", allocationSize = 1)
	@GeneratedValue(generator = "central_seq")
	@Column(name = "cod_central")
	private Integer codCentral;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@ManyToOne
	@JoinColumn(name = "cod_lv_tipo")
	private ListaValoresDet lvTipo;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "sigla")
	private String sigla;

	@OneToOne
	@JoinColumn(name = "cod_direccion")
	private Direccion direccion;

	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "central", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	private List<Conmutador> conmutadoresList;

	@Override
	public Integer getId() {
		return this.codCentral;
	}

}