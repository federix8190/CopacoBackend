package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the segmento database table.
 * 
 */
@Entity
public class Segmento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cod_segmento")
    private String codSegmento;

    @Column(name = "cod_usuario_modificacion")
    private String codUsuarioModificacion;

    private String descripcion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    public Segmento() {
    }

    public String getCodSegmento() {
	return codSegmento;
    }

    public void setCodSegmento(String codSegmento) {
	this.codSegmento = codSegmento;
    }

    public String getDescripcion() {
	return descripcion;
    }

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
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

    @Override
    public boolean equals(Object object) {
	
	if (!(object instanceof Segmento)) {
	    return false;
	}
	Segmento other = (Segmento) object;
	if ((this.codSegmento == null && other.codSegmento != null)
		|| (this.codSegmento != null && !this.codSegmento
			.equals(other.codSegmento))) {
	    return false;
	}
	return true;
    }

    @Override
    public int hashCode() {
	
	int hash = 0;
	hash += (codSegmento != null ? codSegmento.hashCode() : 0);
	return hash;
    }

}