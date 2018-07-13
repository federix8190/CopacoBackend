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
 * @author Claudia Valenzuela
 * @since 1.0
 * @version 10/03/2015
 * 
 * @author Monserrat Mora
 * @since 2.0
 * @version 2.0 Sep 17, 2015
 * 
 */

@SuppressWarnings("serial")
@Entity
@Data
@ToString(of = "codDistribuidor")
@EqualsAndHashCode(of = "codDistribuidor", callSuper = false)
public class Distribuidor extends BaseEntity<Integer> {

	public static final String PRINCIPAL = "P";
	public static final String SHELTER = "S";

	@Id
	@SequenceGenerator(name = "distribuidor_seq", sequenceName = "distribuidor_seq", allocationSize = 1)
	@GeneratedValue(generator = "distribuidor_seq")
	@Column(name = "cod_distribuidor")
	private Integer codDistribuidor;

	@Column(name = "clase_distribuidor")
	private String claseDistribuidor;

	private String nombre;
	
	@Column(name = "nombre_comando")
	private String nombreComando;

	private String descripcion;

	

	private Integer capacidad;

	@OneToOne
	@JoinColumn(name = "cod_direccion")
	private Direccion direccion;

	@ManyToOne
	@JoinColumn(name = "cod_central")
	private Central central;

	@ManyToOne
	@JoinColumn(name = "cod_lv_fabricacion")
	private ListaValoresDet fabricacion;

	@ManyToOne
	@JoinColumn(name = "cod_lv_tipo_distribuidor")
	private ListaValoresDet tipoDistribuidor;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "distribuidor", cascade = CascadeType.ALL)
	private List<Columna> columnas;

	@Override
	public Integer getId() {
		return codDistribuidor;
	}
}
