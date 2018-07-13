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

/**
 * 
 * The persistent class for the caja database table.
 * 
 * @author Adriana Coronel
 * @since 1.0
 * 
 * 
 */

@Entity
@Table(name="lote_boleta_dep")
@Data
@EqualsAndHashCode(of="codLoteBoletaDep", callSuper=false)
@ToString(of="codLoteBoletaDep")
public class LoteBoletaDeposito extends BaseEntity<Integer>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="lote_boleta_dep_seq", sequenceName="lote_boleta_dep_seq", allocationSize=1)
	@GeneratedValue(generator="lote_boleta_dep_seq")
	@Column(name="cod_lote_boleta_dep")
	private Integer codLoteBoletaDep;
	
	@ManyToOne
	@JoinColumn(name="cod_oficina")
	private Oficina oficina;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="carpeta")
	private String carpeta;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_cierre")
	private Date fechaCierre;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_inicio_vigencia")
	private Date fechaInicioVigencia;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_fin_vigencia")
	private Date fechaFinVigencia;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	

	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "loteBoletaDep", cascade = { CascadeType.ALL })
	private List<Pago> listaPagos;
	


	@Override
	public Integer getId() {
		return this.codLoteBoletaDep;
	}

}
