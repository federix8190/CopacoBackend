package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * @author Monserrat Mora
 * @author Mauro Vera
 * @since 1.1
 * @version 1.2 Sep 22, 2014
 *
 * @author Monserrat Mora
 * @version 3.0 Dic 10, 2015
 * Cambio: Se agrega lista ServiciosMontables
 */


@Entity
@Table(name="servicio")
@NamedQuery(name="Servicio.buscarPorCodigo", query="SELECT c FROM Servicio c WHERE c.codServicio = :codigo")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codServicio", callSuper = false)
public class Servicio extends BaseEntity<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_servicio")
	private String codServicio;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String descripcion;

	private String activo;
	
	private String montable;

	@Column(name = "modalidad")
	private String modalidad;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	
	@Getter(onMethod=@_({@JsonIgnoreBackend}))
	@Setter(onMethod=@_(@JsonProperty))
	@OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
	private List<AtributosServicio> atributosServicios;

	
	@Getter(onMethod=@_({@JsonIgnoreBackend}))
	@Setter(onMethod=@_(@JsonProperty))
	@OneToMany(mappedBy = "servicio")
	private List<ContratoServicio> contratoServicios;

	
	@Getter(onMethod=@_({@JsonIgnoreBackend}))
	@Setter(onMethod=@_(@JsonProperty))
	@OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
	private List<EventoServicio> eventoServicios;

	@ManyToOne
	@JoinColumn(name = "cod_tecnologia")
	private Tecnologia tecnologia;

	
	@Getter(onMethod=@_({@JsonIgnoreBackend}))
	@Setter(onMethod=@_(@JsonProperty))
	@OneToMany(mappedBy = "servicio")
	private List<ServiciosProducto> serviciosProductos;
	
	
	@Getter(onMethod=@_({@JsonIgnoreBackend}))
	@Setter(onMethod=@_(@JsonProperty))
	@OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
	private List<ServiciosMontados> serviciosMontables;
	

	@Basic(fetch = FetchType.LAZY)
	@Lob
	private byte[] clase;
		
	
	@Override
	public String getId() {
		return getCodServicio();
	}

	

}