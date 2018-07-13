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
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Mauro Vera
 * @since 1.0
 * @version 1.0 Ago 18, 2015
 * 
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codCuadrilla", callSuper = true)
public class Cuadrilla extends BaseEntity<Integer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7046491933785539018L;

	@Id
	@SequenceGenerator(name="cuadrilla_seq", sequenceName="cuadrilla_seq", allocationSize=1)
	@GeneratedValue(generator="cuadrilla_seq")
	@Column(name="cod_cuadrilla")
	private Integer codCuadrilla;
	
	private String  codigo;
		
	@ManyToOne
	@JoinColumn(name="cod_central")
	private Central central;
	
	@ManyToOne
	@JoinColumn(name="cod_lv_tipo_cuadrilla")
	private ListaValoresDet tipoCuadrilla;
	
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	
	@Getter(onMethod=@_({@JsonIgnoreBackend}))
	@Setter(onMethod=@_(@JsonProperty))
	@OneToMany(mappedBy = "cuadrilla", cascade = CascadeType.ALL)
	private List<TecnicoCuadrilla> listaTecnicoCuadrilla;
	
	@Transient
	@Getter
	@Setter
	Integer cuadrillaVieja;
	
	
	@Override
	public Integer getId() {
		
		return this.codCuadrilla;
	}


	public Cuadrilla(Cuadrilla cuadrilla) {
		this.central = cuadrilla.central;
		this.codCuadrilla = null;
		this.codigo = cuadrilla.codigo;
		this.codUsuarioModificacion = cuadrilla.codUsuarioModificacion;
		this.fechaModificacion = cuadrilla.fechaModificacion;
		this.tipoCuadrilla = cuadrilla.tipoCuadrilla;
		this.listaTecnicoCuadrilla = null;
	}


}
