package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * 
 * @author Clara Lopez
 * @since 1.0
 * @version 1.0 Jun 22, 2015
 * 
 */

@Entity
@Data
@EqualsAndHashCode(of="codProvAccion", callSuper=false)
@ToString(of="codProvAccion")
@Table(name="prov_accion")
public class ProvAccion extends BaseEntity<Integer> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "prov_accion_seq", sequenceName = "prov_accion_seq", allocationSize = 1)
	@GeneratedValue(generator = "prov_accion_seq")
	@Column(name = "cod_prov_accion_pk")
	private Integer codProvAccion;
	
	@Column(name="codigo_accion")
	private String codigoAccion;
	
	@Column(name="prioridad")
	private Integer prioridad;
	
	@ManyToOne
	@JoinColumn(name="cod_tecnologia")
	private Tecnologia tecnologia;
	
	
	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	

	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy="accion", cascade= CascadeType.ALL)
	private List<ProvAccionDet> detalles;
	
	@Column(name="es_recarga")
	private String esRecarga = "N";
	
	@Column(name="es_bloqueo")
	private String esBloqueo = "N";
		
	@Override
	public Integer getId() {
		
		return this.codProvAccion;
	}
	
	

}
