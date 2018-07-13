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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * 
 * @author Mauro Vera
 * @since 1.0
 * @version 1.1 Sep 16, 2014
 * 
 */

/**
 * Modificado:
 * 
 * @author Monserrat Mora
 * @since 2.0
 * @version 2.0 Oct 14, 2015
 * 
 * @author Mauro Vera
 * @since 3.0
 * @version 3.0 Nov 12, 2015
 * 
 * @author Mirta Gonzalez
 * @version 26/05/2016
 * 
 */

@Entity
@Table(name = "contrato_servicio")
@EqualsAndHashCode(of = "codContratoServicio", callSuper = false)
public class ContratoServicio extends BaseEntity<Integer> implements
		Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "contrato_servicio_seq", sequenceName = "contrato_servicio_seq", allocationSize = 1)
	@GeneratedValue(generator = "contrato_servicio_seq")
	@Column(name = "cod_contrato_servicio")
	private Integer codContratoServicio;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String activo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	// bi-directional many-to-one association to Contrato
	@ManyToOne
	@JoinColumn(name = "cod_contrato")
	private Contrato contrato;

	// bi-directional many-to-one association to Direccion
	@ManyToOne
	@JoinColumn(name = "cod_direccion")
	private Direccion direccion;

	@Column(name = "fecha_instalacion")
	private Date fechaInstalacion;

	@Column(name = "fecha_inicio")
	private Date fechaInicio;

	@Column(name = "cod_servicio_montado")
	private Integer codServicioMontado;

	// bi-directional many-to-one association to ListaValoresDet
	@ManyToOne
	@JoinColumn(name = "cod_lv_estado")
	private ListaValoresDet listaValoresDet;

	// bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name = "cod_servicio")
	private Servicio servicio;

	// bi-directional many-to-one association to Debito
	@OneToMany(mappedBy = "contratoServicio")
	private List<Debito> debitos;
	
	// bi-directional many-to-one association to ValorAtributoServicio
	@OneToMany(mappedBy = "contratoServicio")
	private List<OrdenServicio> ordenesServicio;
	
	// bi-directional many-to-one association to ValorAtributoServicio
	@OneToMany(mappedBy = "contratoServicio", cascade = CascadeType.ALL)
	private List<ValorAtributoServicio> valorAtributoServicios;

	@OneToMany(mappedBy = "contratoServicio", cascade = CascadeType.ALL)
	private List<CiclicoContratoServicio> ciclicosContratoServicio;
	
	@Column(name = "num_linea")
	private String numeroLinea;

	/**
	 * Se agregan central, oficina y distritoOficina. Todas estas relaciones
	 * estan de este lado nada mas. No hace falta agregar del otro lado.
	 * */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "cod_central")
	private Central central;

	/*@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "cod_oficina")
	private Oficina oficina;*/

	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "cod_red_alambrica")
	private RedAlambrica redAlambrica;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "cod_red_inalambrica")
	private RedInalambrica redInalambrica;

	
	@Column(name="cod_red_adsl")
	private Integer redADSL;
	
	@Column(name = "cod_distrito_oficina")
	private Integer codDistritoOficina;
	
	@Column(name="cod_numero_ip")
	private Integer numeroIp;
	
	@Column(name="cod_red_alambrica_tmp")
	private Integer redAlambricaTmp;
	
	/**Se agrega nombre de fantasia y comentarios
	 **/
	@Column(name = "comentarios")
	private String comentarios;
	
	@Column(name = "nombre_fantasia")
	private String nombreFantasia;

	public ContratoServicio() {
	}

	public Integer getCodContratoServicio() {
		return this.codContratoServicio;
	}

	public void setCodContratoServicio(Integer codContratoServicio) {
		this.codContratoServicio = codContratoServicio;
	}

	public String getCodUsuarioModificacion() {
		return this.codUsuarioModificacion;
	}

	public void setCodUsuarioModificacion(String codUsuarioModificacion) {
		this.codUsuarioModificacion = codUsuarioModificacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Contrato getContrato() {
		return this.contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public String getNumeroLinea() {
		return this.numeroLinea;
	}

	public void setNumeroLinea(String numeroLinea) {
		this.numeroLinea = numeroLinea;
	}
	/* agregado fechaInstalacion y fechaInicio. En fecha 2014 08 08 */

	public Date getFechaInstalacion() {
		return fechaInstalacion;
	}

	public void setFechaInstalacion(Date fechaInstalacion) {
		this.fechaInstalacion = fechaInstalacion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public ListaValoresDet getListaValoresDet() {
		return this.listaValoresDet;
	}

	public void setListaValoresDet(ListaValoresDet listaValoresDet) {
		this.listaValoresDet = listaValoresDet;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	@JsonIgnoreBackend
	public List<Debito> getDebitos() {
		return this.debitos;
	}

	@JsonProperty
	public void setDebitos(List<Debito> debitos) {
		this.debitos = debitos;
	}

	public Debito addDebito(Debito debito) {
		getDebitos().add(debito);
		debito.setContratoServicio(this);

		return debito;
	}

	public Debito removeDebito(Debito debito) {
		getDebitos().remove(debito);
		debito.setContratoServicio(null);

		return debito;
	}

	@JsonIgnoreBackend
	public List<ValorAtributoServicio> getValorAtributoServicios() {
		return this.valorAtributoServicios;
	}

	@JsonProperty
	public void setValorAtributoServicios(
			List<ValorAtributoServicio> valorAtributoServicios) {
		this.valorAtributoServicios = valorAtributoServicios;
	}

	public ValorAtributoServicio addValorAtributoServicio(
			ValorAtributoServicio valorAtributoServicio) {
		getValorAtributoServicios().add(valorAtributoServicio);
		valorAtributoServicio.setContratoServicio(this);

		return valorAtributoServicio;
	}

	public ValorAtributoServicio removeValorAtributoServicio(
			ValorAtributoServicio valorAtributoServicio) {
		getValorAtributoServicios().remove(valorAtributoServicio);
		valorAtributoServicio.setContratoServicio(null);

		return valorAtributoServicio;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public Central getCentral() {
		return central;
	}

	public void setCentral(Central central) {
		this.central = central;
	}

	/*public Oficina getOficina() {
		return oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}*/

	public Integer getCodDistritoOficina() {
		return codDistritoOficina;
	}

	public void setCodDistritoOficina(Integer codDistritoOficina) {
		this.codDistritoOficina = codDistritoOficina;
	}

	@JsonIgnoreBackend
	public List<CiclicoContratoServicio> getCiclicosContratoServicio() {
		return ciclicosContratoServicio;
	}

	@JsonProperty
	public void setCiclicosContratoServicio(
			List<CiclicoContratoServicio> ciclicosContratoServicio) {
		this.ciclicosContratoServicio = ciclicosContratoServicio;
	}

	public Integer getCodServicioMontado() {
		return codServicioMontado;
	}

	public void setCodServicioMontado(Integer codServicioMontado) {
		this.codServicioMontado = codServicioMontado;
	}

	@Override
	public Integer getId() {
		return this.codContratoServicio;
	}

	public RedAlambrica getRedAlambrica() {
		return redAlambrica;
	}

	public void setRedAlambrica(RedAlambrica redAlambrica) {
		this.redAlambrica = redAlambrica;
	}
	
	public RedInalambrica getRedInalambrica() {
		return redInalambrica;
	}

	public void setRedInalambrica(RedInalambrica redInalambrica) {
		this.redInalambrica = redInalambrica;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getNombreFantasia() {
		return nombreFantasia;
	}

	public void setNombreFantasia(String nombreFantasia) {
		this.nombreFantasia = nombreFantasia;
	}
	
	public void setRedADSL(Integer redADSL){
		this.redADSL = redADSL;
	}
	
	public Integer getRedADSL(){
		return this.redADSL;
	}
	
	public void setNumeroIp(Integer numeroIp){
		this.numeroIp = numeroIp;
	}
	
	public Integer getNumeroIp(){
		return this.numeroIp;
	}

	public void setRedAlambricaTmp(Integer redAlambricaTmp){
		this.redAlambricaTmp = redAlambricaTmp;
	}
	
	public Integer getRedAlambricaTmp(){
		return this.redAlambricaTmp;
	}

}