package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.ToString;

import org.codehaus.jackson.annotate.JsonIgnore;


/**
 * The persistent class for the tecnologia database table.
 * 
 */
@Entity
@ToString(of = "codTecnologia")
@Table(name="tecnologia")
public class Tecnologia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_tecnologia")
	private String codTecnologia;

	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="tecnologia")
	private List<Servicio> servicios;
	
	@ManyToOne
	@JoinColumn(name = "cod_lv_tipo_red")
	private ListaValoresDet tipoRed;

	
	public Tecnologia() {
	}

	public String getCodTecnologia() {
		return this.codTecnologia;
	}

	public void setCodTecnologia(String codTecnologia) {
		this.codTecnologia = codTecnologia;
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

	@JsonIgnore
	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setTecnologia(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setTecnologia(null);

		return servicio;
	}
	
	@Override
	public boolean equals(Object object) {
		
		if (!(object instanceof Tecnologia)) {
            return false;
        }
		Tecnologia other = (Tecnologia) object;
        if ((this.codTecnologia == null && other.codTecnologia != null) || (this.codTecnologia != null && !this.codTecnologia.equals(other.codTecnologia))) {
            return false;
        }
        return true;
	}

	@Override
	public int hashCode() {
		
		int hash = 0;
        hash += (codTecnologia != null ? codTecnologia.hashCode() : 0);
        return hash;
	}

	public ListaValoresDet getTipoRed() {
		return tipoRed;
	}

	public void setTipoRed(ListaValoresDet tipoRed) {
		this.tipoRed = tipoRed;
	}

}