package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * The persistent class for the margen_impuesto database table.
 * 
 */
@Entity
@Table(name = "margen_impuesto")
public class MargenImpuesto extends BaseEntity<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_margen_impuesto")
	private String codMargenImpuesto;

	private String activo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "vigencia")
	private Date vigencia;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String descripcion;

	private Double porcentaje;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	// bi-directional many-to-one association to Cuenta
	@OneToMany(mappedBy = "margenImpuesto")
	private List<Cuenta> cuentas;

	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "margenImpuesto", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	private List<MargenImpuestoDet> listaMargenImpuestoDet;

	public MargenImpuesto() {
	}

	public String getCodMargenImpuesto() {
		return this.codMargenImpuesto;
	}

	public void setCodMargenImpuesto(String codMargenImpuesto) {
		this.codMargenImpuesto = codMargenImpuesto;
	}

	public Date getVigencia() {
		return vigencia;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
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
	public List<Cuenta> getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Cuenta addCuenta(Cuenta cuenta) {
		getCuentas().add(cuenta);
		cuenta.setMargenImpuesto(this);

		return cuenta;
	}

	public Cuenta removeCuenta(Cuenta cuenta) {
		getCuentas().remove(cuenta);
		cuenta.setMargenImpuesto(null);

		return cuenta;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof MargenImpuesto)) {
			return false;
		}
		MargenImpuesto other = (MargenImpuesto) object;
		if ((this.codMargenImpuesto == null && other.codMargenImpuesto != null)
				|| (this.codMargenImpuesto != null && !this.codMargenImpuesto
						.equals(other.codMargenImpuesto))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (codMargenImpuesto != null ? codMargenImpuesto.hashCode() : 0);
		return hash;
	}

	@Override
	public String getId() {
		return codMargenImpuesto;
	}

	@Override
	public String toString() {
		return codMargenImpuesto;

	}
}