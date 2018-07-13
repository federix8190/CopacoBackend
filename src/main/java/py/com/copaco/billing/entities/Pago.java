package py.com.copaco.billing.entities;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The persistent class for the pago database table.
 * 
 * @author Adriana Coronel
 * @since 1.0
 */

@Entity
@Table(name = "pago")
@Data
@EqualsAndHashCode(of = "codPago", callSuper = false)
@ToString(of = "codPago")
public class Pago extends BaseEntity<BigInteger> {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "pago_seq", sequenceName = "pago_seq", allocationSize = 1)
	@GeneratedValue(generator = "pago_seq")
	@Column(name = "cod_pago")
	private BigInteger codPago;

	@ManyToOne
	@JoinColumn(name = "cod_cuenta")
	private Cuenta cuenta;

	@OneToOne
	@JoinColumn(name = "cod_factura")
	private Factura factura;

	@ManyToOne
	@JoinColumn(name = "cod_lote_pagos")
	private LotePagos lotePagos;

	@ManyToOne
	@JoinColumn(name = "cod_lote_boleta_dep")
	private LoteBoletaDeposito loteBoletaDep;

	@ManyToOne
	@JoinColumn(name = "cod_boca_cobranza_ext")
	private BocaCobranzaExterna bocaCobranzaExt;

	@ManyToOne
	@JoinColumn(name = "cod_caja_cobranza")
	private CajaCobranza cajaCobranza;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_pago")
	private Date fechaPago;

	@Column(name = "num_transaccion")
	private String numTransaccion;

	@Column(name = "monto_factura")
	private Double montoFactura;

	@Column(name = "monto_orig")
	private Double montoOrig;

	@Column(name = "monto_efectivo")
	private Double montoEfectivo;

	@Column(name = "monto_cheque")
	private Double montoCheque;

	@Column(name = "monto_tarj")
	private Double montoTarj;

	@Column(name = "ret_iva")
	private Double retIva;

	@Column(name = "ret_renta")
	private Double retRenta;

	@Column(name = "ret_ley")
	private Double retLey;

	@Column(name = "monto_vuelto")
	private Double montoVuelto;

	@Column(name = "num_comprobante")
	private String numComprobante;

	@Column(name = "num_comp_ret")
	private String numCompRet;

	@ManyToOne
	@JoinColumn(name = "cod_entidad_financiera")
	private EntidadFinanciera entidadFinanciera;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Column(name = "estado")
	private String estado;

	@Column(name = "librador")
	private String librador;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_cheque")
	private Date fechaCheque;

	@ManyToOne
	@JoinColumn(name = "cod_entidad_bancaria")
	private EntidadFinanciera entidadBancaria;

	@Column(name = "num_tarjeta")
	private String numTarjeta;

	@Column(name = "cod_tipo_credito")
	private String tipoCredito;

	@Column(name = "terminal_usuario")
	private String terminalUsuario;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_ret")
	private Date fechaRet;
	
	@ManyToOne
	@JoinColumn(name = "cod_tipo_cuenta")
	private TipoCuenta tipoCuenta;

	@Override
	public BigInteger getId() {
		return this.codPago;
	}
}
