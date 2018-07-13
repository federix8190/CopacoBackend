package py.com.copaco.billing.entities;

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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;


/**
 * The persistent class for the entidad_financiera database table.
 * 
 */
@Entity
@Table(name="entidad_financiera")
@EqualsAndHashCode(of="codEntidadFinanciera", callSuper=false)
@ToString(of="codEntidadFinanciera")
public class EntidadFinanciera extends BaseEntity<String>{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_entidad_financiera")
	private String codEntidadFinanciera;

	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	private String nombre;

	public EntidadFinanciera() {
	}

	public String getCodEntidadFinanciera() {
		return this.codEntidadFinanciera;
	}

	public void setCodEntidadFinanciera(String codEntidadFinanciera) {
		this.codEntidadFinanciera = codEntidadFinanciera;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "entidadFinanciera", cascade = { CascadeType.ALL })
	private List<CuentaBancaria> listaCuentaBancarias;
	
	@Override
	public String getId() {
		return this.codEntidadFinanciera;
	}

}