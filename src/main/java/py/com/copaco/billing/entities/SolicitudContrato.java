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

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * The persistent class for the solicitud_contrato database table.
 * 
 */
@Entity
@Table(name = "solicitud_contrato")
@Data
@EqualsAndHashCode(of = "codSolicitudContrato", callSuper = false)
@ToString(of = "codSolicitudContrato")
public class SolicitudContrato extends BaseEntity<Integer> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "solicitud_contrato_seq", sequenceName = "solicitud_contrato_seq", allocationSize = 1)
	@GeneratedValue(generator = "solicitud_contrato_seq")
	@Column(name = "cod_solicitud_contrato")
	private Integer codSolicitudContrato;

	@ManyToOne
	@JoinColumn(name = "cod_solicitud")
	private Solicitud solicitud;

	@ManyToOne
	@JoinColumn(name = "cod_contrato")
	private Contrato contrato;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return this.codSolicitudContrato;
	}

}
