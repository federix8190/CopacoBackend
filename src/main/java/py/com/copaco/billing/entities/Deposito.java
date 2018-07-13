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

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@Table(name="deposito")
@Data
@EqualsAndHashCode(of="codDeposito", callSuper=false)
@ToString(of="codDeposito")
public class Deposito extends BaseEntity<Integer>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="deposito_seq", sequenceName="deposito_seq", allocationSize=1)
	@GeneratedValue(generator="deposito_seq")
	@Column(name="cod_deposito")
	private Integer codDeposito;
	
	@ManyToOne
	@JoinColumn(name="cod_lote_boleta_dep")
	private LoteBoletaDeposito loteBoletaDep;
	
	@ManyToOne
	@JoinColumn(name="cod_cuenta_bancaria")
	private CuentaBancaria cuentaBancaria;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="numero_boleta")
	private Integer nroBoleta;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_deposito_debito")
	private Date fechaDepositoDebito;
	
    @Column(name="importe_efectivo")
	private Double importeEfectivo;
	
	@Column(name="importe_cheque")
	private Double importeCheque;
	
	@Column(name="importe_total")
	private Double importeTotal;
	
	@Column(name="deposito_anterior")
	private String depositoAnterior;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "deposito", cascade = { CascadeType.ALL })
	private List<DepositoDetalle> listaDepositoDet;

	@Override
	public Integer getId() {
		return this.codDeposito;
	}

}
