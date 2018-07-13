package py.com.copaco.billing.entities;

import java.io.Serializable;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;


/**
 * 
 * @author Mauro Vera
 * @since 1.0
 * @version 1.1 Sep 18, 2014
 * 
 */


@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codVariable", callSuper = true)
public class Variable extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "variable_seq", sequenceName = "variable_seq", allocationSize = 1)
	@GeneratedValue(generator = "variable_seq")
	@Column(name="cod_variable")
	private Integer codVariable;

	@Column(name="cantidad_dimension")
	private Integer cantidadDimension;

	private String descripcion;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_ultima_modificacion")
	private Date fechaUltimaModificacion;

	@Column(name="nombre_dim1")
	private String nombreDim1;

	@Column(name="nombre_dim10")
	private String nombreDim10;

	@Column(name="nombre_dim11")
	private String nombreDim11;

	@Column(name="nombre_dim12")
	private String nombreDim12;

	@Column(name="nombre_dim13")
	private String nombreDim13;

	@Column(name="nombre_dim14")
	private String nombreDim14;

	@Column(name="nombre_dim15")
	private String nombreDim15;

	@Column(name="nombre_dim2")
	private String nombreDim2;

	@Column(name="nombre_dim3")
	private String nombreDim3;

	@Column(name="nombre_dim4")
	private String nombreDim4;

	@Column(name="nombre_dim5")
	private String nombreDim5;

	@Column(name="nombre_dim6")
	private String nombreDim6;

	@Column(name="nombre_dim7")
	private String nombreDim7;

	@Column(name="nombre_dim8")
	private String nombreDim8;

	@Column(name="nombre_dim9")
	private String nombreDim9;

	@Column(name="nombre_variable")
	private String nombreVariable;

	@Column(name="tipo_valor_variable")
	private String tipoValorVariable;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="usuario_ultima_modificacion")
	private String usuarioUltimaModificacion;

	@Getter(onMethod=@_({@JsonIgnoreBackend}))
	@Setter(onMethod=@_(@JsonProperty))
	@OneToMany(mappedBy="variable", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<ValorVariable> valorVariables;

	/** Relacion con lista valores solo de este lado*/
	@ManyToOne
	@JoinColumn(name="cod_tipo_variable")
	private ListaValoresDet tipoVariable;

	@Override
	public Integer getId() {
			return codVariable;
	}

}
	
