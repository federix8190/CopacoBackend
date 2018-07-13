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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: RolCargosCuotas
 *
 */
@Entity
@Table(name = "rol_cargos_cuotas")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codRolCargoCutoas", callSuper = true)
public class RolCargosCuotas extends BaseEntity<Integer> implements
		Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "rol_cargos_cuotas_seq", sequenceName = "rol_cargos_cuotas_seq", allocationSize = 1)
	@GeneratedValue(generator = "rol_cargos_cuotas_seq")
	@Column(name = "cod_rol_cargos_cuotas")
	private Integer codRolCargoCutoas;

	@Column(name = "cant_cuotas_max")
	private Integer cantCuotasMax;

	@Column(name = "cant_cargos_min")
	private Integer cantCargosMin;

	@Column(name = "cant_cargos_max")
	private Integer cantCargosMax;

	@ManyToOne
	@JoinColumn(name = "cod_rol")
	private Rol rol;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return codRolCargoCutoas;
	}

}
