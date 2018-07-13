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

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Luis Fernandez
 *
 */
@Entity
@Table(name = "reincidencia_reclamo")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codReincidenciaReclamo", callSuper = true)
public class ReincidenciaReclamo extends BaseEntity<Integer> implements
		Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cod_reincidencia_reclamo")
	@SequenceGenerator(name = "reincidencia_reclamo_seq", sequenceName = "reincidencia_reclamo_seq", allocationSize = 1)
	@GeneratedValue(generator = "reincidencia_reclamo_seq")
	private Integer codReincidenciaReclamo;
	
	

	@Column(name = "nro_reincidencia")
	private Integer nroReincidencia;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_reincidencia")
	private Date fechaReincidencia;

	@Column(name = "comentario")
	private String comentario;

	@Getter
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne
	@JoinColumn(name = "cod_reclamo")
	private Reclamo reclamo;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return codReincidenciaReclamo;
	}

}
