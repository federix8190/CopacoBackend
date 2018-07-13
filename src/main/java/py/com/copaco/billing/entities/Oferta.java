package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * @author Monserrat Mora
 * @since 2.0
 * @version set 12, 2014
 * 
 *          Modificado por:
 * @author Monserrat Mora
 * @version Dic 16, 2015 cambios: se agrega el campo cod_lv_tipo_mercado
 */

@Entity
@Data
@EqualsAndHashCode(of = "codOferta", callSuper = false)
@ToString(of = "codOferta")
public class Oferta extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "oferta_seq", sequenceName = "oferta_seq", allocationSize = 1)
	@GeneratedValue(generator = "oferta_seq")
	@Column(name = "cod_oferta")
	private Integer codOferta;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String activo;

	@Column(name = "permanencia_minima")
	private Integer permanenciaMinima;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_inicio")
	private Date fechaInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	private String nombre;

	private Double porcentaje;

	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "oferta")
	private List<Contrato> contratos;

	// bi-directional many-to-one association to ListaValoresDet
	@ManyToOne
	@JoinColumn(name = "cod_lv_estado")
	private ListaValoresDet listaValoresDet;

	// bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name = "cod_producto")
	private Producto producto;

	// bi-directional many-to-one association to ListaValoresDet
	@ManyToOne
	@JoinColumn(name = "cod_lv_segmento")
	private ListaValoresDet listaValoresDet_segmento;

	@ManyToOne
	@JoinColumn(name = "cod_lv_proveedor")
	private ListaValoresDet lvProveedor;

	@ManyToOne
	@JoinColumn(name = "cod_lv_tipo_mercado")
	private ListaValoresDet lvTipoMercado;

	@Override
	public Integer getId() {
		return getCodOferta();
	}

}