package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name = "margen_impuesto_det")
@EqualsAndHashCode(of = "codMargenImpuestoDet")
@ToString(of = "codMargenImpuestoDet")
public class MargenImpuestoDet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "margen_impuesto_det_seq", sequenceName = "margen_impuesto_det_seq", allocationSize = 1)
	@GeneratedValue(generator = "margen_impuesto_det_seq")
	@Column(name = "cod_margen_impuesto_det")
	private Integer codMargenImpuestoDet;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_inicio_vig")
	private Date fechaInicioVigencia;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_fin_vig")
	private Date fechaFinVigencia;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Getter
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_cuenta_contable")
	private CuentaContable cuentaContable;

	@Getter(onMethod = @_(@JsonIgnoreBackend))
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_margen_impuesto")
	private MargenImpuesto margenImpuesto;

	public MargenImpuestoDet() {

	}

	public MargenImpuestoDet(MargenImpuestoDet original) {
		this.codMargenImpuestoDet = original.getCodMargenImpuestoDet();
		this.fechaInicioVigencia = original.getFechaInicioVigencia();
		this.fechaFinVigencia = original.getFechaFinVigencia();
		this.codUsuarioModificacion = original.getCodUsuarioModificacion();
		this.cuentaContable = original.getCuentaContable();
		this.margenImpuesto = original.getMargenImpuesto();
		this.fechaModificacion = original.getFechaModificacion();
	}
}
