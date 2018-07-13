package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the despacho_detalle database table.
 * 
 */
@Entity
@Table(name="despacho_detalle")
public class DespachoDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "despacho_detalle_seq", sequenceName = "despacho_detalle_seq", allocationSize = 1)
	@GeneratedValue(generator = "despacho_detalle_seq")
	@Column(name="cod_despacho_detalle")
	private Integer codDespachoDetalle;

	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	//bi-directional many-to-one association to Despacho
	@ManyToOne
	@JoinColumn(name="cod_despacho")
	private Despacho despacho;

	public DespachoDetalle() {
	}


	public Integer getCodDespachoDetalle() {
		return codDespachoDetalle;
	}
	public void setCodDespachoDetalle(Integer codDespachoDetalle) {
		this.codDespachoDetalle = codDespachoDetalle;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
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

	

	public Despacho getDespacho() {
		return this.despacho;
	}

	public void setDespacho(Despacho despacho) {
		this.despacho = despacho;
	}

	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof DespachoDetalle)) {
			return false;
		}
		DespachoDetalle other = (DespachoDetalle) object;
		if ((this.codDespachoDetalle == null && other.codDespachoDetalle != null)
				|| (this.codDespachoDetalle != null && !this.codDespachoDetalle
						.equals(other.codDespachoDetalle))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (codDespachoDetalle != null ? codDespachoDetalle.hashCode() : 0);
		return hash;
	}
}