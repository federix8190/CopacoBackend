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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Luis Fernandez
 *
 */
@Data
@Entity
@Table(name = "notificacion_central")
@EqualsAndHashCode(of = "codNotificacionCentral", callSuper = true)
@ToString(of = "codNotificacionCentral")
public class NotificacionCentral extends BaseEntity<Integer> implements
		Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "notificacion_central_seq", sequenceName = "notificacion_central_seq", allocationSize = 1)
	@GeneratedValue(generator = "notificacion_central_seq")
	@Column(name = "cod_notificacion_central")
	private Integer codNotificacionCentral;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "fecha")
	private Date fecha;

	@Column(name = "estado")
	private String estado;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "cod_central")
	private Central central;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "cod_lv_incidencia")
	private ListaValoresDet incidencia;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return codNotificacionCentral;
	}

}
