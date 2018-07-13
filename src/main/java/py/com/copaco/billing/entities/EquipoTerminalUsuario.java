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
 * @version 10/12/2015
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "equipo_terminal_usuario")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codEquipoTerminalUsuario", callSuper = true)
public class EquipoTerminalUsuario extends BaseEntity<Integer> {

	@Id
	@SequenceGenerator(name = "equipo_terminal_usuario_seq", sequenceName = "equipo_terminal_usuario_seq", allocationSize = 1)
	@GeneratedValue(generator = "equipo_terminal_usuario_seq")
	@Column(name = "cod_equipo_terminal_usuario")
	private Integer codEquipoTerminalUsuario;

	@Column(name = "marca")
	private String marca;

	@Column(name = "modelo")
	private String modelo;

	@Column(name = "nro_imei")
	private String nroImei;

	@Column(name = "nro_serie")
	private String nroSerie;

	@ManyToOne
	@JoinColumn(name = "cod_lv_estado")
	private ListaValoresDet estado;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return this.codEquipoTerminalUsuario;
	}
}
