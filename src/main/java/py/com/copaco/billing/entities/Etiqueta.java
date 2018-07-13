package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@NamedQuery(name="Etiqueta.findAll", query="SELECT e FROM Etiqueta e")
public class Etiqueta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "etiqueta_seq", sequenceName = "etiqueta_seq", allocationSize = 1)
	@GeneratedValue(generator = "etiqueta_seq")
	@Column(name="cod_etiqueta")
	private Integer codEtiqueta;

	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@OneToMany(mappedBy="etiqueta", cascade=CascadeType.PERSIST)
	private List<ReglaEtiqueta> reglaEtiquetas;

	public Etiqueta() {
	}

	public Integer getCodEtiqueta() {
		return this.codEtiqueta;
	}

	public void setCodEtiqueta(Integer codEtiqueta) {
		this.codEtiqueta = codEtiqueta;
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
	public List<ReglaEtiqueta> getReglaEtiquetas() {
		return this.reglaEtiquetas;
	}

	@JsonProperty
	public void setReglaEtiquetas(List<ReglaEtiqueta> reglaEtiquetas) {
		this.reglaEtiquetas = reglaEtiquetas;
	}

	public ReglaEtiqueta addReglaEtiqueta(ReglaEtiqueta reglaEtiqueta) {
		getReglaEtiquetas().add(reglaEtiqueta);
		reglaEtiqueta.setEtiqueta(this);

		return reglaEtiqueta;
	}

	public ReglaEtiqueta removeReglaEtiqueta(ReglaEtiqueta reglaEtiqueta) {
		getReglaEtiquetas().remove(reglaEtiqueta);
		reglaEtiqueta.setEtiqueta(null);

		return reglaEtiqueta;
	}
	
	@Override
	public boolean equals(Object object) {
		
		if (!(object instanceof Etiqueta)) {
            return false;
        }
		Etiqueta other = (Etiqueta) object;
        if ((this.codEtiqueta == null && other.codEtiqueta != null) || (this.codEtiqueta != null && !this.codEtiqueta.equals(other.codEtiqueta))) {
            return false;
        }
        return true;
	}

	@Override
	public int hashCode() {
		
		int hash = 0;
        hash += (codEtiqueta != null ? codEtiqueta.hashCode() : 0);
        return hash;
	}

}