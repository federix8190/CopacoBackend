package py.com.copaco.billing.entities;

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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Claudia Valenzuela <cvalenzuela@pol.una.py>
 * @since 1.0
 * @version 3/12/2015
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "orden_equipo_det")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codOrdenEquipoDet", callSuper = true)
public class OrdenEquipoDet extends BaseEntity<Integer> {

	@Id
	@SequenceGenerator(name = "orden_equipo_det_seq", sequenceName = "orden_equipo_det_seq", allocationSize = 1)
	@GeneratedValue(generator = "orden_equipo_det_seq")
	@Column(name = "cod_orden_equipo_det")
	private Integer codOrdenEquipoDet;

	@Column(name = "marca")
	private String marca;

	@Column(name = "modelo")
	private String modelo;

	@Column(name = "nro_serie")
	private String nroSerie;

	@ManyToOne
	@JoinColumn(name = "cod_lv_tipo")
	private ListaValoresDet tipo;

	@ManyToOne
	@JoinColumn(name = "cod_orden_servicio")
	private OrdenServicio ordenServicio;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return this.codOrdenEquipoDet;
	}

}
