package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * 
 * @author Mirta Gonzalez
 * @since 2.0
 * @version 22/10/2014
 */
@Entity
@Data
@NoArgsConstructor
@ToString(of = "codConcepto")
@Cacheable
@EqualsAndHashCode(of = "codConcepto", callSuper = false)
public class Concepto extends BaseEntity<String> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6610700451384877706L;

	@Id
	@Column(name = "cod_concepto")
	private String codConcepto;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	private String tipo;

	@ManyToOne 
	@JoinColumn(name = "cod_evento")
	private Evento evento;

	@Getter(onMethod = @_(@JsonIgnoreBackend))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "conceptoCargoPeriodoDetalle")
	private List<Descuento> descuentos1;

	@Getter(onMethod = @_(@JsonIgnoreBackend))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "conceptoDescuento")
	private List<Descuento> descuentos2;

	@Override
	public String getId() {
		return codConcepto;
	}
	

}