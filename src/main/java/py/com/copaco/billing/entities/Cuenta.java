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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 
 * @author Mauro Vera
 * @since 3.0
 * @version 1.0 May 29, 2015
 * 
 */
@Entity
public class Cuenta extends BaseEntity<Integer> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "cuenta_seq", sequenceName = "cuenta_seq", allocationSize = 1)
	@GeneratedValue(generator = "cuenta_seq")
	@Column(name = "cod_cuenta")
	private Integer codCuenta;

	private String activo;

	@Column(name = "cantidad_facturacion")
	private Integer cantidadFacturacion;

	@Column(name = "cod_agente")
	private Integer codAgente;

	@Column(name = "cod_despacho_detalle")
	private Integer codDespachoDetalle;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;
	
	@Column(name = "cod_usuario_creacion")
	@Getter
	@Setter
	private String codUsuarioCreacion;

	@Column(name = "cuenta_diferida")
	private String cuentaDiferida;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_hasta_ultima_facturacion")
	private Date fechaHastaUltimaFacturacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	@Getter
	@Setter
	private Date fechaCreacion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_ultima_facturacion")
	private Date fechaUltimaFacturacion;

	@Column(name = "consumo_periodo")
	private Double consumoPeriodo;

	@Column(name = "nombre_facturar")
	private String nombreFacturar;

	@Column(name = "nro_debito_automatico")
	private String nroDebitoAutomatico;

	private String ruc;

	private Double saldo;

	private String email;

	@Column(name = "tipo_envio_factura")
	private String tipoEnvioFactura;
	
	@Column(name = "motivo_modificacion")
	private String motivoModificacion;


	@ManyToOne
	@JoinColumn(name = "cod_diseno_factura")
	private DisenoFactura disenoFactura;

	// bi-directional many-to-one association to Contrato
	@OneToMany(mappedBy = "cuenta")
	private List<Contrato> contratos;

	// bi-directional many-to-one association to CicloFacturacion
	@ManyToOne
	@JoinColumn(name = "cod_ciclo_facturacion")
	private CicloFacturacion cicloFacturacion;

	@ManyToOne
	@JoinColumn(name = "cod_tratamiento_falta_pago")
	private TratamientoFaltaPago tratFaltaPago;

	/**
	 * Cliente titular
	 */
	@ManyToOne
	@JoinColumn(name = "cod_cliente")
	@Getter
	@Setter
	private Cliente clienteTitular;

	/**
	 * Cliente diferido
	 */
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "cod_cliente_facturacion")
	private Cliente clienteDiferido;

	// bi-directional many-to-one association to Despacho
	@ManyToOne
	@JoinColumn(name = "cod_despacho")
	private Despacho despacho;

	// bi-directional many-to-one association to Direccion
	@ManyToOne
	@JoinColumn(name = "cod_direccion")
	private Direccion direccion;

	// bi-directional many-to-one association to ListaValoresDet_estado
	@ManyToOne
	@JoinColumn(name = "cod_lv_estado")
	private ListaValoresDet listaValoresDet1;

	// bi-directional many-to-one association to ListaValoresDet_estado
	@ManyToOne
	@JoinColumn(name = "cod_lv_estado_rbk")
	@Getter
	@Setter
	private ListaValoresDet codEstadoRbk;

	// bi-directional many-to-one association to ListaValoresDet
	@ManyToOne
	@JoinColumn(name = "cod_lv_forma_pago")
	private ListaValoresDet listaValoresDet2;

	// bi-directional many-to-one association to ListaValoresDet
	@ManyToOne
	@JoinColumn(name = "cod_lv_tipo_facturacion")
	private ListaValoresDet listaValoresDet3;

	// bi-directional many-to-one association to ListaValoresDet
	@ManyToOne
	@JoinColumn(name = "cod_lv_plazo_facturacion")
	private ListaValoresDet listaValoresDet4;

	// bi-directional many-to-one association to ListaValoresDet
	@ManyToOne
	@JoinColumn(name = "cod_lv_tipo_debito")
	private ListaValoresDet listaValoresDet5;

	// bi-directional many-to-one association to ListaValoresDet
	@ManyToOne
	@JoinColumn(name = "cod_lv_forma_desconexion")
	private ListaValoresDet listaValoresDet6;

	// bi-directional many-to-one association to MargenImpuesto
	@ManyToOne
	@JoinColumn(name = "cod_margen_impuesto")
	private MargenImpuesto margenImpuesto;

	// bi-directional many-to-one association to Debito
	@OneToMany(mappedBy = "cuenta")
	private List<Debito> debitos;

	@Column(name = "cant_fact_venc_imp")
	private Integer cantFactVencImp;

	@ManyToOne
	@JoinColumn(name = "cod_diseno_factura_ant")
	private DisenoFactura disenoFacturaAnt;

	@ManyToOne
	@JoinColumn(name = "cod_diseno_factura_rbk")
	private DisenoFactura disenoFacturaRbk;

	@Column(name = "cod_despacho_detalle_ant")
	private Integer codDespachoDetalleAnt;

	@Column(name = "cod_despacho_detalle_rbk")
	private Integer codDespachoDetalleRbk;

	@ManyToOne
	@JoinColumn(name = "cod_lv_estado_ant")
	private ListaValoresDet listaValoresDet8;

	@ManyToOne
	@JoinColumn(name = "cod_tipo_cuenta")
	private TipoCuenta tipoCuenta;

	@ManyToOne
	@JoinColumn(name = "cod_tipo_cuenta_ant")
	private TipoCuenta tipoCuentaAnt;

	@ManyToOne
	@JoinColumn(name = "cod_tipo_cuenta_rbk")
	private TipoCuenta tipoCuentaRbk;

	@Column(name = "monto_fact_ven_imp")
	private Double montoFacturasVencidasImpagas;
	
	@Column(name = "mostrar_deuda_venc")
	private String mostrarDeudaVencida;
	
	@Column(name = "generar_mora")
	private String generarMora;

	public Cuenta() {
	}

	public String getMotivoModificacion(){
		return motivoModificacion;
	}

	public void setMotivoModificacion(String motivoModificacion){
		this.motivoModificacion = motivoModificacion;
	}

	public Integer getCodCuenta() {
		return this.codCuenta;
	}

	public void setCodCuenta(Integer codCuenta) {
		this.codCuenta = codCuenta;
	}

	public String getCodUsuarioModificacion() {
		return this.codUsuarioModificacion;
	}

	public void setCodUsuarioModificacion(String codUsuarioModificacion) {
		this.codUsuarioModificacion = codUsuarioModificacion;
	}

	public String getCuentaDiferida() {
		return this.cuentaDiferida;
	}

	public void setCuentaDiferida(String cuentaDiferida) {
		this.cuentaDiferida = cuentaDiferida;
	}

	public Date getFechaHastaUltimaFacturacion() {
		return this.fechaHastaUltimaFacturacion;
	}

	public void setFechaHastaUltimaFacturacion(Date fechaHastaUltimaFacturacion) {
		this.fechaHastaUltimaFacturacion = fechaHastaUltimaFacturacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaUltimaFacturacion() {
		return this.fechaUltimaFacturacion;
	}

	public void setFechaUltimaFacturacion(Date fechaUltimaFacturacion) {
		this.fechaUltimaFacturacion = fechaUltimaFacturacion;
	}

	@JsonIgnore
	public List<Contrato> getContratos() {
		return this.contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Contrato addContrato(Contrato contrato) {
		getContratos().add(contrato);
		contrato.setCuenta(this);

		return contrato;
	}

	public Contrato removeContrato(Contrato contrato) {
		getContratos().remove(contrato);
		contrato.setCuenta(null);

		return contrato;
	}

	public CicloFacturacion getCicloFacturacion() {
		return this.cicloFacturacion;
	}

	public void setCicloFacturacion(CicloFacturacion cicloFacturacion) {
		this.cicloFacturacion = cicloFacturacion;
	}

	/**
	 * @deprecated utilizar #getClienteTitular
	 * @param cliente1
	 */
	@Deprecated
	public Cliente getCliente1() {
		return this.clienteTitular;
	}

	/**
	 * @deprecated utilizar #setClienteTitular
	 * @param cliente1
	 */
	@Deprecated
	public void setCliente1(Cliente cliente1) {
		this.clienteTitular = cliente1;
	}

	/**
	 * @deprecated utilizar #getClienteDiferido
	 * @return
	 */
	@Deprecated
	public Cliente getCliente2() {
		return this.clienteDiferido;
	}

	/**
	 * @deprecated utilizar #setClienteDiferido
	 * @param cliente2
	 */
	@Deprecated
	public void setCliente2(Cliente cliente2) {
		this.clienteDiferido = cliente2;
	}

	public Despacho getDespacho() {
		return this.despacho;
	}

	public void setDespacho(Despacho despacho) {
		this.despacho = despacho;
	}

	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public MargenImpuesto getMargenImpuesto() {
		return this.margenImpuesto;
	}

	public void setMargenImpuesto(MargenImpuesto margenImpuesto) {
		this.margenImpuesto = margenImpuesto;
	}

	@JsonIgnore
	public List<Debito> getDebitos() {
		return this.debitos;
	}

	public void setDebitos(List<Debito> debitos) {
		this.debitos = debitos;
	}

	public Debito addDebito(Debito debito) {
		getDebitos().add(debito);
		debito.setCuenta(this);

		return debito;
	}

	public Debito removeDebito(Debito debito) {
		getDebitos().remove(debito);
		debito.setCuenta(null);

		return debito;
	}

	public ListaValoresDet getListaValoresDet1() {
		return listaValoresDet1;
	}

	public void setListaValoresDet1(ListaValoresDet listaValoresDet1) {
		this.listaValoresDet1 = listaValoresDet1;
	}

	public ListaValoresDet getListaValoresDet2() {
		return listaValoresDet2;
	}

	public void setListaValoresDet2(ListaValoresDet listaValoresDet2) {
		this.listaValoresDet2 = listaValoresDet2;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public Integer getCodAgente() {
		return codAgente;
	}

	public void setCodAgente(Integer codAgente) {
		this.codAgente = codAgente;
	}

	public Integer getCodDespachoDetalle() {
		return codDespachoDetalle;
	}

	public void setCodDespachoDetalle(Integer codDespachoDetalle) {
		this.codDespachoDetalle = codDespachoDetalle;
	}

	public String getNombreFacturar() {
		return nombreFacturar;
	}

	public void setNombreFacturar(String nombreFacturar) {
		this.nombreFacturar = nombreFacturar;
	}

	public String getNroDebitoAutomatico() {
		return nroDebitoAutomatico;
	}

	public void setNroDebitoAutomatico(String nroDebitoAutomatico) {
		this.nroDebitoAutomatico = nroDebitoAutomatico;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public ListaValoresDet getListaValoresDet3() {
		return listaValoresDet3;
	}

	public void setListaValoresDet3(ListaValoresDet listaValoresDet3) {
		this.listaValoresDet3 = listaValoresDet3;
	}

	public ListaValoresDet getListaValoresDet4() {
		return listaValoresDet4;
	}

	public void setListaValoresDet4(ListaValoresDet listaValoresDet4) {
		this.listaValoresDet4 = listaValoresDet4;
	}

	public ListaValoresDet getListaValoresDet5() {
		return listaValoresDet5;
	}

	public void setListaValoresDet5(ListaValoresDet listaValoresDet5) {
		this.listaValoresDet5 = listaValoresDet5;
	}

	public ListaValoresDet getListaValoresDet6() {
		return listaValoresDet6;
	}

	public void setListaValoresDet6(ListaValoresDet listaValoresDet6) {
		this.listaValoresDet6 = listaValoresDet6;
	}

	/*
	 * public ListaValoresDet getListaValoresDet7() { return listaValoresDet7; }
	 * 
	 * public void setListaValoresDet7(ListaValoresDet listaValoresDet7) {
	 * this.listaValoresDet7 = listaValoresDet7; }
	 */

	public Integer getCantidadFacturacion() {
		return cantidadFacturacion;
	}

	public void setCantidadFacturacion(Integer cantidadFacturacion) {
		this.cantidadFacturacion = cantidadFacturacion;
	}

	public Double getConsumoPeriodo() {
		return consumoPeriodo;
	}

	public void setConsumoPeriodo(Double consumoPeriodo) {
		this.consumoPeriodo = consumoPeriodo;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Cuenta)) {
			return false;
		}
		Cuenta other = (Cuenta) object;
		if ((this.codCuenta == null && other.codCuenta != null)
				|| (this.codCuenta != null && !this.codCuenta
						.equals(other.codCuenta))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (codCuenta != null ? codCuenta.hashCode() : 0);
		return hash;
	}

	public void setResponsable(Cliente cliente) {
	};

	public Cliente getResponsable() {
		if (cuentaDiferida.equals("S"))
			return clienteDiferido;
		return clienteTitular;
	}

	public Integer getId() {
		return codCuenta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipoEnvioFactura() {
		return tipoEnvioFactura;
	}

	public void setTipoEnvioFactura(String tipoEnvioFactura) {
		this.tipoEnvioFactura = tipoEnvioFactura;
	}

	public DisenoFactura getDisenoFactura() {
		return disenoFactura;
	}

	public void setDisenoFactura(DisenoFactura disenoFactura) {
		this.disenoFactura = disenoFactura;
	}

	public Integer getCantFactVencImp() {
		return cantFactVencImp;
	}

	public void setCantFactVencImp(Integer cantFactVencImp) {
		this.cantFactVencImp = cantFactVencImp;
	}

	public DisenoFactura getDisenoFacturaAnt() {
		return disenoFacturaAnt;
	}

	public void setDisenoFacturaAnt(DisenoFactura disenoFacturaAnt) {
		this.disenoFacturaAnt = disenoFacturaAnt;
	}

	public Integer getCodDespachoDetalleAnt() {
		return codDespachoDetalleAnt;
	}

	public void setCodDespachoDetalleAnt(Integer codDespachoDetalleAnt) {
		this.codDespachoDetalleAnt = codDespachoDetalleAnt;
	}

	public ListaValoresDet getListaValoresDet8() {
		return listaValoresDet8;
	}

	public void setListaValoresDet8(ListaValoresDet listaValoresDet8) {
		this.listaValoresDet8 = listaValoresDet8;
	}

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public TipoCuenta getTipoCuentaAnt() {
		return tipoCuentaAnt;
	}

	public void setTipoCuentaAnt(TipoCuenta tipoCuentaAnt) {
		this.tipoCuentaAnt = tipoCuentaAnt;
	}

	public TratamientoFaltaPago getTratFaltaPago() {
		return tratFaltaPago;
	}

	public void setTratFaltaPago(TratamientoFaltaPago tratFaltaPago) {
		this.tratFaltaPago = tratFaltaPago;
	}

	public Double getMontoFacturasVencidasImpagas() {
		return montoFacturasVencidasImpagas;
	}

	public void setMontoFacturasVencidasImpagas(
			Double montoFacturasVencidasImpagas) {
		this.montoFacturasVencidasImpagas = montoFacturasVencidasImpagas;
	}

	public DisenoFactura getDisenoFacturaRbk() {
		return disenoFacturaRbk;
	}

	public void setDisenoFacturaRbk(DisenoFactura disenoFacturaRbk) {
		this.disenoFacturaRbk = disenoFacturaRbk;
	}

	public Integer getCodDespachoDetalleRbk() {
		return codDespachoDetalleRbk;
	}

	public void setCodDespachoDetalleRbk(Integer codDespachoDetalleRbk) {
		this.codDespachoDetalleRbk = codDespachoDetalleRbk;
	}

	public TipoCuenta getTipoCuentaRbk() {
		return tipoCuentaRbk;
	}

	public void setTipoCuentaRbk(TipoCuenta tipoCuentaRbk) {
		this.tipoCuentaRbk = tipoCuentaRbk;
	}

	public String getMostrarDeudaVencida() {
		return mostrarDeudaVencida;
	}

	public void setMostrarDeudaVencida(String mostrarDeudaVencida) {
		this.mostrarDeudaVencida = mostrarDeudaVencida;
	}

	public String getGenerarMora() {
		return generarMora;
	}

	public void setGenerarMora(String generarMora) {
		this.generarMora = generarMora;
	}
}
