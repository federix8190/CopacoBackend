package py.com.copaco.billing.entities;

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
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * 
 * @author Mauro Vera
 * @since 1.0
 * @version 1.0 sep 07, 2015
 * 
 */
@Entity
@Table(name = "orden_trabajo")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codOrdenTrabajo", callSuper = true)
public class OrdenTrabajo extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6834980250961618741L;

	@Id
	@SequenceGenerator(name = "orden_trabajo_seq", sequenceName = "orden_trabajo_seq", allocationSize = 1)
	@GeneratedValue(generator = "orden_trabajo_seq")
	@Column(name = "cod_orden_trabajo")
	private Integer codOrdenTrabajo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha")
	private Date fecha;

	private String turno;

	private String finalizado;
	
	@ManyToOne
	@JoinColumn(name="cod_vehiculo")
	private Vehiculo vehiculo;

	@Column(name = "estado_vehiculo")
	private String EstadoVehiculo;

	@ManyToOne
	@JoinColumn(name = "cod_central_asignada")
	private Central central;

	@ManyToOne
	@JoinColumn(name = "cod_cuadrilla")
	private Cuadrilla cuadrilla;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "ordenTrabajo", cascade = CascadeType.ALL)
	private List<OrdenTrabajoDet> ordenTrabajoDets;

	@Override
	public Integer getId() {
		return this.codOrdenTrabajo;
	}

}
