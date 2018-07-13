package py.com.copaco.billing.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Claudia Valenzuela <cvalenzuela@pol.una.py>
 * @since 1.0
 * @version 10/12/2015
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "red_inalambrica")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codRedInalambrica", callSuper = true)
public class RedInalambrica extends BaseEntity<Integer> {

	@Id
	@SequenceGenerator(name = "red_inalambrica_seq", sequenceName = "red_inalambrica_seq", allocationSize = 1)
	@GeneratedValue(generator = "red_inalambrica_seq")
	@Column(name = "cod_red_inalambrica")
	private Integer codRedInalambrica;

	@ManyToOne
	@JoinColumn(name = "cod_equipo_inalambrico")
	private EquipoTerminalUsuario equipoInalambrico;

	@ManyToOne
	@JoinColumn(name = "cod_numero")
	private Numero numero;

	@OneToOne
	@JoinColumn(name = "cod_simcard")
	private Simcard simcard;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return this.codRedInalambrica;
	}
}
