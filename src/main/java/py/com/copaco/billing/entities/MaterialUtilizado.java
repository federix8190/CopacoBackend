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
@Table(name = "material_utilizado")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codMaterialUtilizado", callSuper = true)
public class MaterialUtilizado extends BaseEntity<Integer> {

	@Id
	@SequenceGenerator(name = "material_utilizado_seq", sequenceName = "material_utilizado_seq", allocationSize = 1)
	@GeneratedValue(generator = "material_utilizado_seq")
	@Column(name = "cod_material_utilizado")
	private Integer codMaterialUtilizado;

	@ManyToOne
	@JoinColumn(name = "cod_orden_servicio")
	private OrdenServicio ordenServicio;

	@ManyToOne
	@JoinColumn(name = "cod_material_deposito")
	private MaterialDeposito materialDeposito;

	@Column(name = "cant_utilizada")
	private Integer cantUtilizada;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@ManyToOne
	@JoinColumn(name = "cod_solucion")
	private Solucion solucion;
	
	@Override
	public Integer getId() {
		return this.codMaterialUtilizado;
	}

}
