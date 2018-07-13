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
 * Modificado por:
 * @author Monserrat Mora
 * @version Dic 15, 2015
 * cambios: 
 * se agregan los campos cantidadMaxima, cantidadMinima
 * 
 */


@Entity
@Table(name="servicios_producto")
public class ServiciosProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "servicio_producto_seq", sequenceName = "servicio_producto_seq", allocationSize = 1)
	@GeneratedValue(generator = "servicio_producto_seq")
	@Column(name="cod_servicio_producto")
	private Integer codServicioProducto;

	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="cod_producto")
	private Producto producto;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="cod_servicio")
	private Servicio servicio;
	
	@Column(name = "cantidad_maxima")
	private Integer cantidadMaxima;

	@Column(name = "cantidad_minima")
	private Integer cantidadMinima;
	

	public ServiciosProducto() {
	}

	public Integer getCodServicioProducto() {
		return this.codServicioProducto;
	}

	public void setCodServicioProducto(Integer codServicioProducto) {
		this.codServicioProducto = codServicioProducto;
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

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	public Integer getCantidadMaxima() {
		return this.cantidadMaxima;
	}

	public void setCantidadMaxima(Integer cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}

	public Integer getCantidadMinima() {
		return this.cantidadMinima;
	}

	public void setCantidadMinima(Integer cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}
	
	
	@Override
	public boolean equals(Object object) {
		
		if (!(object instanceof ServiciosProducto)) {
            return false;
        }
		ServiciosProducto other = (ServiciosProducto) object;
        if ((this.codServicioProducto == null && other.codServicioProducto != null) || (this.codServicioProducto != null && !this.codServicioProducto.equals(other.codServicioProducto))) {
            return false;
        }
        return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
        hash += (codServicioProducto != null ? codServicioProducto.hashCode() : 0);
        return hash;
	}

}