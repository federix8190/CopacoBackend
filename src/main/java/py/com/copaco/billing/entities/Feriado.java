package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the feriado database table.
 * 
 */
@Entity
@NamedQuery(name="Feriado.findAll", query="SELECT f FROM Feriado f")
public class Feriado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "feriado_seq", sequenceName = "feriado_seq", allocationSize = 1)
	@GeneratedValue(generator = "feriado_seq")
	@Column(name="cod_feriado")
	private Integer codFeriado;

	private String activo;

	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	private String motivo;

	private String vigente;

	public Feriado() {
	}

	public Integer getCodFeriado() {
		return this.codFeriado;
	}

	public void setCodFeriado(Integer codFeriado) {
		this.codFeriado = codFeriado;
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

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getVigente() {
		return this.vigente;
	}

	public void setVigente(String vigente) {
		this.vigente = vigente;
	}

}