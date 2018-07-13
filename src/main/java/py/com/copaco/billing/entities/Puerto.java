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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * @author Willian Martinez
 * @since 1.0
 * @version 1.0 Mar 27, 2015
 */
@Entity
@Data
@EqualsAndHashCode(of = "codPuerto", callSuper = false)
@ToString(of = "codPuerto")
public class Puerto extends BaseEntity<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "puerto_seq", sequenceName = "puerto_seq", allocationSize = 1)
	@GeneratedValue(generator = "puerto_seq")
	@Column(name = "cod_puerto")
	private Integer codPuerto;

	@Column(name = "puerto_horizontal")
	private String puertoHorizontal;

	@Column(name = "puerto_digital")
	private String puertoDigital;

	@OneToOne
	@JoinColumn(name = "cod_numero")
	private Numero numero;

	@ManyToOne
	@JoinColumn(name = "cod_distribuidor")
	private Distribuidor distribuidor;

	@ManyToOne
	@JoinColumn(name = "cod_lv_estado")
	private ListaValoresDet lvEstado;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return this.codPuerto;
	}

}
