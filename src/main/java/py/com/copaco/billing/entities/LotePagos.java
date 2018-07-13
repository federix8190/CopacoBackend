package py.com.copaco.billing.entities;

import java.math.BigInteger;
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
@Table(name="lote_pagos")
@Data
@EqualsAndHashCode(of="codLotePagos", callSuper=false)
@ToString(of="codLotePagos")
public class LotePagos extends BaseEntity<BigInteger>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="lote_pagos_seq", sequenceName="lote_pagos_seq", allocationSize=1)
	@GeneratedValue(generator="lote_pagos_seq")
	@Column(name="cod_lote_pagos")
	private BigInteger codLotePagos;

	@ManyToOne
	@JoinColumn(name = "cod_caja_cobranza")
	private CajaCobranza cajaCobranza;
	
	@Column(name = "total_operaciones")
	private Integer totalOperaciones;
	
	@Column(name = "total_importe_ingresos")
	private Double totalImporteIngresos;
	
	@Column(name = "importe_inicial")
	private Double importeInicial;
	
	@Column(name = "total_neto")
	private Double totalNeto;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_apertura")
	private Date fechaApertura;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_cierre")
	private Date fechaCierre;
	
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "lotePagos", cascade = { CascadeType.ALL })
	private List<Pago> listaPagos;
	
	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "lotePagos", cascade = { CascadeType.ALL })
	private List<DepositoDetalle> listaDepositoDet;
	
	@ManyToOne
	@JoinColumn(name = "cod_boca_cobranza_ext")
	private BocaCobranzaExterna bocaExt;
	
	@Column(name = "nomarchivo")
	private String archivo;

	@Override
	public BigInteger getId() {
		return this.codLotePagos;
	}

}
