package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * 
 * @author Mauro Vera
 * @since 1.2
 * @version 1.3 Oct 23, 2014
 * 
 * @author Luis Fernandez
 * @version 1.4 Apr 29, 2015
 * 
 */
@Entity
@NamedQuery(name = "Evento.buscarPorNombre", query = "SELECT c FROM Evento c WHERE c.nombre = :nombre")
@Table(name = "evento")
@EqualsAndHashCode(of = "codEvento")
@ToString(of = "codEvento")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "evento_seq", sequenceName = "evento_seq", allocationSize = 1)
	@GeneratedValue(generator = "evento_seq")
	@Column(name = "cod_evento")
	private Integer codEvento;

	private String activo;

	private String particionado;

	private String almacenamiento;

	@Column(name = "almacenamiento_indice")
	private String almacenamientoIndice;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	private String nombre;

	// TODO llamarle conceptoDefecto
	// FIXME debe ser @OneToOne
	@OneToOne
	@JoinColumn(name = "cod_concepto")
	@JsonSerialize(as = ConceptoReducido.class)
	@Getter
	@Setter
	private Concepto conceptoDefecto;

	@Getter(onMethod = @_(@JsonIgnoreBackend))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "evento")
	private List<Concepto> conceptos;

	/**
	 * Actualizacion 19-08-2015. Se cambia el tipo de cascada para sea solo en
	 * caso de persistencia
	 */
	@OneToMany(mappedBy = "evento", cascade = { CascadeType.PERSIST,
			CascadeType.REMOVE })
	private List<AtributosEvento> atributosEventos;

	/*
	 * Actualizacion 29/04/2015 Se ha creado un nuevo campo atributoSubTipo para
	 * hacer referencia al atributo que es utilizado para subtificacion de un
	 * evento
	 */
	@Getter(onMethod = @_(@JsonIgnoreBackend))
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne
	@JoinColumn(name = "cod_attr_subtipo")
	private AtributosEvento atributoSubTipo;

	@OneToMany(mappedBy = "evento")
	private List<EventoServicio> eventoServicios;

	@OneToMany(mappedBy = "evento")
	private List<Regla> reglas;

	@Basic(fetch = FetchType.LAZY)
	@Lob
	@Column(name = "clase_tmp")
	private byte[] claseTmp;

	@Basic(fetch = FetchType.LAZY)
	@Lob
	@Column(name = "clase_ace")
	private byte[] claseAce;

	public Evento() {
	}

	public Integer getCodEvento() {
		return this.codEvento;
	}

	public void setCodEvento(Integer codEvento) {
		this.codEvento = codEvento;
	}

	public String getCodUsuarioModificacion() {
		return this.codUsuarioModificacion;
	}

	public void setCodUsuarioModificacion(String codUsuarioModificacion) {
		this.codUsuarioModificacion = codUsuarioModificacion;
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

	@JsonIgnoreBackend
	public List<AtributosEvento> getAtributosEventos() {
		return this.atributosEventos;
	}

	@JsonProperty
	public void setAtributosEventos(List<AtributosEvento> atributosEventos) {
		this.atributosEventos = atributosEventos;
	}

	public AtributosEvento addAtributosEvento(AtributosEvento atributosEvento) {
		getAtributosEventos().add(atributosEvento);
		atributosEvento.setEvento(this);

		return atributosEvento;
	}

	public AtributosEvento removeAtributosEvento(AtributosEvento atributosEvento) {
		getAtributosEventos().remove(atributosEvento);
		atributosEvento.setEvento(null);

		return atributosEvento;
	}

	@JsonIgnoreBackend
	public List<EventoServicio> getEventoServicios() {
		return this.eventoServicios;
	}

	public void setEventoServicios(List<EventoServicio> eventoServicios) {
		this.eventoServicios = eventoServicios;
	}

	public EventoServicio addEventoServicio(EventoServicio eventoServicio) {
		getEventoServicios().add(eventoServicio);
		eventoServicio.setEvento(this);

		return eventoServicio;
	}

	public EventoServicio removeEventoServicio(EventoServicio eventoServicio) {
		getEventoServicios().remove(eventoServicio);
		eventoServicio.setEvento(null);

		return eventoServicio;
	}

	@JsonIgnoreBackend
	public List<Regla> getReglas() {
		return this.reglas;
	}

	public void setReglas(List<Regla> reglas) {
		this.reglas = reglas;
	}

	public Regla addRegla(Regla regla) {
		getReglas().add(regla);
		regla.setEvento(this);

		return regla;
	}

	public Regla removeRegla(Regla regla) {
		getReglas().remove(regla);
		regla.setEvento(null);

		return regla;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getParticionado() {
		return particionado;
	}

	public void setParticionado(String particionado) {
		this.particionado = particionado;
	}

	public String getAlmacenamiento() {
		return almacenamiento;
	}

	public void setAlmacenamiento(String almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	public String getAlmacenamientoIndice() {
		return almacenamientoIndice;
	}

	public void setAlmacenamientoIndice(String almacenamientoIndice) {
		this.almacenamientoIndice = almacenamientoIndice;
	}

	public byte[] getClaseTmp() {
		return claseTmp;
	}

	public void setClaseTmp(byte[] claseTmp) {
		this.claseTmp = claseTmp;
	}

	public byte[] getClaseAce() {
		return claseAce;
	}

	public void setClaseAce(byte[] claseAce) {
		this.claseAce = claseAce;
	}

	/**
	 * Subclase de {@link Concepto} que permite odbiar el atributo evento.
	 * 
	 * <p>
	 * El atributo {@link Concepto#getEvento()} se refiere al evento que lo
	 * tiene como concepto, si este atributo es serializado, entonces ocurre una
	 * referencia circular, el evento tiene un concepto por defecto, el cual
	 * tiene un evento, en el caso normal el evento apunta a un concepto y este
	 * lo apunta de nuevo al evento, ocurriendo una referencia circular.
	 * </p>
	 * <p>
	 * Ideamente esto se solucionaria con JsonIdentity, pero esto no esta
	 * disponible hasta Jackson 2 (se utiliza 1.9.2)
	 * </p>
	 * 
	 * @author Silvestre Bernal
	 * 
	 */
	@JsonIgnoreProperties("evento")
	private static class ConceptoReducido extends Concepto {
		private static final long serialVersionUID = 1L;
	}

}