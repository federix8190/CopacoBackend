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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * 
 * @author Mauro Vera
 * @author Mirta Gonzalez
 * @since 2.0
 * @version 22/10/2014
 */
@Entity
@Table(name = "cargo_periodo_cab")
@Data
@ToString(of = "codCargoPeriodoCabecera")
@NoArgsConstructor
@EqualsAndHashCode(of = "codCargoPeriodoCabecera", callSuper = true)
public class CargoPeriodoCabecera extends BaseEntity<Integer> implements
		Serializable {

	private static final long serialVersionUID = -3992139624182822281L;

	@Id
	@SequenceGenerator(name = "cargo_periodo_cab_seq", sequenceName = "cargo_periodo_cab_seq", allocationSize = 1)
	@GeneratedValue(generator = "cargo_periodo_cab_seq")
	@Column(name = "cod_cargo_periodo_cab")
	private Integer codCargoPeriodoCabecera;

	@Column(name = "anho_mes_cte")
	private String anhoMesCte;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Column(name = "saldo_periodo")
	private Double saldoPeriodo;

	@ManyToOne
	@JoinColumn(name = "cod_cuenta")
	private Cuenta cuenta;

	@Column(name = "estado")
	private String estado;

	@OneToMany(mappedBy = "cargoPeriodoCabecera")
	@JsonIgnore
	private List<CargoPeriodoDetalle> cargoPeriodoDetalles;

	// bi-directional many-to-one association to FacturaCabecera
	@ManyToOne
	@JoinColumn(name = "cod_factura_cab")
	private FacturaCabecera facturaCabecera;

	@Column(name = "sum_importe_impuesto")
	private Double sumImporteImpuesto;

	// bi-directional many-to-one association to Descuento
	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "cargoPeriodoCabecera")
	private List<Descuento> descuentos;

	@Override
	public Integer getId() {
		return codCargoPeriodoCabecera;
	}

}