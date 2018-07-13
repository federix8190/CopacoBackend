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

import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 *  
 * @author Monserrat Mora
 * @since 2.0
 * @version set 12, 2014
 * 
 */


@Entity
@EqualsAndHashCode(of = "codRegla", callSuper = false)
@ToString(of = "codRegla")
public class Regla  extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "regla_seq", sequenceName = "regla_seq", allocationSize = 1)
	@GeneratedValue(generator = "regla_seq")
	@Column(name="cod_regla")
	private Integer codRegla;

	private String accion;

	private String activo;

	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String condicion;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	private String nombre;
	
	private String editable;

	private String tipo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="vigencia_desde")
	private Date vigenciaDesde;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="vigencia_hasta")
	private Date vigenciaHasta;

	@ManyToOne
	@JoinColumn(name="cod_evento_servicio")
	private EventoServicio eventoServicio;


	@OneToMany(mappedBy="regla", cascade= CascadeType.ALL)
	private List<ReglaEtiqueta> reglaEtiquetas;

	@ManyToOne
	@JoinColumn(name="cod_evento")
	private Evento evento;
	
	@Column(name="condicion_comp")
	private String condicionComp;
	
	@Column(name="accion_comp")
	private String accionComp;
	
	@ManyToOne
	@JoinColumn(name="cod_concepto")
	private Concepto concepto;
	
	

	public Regla() {
	}

	public Integer getCodRegla() {
		return this.codRegla;
	}

	public void setCodRegla(Integer codRegla) {
		this.codRegla = codRegla;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getCodUsuarioModificacion() {
		return this.codUsuarioModificacion;
	}

	public void setCodUsuarioModificacion(String codUsuarioModificacion) {
		this.codUsuarioModificacion = codUsuarioModificacion;
	}

	public String getCondicion() {
		return this.condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEditable() {
		return editable;
	}

	public void setEditable(String editable) {
		this.editable = editable;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getVigenciaDesde() {
		return this.vigenciaDesde;
	}

	public void setVigenciaDesde(Date vigenciaDesde) {
		this.vigenciaDesde = vigenciaDesde;
	}

	public Date getVigenciaHasta() {
		return this.vigenciaHasta;
	}

	public void setVigenciaHasta(Date vigenciaHasta) {
		this.vigenciaHasta = vigenciaHasta;
	}

	public EventoServicio getEventoServicio() {
		return this.eventoServicio;
	}

	public void setEventoServicio(EventoServicio eventoServicio) {
		this.eventoServicio = eventoServicio;
	}

	@JsonIgnoreBackend
	public List<ReglaEtiqueta> getReglaEtiquetas() {
		return this.reglaEtiquetas;
	}

	@JsonProperty
	public void setReglaEtiquetas(List<ReglaEtiqueta> reglaEtiquetas) {
		this.reglaEtiquetas = reglaEtiquetas;
	}

	public ReglaEtiqueta addReglaEtiqueta(ReglaEtiqueta reglaEtiqueta) {
		getReglaEtiquetas().add(reglaEtiqueta);
		reglaEtiqueta.setRegla(this);

		return reglaEtiqueta;
	}

	public ReglaEtiqueta removeReglaEtiqueta(ReglaEtiqueta reglaEtiqueta) {
		getReglaEtiquetas().remove(reglaEtiqueta);
		reglaEtiqueta.setRegla(null);

		return reglaEtiqueta;
	}
		
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}	

	public String getCondicionComp() {
		return condicionComp;
	}

	public void setCondicionComp(String condicionComp) {
		this.condicionComp = condicionComp;
	}

	public String getAccionComp() {
		return accionComp;
	}

	public void setAccionComp(String accionComp) {
		this.accionComp = accionComp;
	}
	
	public Concepto getConcepto() {
		return concepto;
	}

	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}

	@Override
	public Integer getId() {
		return getCodRegla();
	}
}