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
import javax.persistence.OneToOne;
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
import org.hibernate.annotations.Formula;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * @author Claudia Valenzuela <cvalenzuela@pol.una.py>
 * @since 1.0
 * @version 27/10/2015
 * 
 * @author Mirta Gonzalez
 * @version 16/05/2016
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "orden_servicio")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codOrdenServicio", callSuper = true)
public class OrdenServicio extends BaseEntity<Integer> {

	@Id
	@SequenceGenerator(name = "orden_servicio_seq", sequenceName = "orden_servicio_seq", allocationSize = 1)
	@GeneratedValue(generator = "orden_servicio_seq")
	@Column(name = "cod_orden_servicio")
	private Integer codOrdenServicio;

	@Column(name = "estado")
	private String estado;

	@Column(name = "comentario")
	private String comentario;

	@Column(name = "observacion_ejecucion")
	private String observacionEjecucion;

	@Column(name = "otros_materiales")
	private String otrosMateriales;

	@ManyToOne//(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "cod_contrato_servicio")
	private ContratoServicio contratoServicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_hora_ejecucion")
	private Date fechaHoraEjecucion;

	@Column(name = "tipo_orden")
	private String tipoOrden;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "cod_red_actual")
	private OrdenRedDet redActual;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "cod_red_nueva")
	private OrdenRedDet redNueva;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_hora_creacion")
	private Date fechaHoraCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_posible_conexion")
	private Date fechaPosibleConexion;

	@Column(name = "nro_contacto")
	private String nroContacto;

	@Column(name = "apellido_contacto")
	private String apellidoContacto;

	@Column(name = "nombre_contacto")
	private String nombreContacto;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "cod_red_alambrica_tmp")
	private RedAlambricaTmp redAlambricaTmp;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Getter(onMethod=@_({@JsonIgnoreBackend}))
	@Setter(onMethod=@_(@JsonProperty))
	@OneToMany(mappedBy = "ordenServicio",cascade = {CascadeType.ALL })
	private List<TecnicoReclamo> listaTecnicoReclamo;

	@Formula(value = "(select case when os.estado <> 'OE' and os.estado <> 'NE' then today()- date(os.fecha_hora_creacion) else 0 end from orden_servicio os where os.cod_orden_servicio=cod_orden_servicio)")
	private Integer diasPendientes;

	@Formula(value = "(select "
			+ " case when os.tipo_orden not in  ('NI','CA','CN') and act.central is not null then act.central "
			+ "     when os.tipo_orden in ('NI','CA','CN') and nue.central is not null then nue.central "
			+ "     else ciu.descripcion "
			+ " end "
			+ " from orden_servicio os "
			+ " join contrato_servicio cs on cs.cod_contrato_servicio = os.cod_contrato_servicio "
			+ " join direccion dir on dir.cod_direccion = cs.cod_direccion "
			+ " join ciudad ciu on ciu.cod_ciudad = dir.cod_ciudad "
			+ " left join orden_red_det act on act.cod_orden_red_det = os.cod_red_actual "
			+ " left join orden_red_det nue on nue.cod_orden_red_det = os.cod_red_nueva"
			+ " where os.cod_orden_servicio = cod_orden_servicio)")
	private String central;
	
	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "ordenServicio", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REMOVE })
	private List<OrdenEquipoDet> listaEquipoDet;
	
	@ManyToOne
	@JoinColumn(name = "cod_direccion")
	private Direccion direccion;

	@Override
	public Integer getId() {
		return this.codOrdenServicio;
	}

}
