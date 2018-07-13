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
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representacion de la entidad de BD correspondiente a asignacion_cod_contable
 * 
 * @author Luis Fernandez
 * @since 1.0
 * @version 1.0 Apr 27, 2015
 *
 */

@Entity
@Table(name = "asignacion_cuenta_contable")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codAsignacion", callSuper = true)
public class AsignacionCuentaContable extends BaseEntity<Integer> implements
		Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "asignacion_cod_contable_seq", sequenceName = "asignacion_cod_contable_seq", allocationSize = 1)
	@GeneratedValue(generator = "asignacion_cod_contable_seq")
	@Column(name = "cod_asignacion")
	private Integer codAsignacion;

	@ManyToOne
	@JoinColumn(name = "cod_servicio")
	private Servicio servicio;

	@ManyToOne
	@JoinColumn(name = "cod_evento")
	private Evento evento;

	@ManyToOne
	@JoinColumn(name = "cod_cuenta_contable")
	private CuentaContable cuentaContable;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "cod_subtipo_evento")
	private ListaValoresDet subTipoEvento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_inicio_vig")
	private Date fechaInicioVigencia;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_fin_vig")
	private Date fechaFinVigencia;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return codAsignacion;
	}

}
