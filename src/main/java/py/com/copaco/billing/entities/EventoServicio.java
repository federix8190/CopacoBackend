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

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * The persistent class for the evento_servicio database table.
 * 
 */
@Entity
@Table(name = "evento_servicio")
public class EventoServicio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "evento_servicio_seq", sequenceName = "evento_servicio_seq", allocationSize = 1)
    @GeneratedValue(generator = "evento_servicio_seq")
    @Column(name = "cod_evento_servicio")
    private Integer codEventoServicio;

    @Column(name = "cod_usuario_modificacion")
    private String codUsuarioModificacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    // bi-directional many-to-one association to Evento
    @ManyToOne
    @JoinColumn(name = "cod_evento")
    private Evento evento;

    // bi-directional many-to-one association to Regla
    @OneToMany(mappedBy = "eventoServicio")
    private List<Regla> reglas;

    // bi-directional many-to-one association to Servicio
    @ManyToOne
    @JoinColumn(name = "cod_servicio")
    private Servicio servicio;

    public EventoServicio() {
    }

    public Integer getCodEventoServicio() {
	return this.codEventoServicio;
    }

    public void setCodEventoServicio(Integer codEventoServicio) {
	this.codEventoServicio = codEventoServicio;
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

    public Evento getEvento() {
	return this.evento;
    }

    public void setEvento(Evento evento) {
	this.evento = evento;
    }

    public Servicio getServicio() {
	return this.servicio;
    }

    public void setServicio(Servicio servicio) {
	this.servicio = servicio;
    }

    @JsonIgnore
    public List<Regla> getReglas() {
	return this.reglas;
    }

    public void setReglas(List<Regla> reglas) {
	this.reglas = reglas;
    }

    public Regla addRegla(Regla regla) {
	getReglas().add(regla);
	regla.setEventoServicio(this);

	return regla;
    }

    public Regla removeRegla(Regla regla) {
	getReglas().remove(regla);
	regla.setEventoServicio(null);

	return regla;
    }

    @Override
    public boolean equals(Object object) {
	if (!(object instanceof EventoServicio)) {
	    return false;
	}
	EventoServicio other = (EventoServicio) object;
	if ((this.codEventoServicio == null && other.codEventoServicio != null)
		|| (this.codEventoServicio != null && !this.codEventoServicio
			.equals(other.codEventoServicio))) {
	    return false;
	}
	return true;
    }

    @Override
    public int hashCode() {
	
	int hash = 0;
	hash += (codEventoServicio != null ? codEventoServicio.hashCode() : 0);
	return hash;
    }

}