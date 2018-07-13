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
@Table(name = "simcard")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codSimcard", callSuper = true)
public class Simcard extends BaseEntity<Integer> {

	@Id
	@SequenceGenerator(name = "simcard_seq", sequenceName = "simcard_seq", allocationSize = 1)
	@GeneratedValue(generator = "simcard_seq")
	@Column(name = "cod_simcard")
	private Integer codSimcard;

	@Column(name = "iccid")
	private String iccid;

	@Column(name = "imsi")
	private String imsi;

	@Column(name = "pin1")
	private String pin1;

	@Column(name = "pin2")
	private String pin2;

	@Column(name = "puk1")
	private String puk1;

	@Column(name = "puk2")
	private String puk2;

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
		return this.codSimcard;
	}
}
