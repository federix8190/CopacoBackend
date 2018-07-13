package py.com.copaco.billing.entities;

import java.io.Serializable;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.annotations.Formula;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * The persistent class for the contrato database table.
 * 
 */
@Entity
public class Contrato extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "contrato_seq", sequenceName = "contrato_seq", allocationSize = 1)
	@GeneratedValue(generator = "contrato_seq")
	@Column(name = "cod_contrato")
	private Integer codContrato;

	private String activo;
	
	@Column(name = "nro_solicitud")
	private String nroSolicitud;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_solicitud")
	private Date fechaSolicitud;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;
	
	@Column(name = "cod_usuario_creacion")
	@Getter
	@Setter
	private String codUsuarioCreacion;
	
	@Column(name = "cod_tipo_facturacion") 
	private String tipoFacturacion;
	
	@Column(name = "nro_item_contrato") 
	private Integer nroItemContrato;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_entrada")
	private Date fechaEntrada;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_estado")
	private Date fechaEstado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_inicio")
	private Date fechaInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Column(name = "motivo_modificacion")
	private String motivoModificacion;


	// bi-directional many-to-one association to Cuenta
	@ManyToOne
	@JoinColumn(name = "cod_cuenta")
	private Cuenta cuenta;
	

	// bi-directional many-to-one association to ListaValoresDet
	@ManyToOne
	@JoinColumn(name = "cod_lv_categoria")
	private ListaValoresDet listaValoresDet1;

	// bi-directional many-to-one association to ListaValoresDet
	@ManyToOne
	@JoinColumn(name = "cod_lv_estado")
	private ListaValoresDet listaValoresDet2;

	// bi-directional many-to-one association to Oferta
	@ManyToOne
	@JoinColumn(name = "cod_oferta")
	private Oferta oferta;

	// bi-directional many-to-one association to Solicitud
	@ManyToOne
	@JoinColumn(name = "cod_solicitud")
	private Solicitud solicitud;

	// bi-directional many-to-one association to ContratoServicio
	@OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL)
	private List<ContratoServicio> contratoServicios;

	// bi-directional many-to-one association to Debito
	@OneToMany(mappedBy = "contrato")
	private List<Debito> debitos;

	@Formula("(select  gc(cs.num_linea) from contrato_servicio cs where cs.num_linea is not NULL and cs.cod_contrato = cod_contrato)")
	private String numero;

	public Contrato() {

	}
	
	public String getMotivoModificacion(){
		return motivoModificacion;
	}

	public void setMotivoModificacion(String motivoModificacion){
		this.motivoModificacion = motivoModificacion;
	}

	public String getTipoFacturacion() {
		return tipoFacturacion;
	}

	public void setTipoFacturacion(String tipoFacturacion) {
		this.tipoFacturacion = tipoFacturacion;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getCodContrato() {
		return this.codContrato;
	}

	public void setCodContrato(Integer codContrato) {
		this.codContrato = codContrato;
	}

	public String getCodUsuarioModificacion() {
		return this.codUsuarioModificacion;
	}

	public void setCodUsuarioModificacion(String codUsuarioModificacion) {
		this.codUsuarioModificacion = codUsuarioModificacion;
	}

	public Date getFechaEntrada() {
		return this.fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaEstado() {
		return this.fechaEstado;
	}

	public void setFechaEstado(Date fechaEstado) {
		this.fechaEstado = fechaEstado;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public ListaValoresDet getListaValoresDet1() {
		return this.listaValoresDet1;
	}

	public void setListaValoresDet1(ListaValoresDet listaValoresDet1) {
		this.listaValoresDet1 = listaValoresDet1;
	}

	public ListaValoresDet getListaValoresDet2() {
		return this.listaValoresDet2;
	}

	public void setListaValoresDet2(ListaValoresDet listaValoresDet2) {
		this.listaValoresDet2 = listaValoresDet2;
	}

	public Oferta getOferta() {
		return this.oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public Solicitud getSolicitud() {
		return this.solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	@JsonIgnoreBackend
	public List<ContratoServicio> getContratoServicios() {
		return this.contratoServicios;
	}

	@JsonProperty
	public void setContratoServicios(List<ContratoServicio> contratoServicios) {
		this.contratoServicios = contratoServicios;
	}

	public ContratoServicio addContratoServicio(
			ContratoServicio contratoServicio) {
		getContratoServicios().add(contratoServicio);
		contratoServicio.setContrato(this);

		return contratoServicio;
	}

	public ContratoServicio removeContratoServicio(
			ContratoServicio contratoServicio) {
		getContratoServicios().remove(contratoServicio);
		contratoServicio.setContrato(null);

		return contratoServicio;
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
		debito.setContrato(this);

		return debito;
	}

	public Debito removeDebito(Debito debito) {
		getDebitos().remove(debito);
		debito.setContrato(null);

		return debito;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	@Override
	public Integer getId() {
		return codContrato;
	}
	
	public Integer getNroItemContrato() {
		return nroItemContrato;
	}

	public void setNroItemContrato(Integer nroItemContrato) {
		this.nroItemContrato = nroItemContrato;
	}
	
	public void setNroSolicitud(String nroSolicitud){
		this.nroSolicitud = nroSolicitud;
	}
	
	public String getNroSolicitud(){
		return this.nroSolicitud;
	}
	
	public void setFechaSolicitud(Date fechaSolicitud){
		this.fechaSolicitud = fechaSolicitud;
	}
	
	public Date getFechaSolicitud(){
		return this.fechaSolicitud;
	}
}
