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
 * The persistent class for the atributos_servicio database table.
 * 
 */
@Entity
@Table(name="atributos_servicio")
public class AtributosServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "atributos_servicio_seq", sequenceName = "atributos_servicio_seq", allocationSize = 1)
	@GeneratedValue(generator = "atributos_servicio_seq")
	@Column(name="cod_atributos_servicio")
	private Integer codAtributosServicio;

	@Column(name="cod_tipo")
	private String codTipo;

	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String descripcion;
	private String valor;
	private String editable;
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	private String nombre;

	@Column(name="nombre_mostrar")
	private String nombreMostrar;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="cod_servicio")
	private Servicio servicio;

	//bi-directional many-to-one association to ValorAtributoServicio
	@OneToMany(mappedBy="atributosServicio")
	private List<ValorAtributoServicio> valorAtributoServicios;

	public AtributosServicio() {
	}

	public Integer getCodAtributosServicio() {
		return this.codAtributosServicio;
	}

	public void setCodAtributosServicio(Integer codAtributosServicio) {
		this.codAtributosServicio = codAtributosServicio;
	}

	public String getCodTipo() {
		return this.codTipo;
	}

	public void setCodTipo(String codTipo) {
		this.codTipo = codTipo;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreMostrar() {
		return this.nombreMostrar;
	}

	public void setNombreMostrar(String nombreMostrar) {
		this.nombreMostrar = nombreMostrar;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getEditable() {
		return editable;
	}

	public void setEditable(String editable) {
		this.editable = editable;
	}

	@JsonIgnore
	public List<ValorAtributoServicio> getValorAtributoServicios() {
		return this.valorAtributoServicios;
	}

	public void setValorAtributoServicios(List<ValorAtributoServicio> valorAtributoServicios) {
		this.valorAtributoServicios = valorAtributoServicios;
	}

	public ValorAtributoServicio addValorAtributoServicio(ValorAtributoServicio valorAtributoServicio) {
		getValorAtributoServicios().add(valorAtributoServicio);
		valorAtributoServicio.setAtributosServicio(this);

		return valorAtributoServicio;
	}

	public ValorAtributoServicio removeValorAtributoServicio(ValorAtributoServicio valorAtributoServicio) {
		getValorAtributoServicios().remove(valorAtributoServicio);
		valorAtributoServicio.setAtributosServicio(null);

		return valorAtributoServicio;
	}


	@Override
	public boolean equals(Object object) {
		
		if (!(object instanceof AtributosServicio)) {
            return false;
        }
		AtributosServicio other = (AtributosServicio) object;
        if ((this.codAtributosServicio == null && other.codAtributosServicio != null) || (this.codAtributosServicio != null && !this.codAtributosServicio.equals(other.codAtributosServicio))) {
            return false;
        }
        return true;
	}

	@Override
	public int hashCode() {
		
		int hash = 0;
        hash += (codAtributosServicio != null ? codAtributosServicio.hashCode() : 0);
        return hash;
	}
}