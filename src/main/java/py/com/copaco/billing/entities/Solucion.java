package py.com.copaco.billing.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * @author Claudia Valenzuela
 * @since 1.0
 * @version 02/09/2015
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codSolucion", callSuper = false)
@SuppressWarnings("serial")
public class Solucion extends BaseEntity<Integer> {
	@Id
	@Column(name = "cod_solucion")
	@SequenceGenerator(name = "solucion_seq", sequenceName = "solucion_seq", allocationSize = 1)
	@GeneratedValue(generator = "solucion_seq")
	private Integer codSolucion;

	@Size(max = 500)
	private String descripcion;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "cod_lv_solucion")
	private ListaValoresDet solucion;

	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_reclamo", referencedColumnName = "cod_reclamo")
	private Reclamo reclamo;

	@NotNull
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;
	
	@Getter(onMethod=@_({@JsonIgnoreBackend}))
	@Setter(onMethod=@_(@JsonProperty))
	@OneToMany(mappedBy = "solucion",cascade = {CascadeType.ALL })
	private List<TecnicoReclamo> listaTecnicoReclamo;

	@Getter(onMethod=@_({@JsonIgnoreBackend}))
	@Setter(onMethod=@_(@JsonProperty))
	@OneToMany(mappedBy = "solucion",cascade = {CascadeType.ALL })
	private List<MaterialUtilizado> listaMaterialesUtilizados;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@JsonIgnore
	@OneToOne(mappedBy = "solucion")
	private Diagnostico diagnostico;

	@JsonIgnore
	@OneToOne(mappedBy = "solucion")
	private OrdenTrabajoDet ordenTrabajoDet;

	@Override
	public Integer getId() {
		return codSolucion;
	}

}
