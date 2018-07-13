package py.com.copaco.billing.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Claudia Valenzuela
 * @since 1.0
 * @version 24/9/2015
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "orden_trabajo_det")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codOrdenTrabajoDet", callSuper = true)
public class OrdenTrabajoDet extends BaseEntity<Integer> {

	@Id
	@SequenceGenerator(name = "orden_trabajo_det_seq", sequenceName = "orden_trabajo_det_seq", allocationSize = 1)
	@GeneratedValue(generator = "orden_trabajo_det_seq")
	@Column(name = "cod_orden_trab_det")
	private Integer codOrdenTrabajoDet;

	private Integer puntos;

	@ManyToOne
	@JoinColumn(name = "cod_orden_trabajo")
	private OrdenTrabajo ordenTrabajo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_diagnostico")
	private Diagnostico diagnostico;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_solucion", referencedColumnName = "cod_solucion")
	private Solucion solucion;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_orden_servicio")
	private OrdenServicio ordenServicio;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_reclamo_pex")
	private ReclamoPex reclamoPex;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Column(name = "orden_tomada")
	private String ordenTomada;

	@Override
	public Integer getId() {
		return this.codOrdenTrabajoDet;
	}

}
