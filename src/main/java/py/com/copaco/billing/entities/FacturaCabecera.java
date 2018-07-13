package py.com.copaco.billing.entities;

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

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * 
 * @author Mirta Gonzalez
 * @since 2.0
 * @version 10/10/2014
 */

@Entity
@Table(name = "factura_cab")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codFacturaCab", callSuper = true)
public class FacturaCabecera extends BaseEntity<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "factura_cab_seq", sequenceName = "factura_cab_seq", allocationSize = 1)
	@GeneratedValue(generator = "factura_cab_seq")
	@Column(name = "cod_factura_cab")
	private Integer codFacturaCab;

	String periodo;

	String estado;

	String tipo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_emision")
	private Date fechaEmision;

	// bi-directional many-to-one association to CicloFacturacion
	@ManyToOne
	@JoinColumn(name = "cod_ciclo_facturacion")
	private CicloFacturacion cicloFacturacion;

	// bi-directional many-to-one association to CargoPeriodoCabecera
	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "facturaCabecera")
	private List<CargoPeriodoCabecera> cargoPeriodoCabeceras;

	@Column(name = "num_inicial")
	private Integer numInicial;

	@Column(name = "num_final")
	private Integer numFinal;

	@Column(name = "total_factura")
	private Integer cantFact;

	@Column(name = "total_monto")
	private Double montoTotal;

	@Column(name = "total_impuesto")
	private Double impuesto;
	
	@Column(name = "total_interes")
	private Double interesMora;
	
	@Override
	public Integer getId() {
		return codFacturaCab;
	}

}
