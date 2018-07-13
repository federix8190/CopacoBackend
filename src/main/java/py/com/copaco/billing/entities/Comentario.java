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

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Clase que representa a la tabla comentario en la BD
 * 
 * @author Luis Fernandez
 * @since 3.0
 * @version 1.0 May 27, 2015
 *
 */
@Entity
@Table(name = "comentario")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codComentario", callSuper = true)
public class Comentario extends BaseEntity<Integer> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "comentario_seq", sequenceName = "comentario_seq", allocationSize = 1)
	@GeneratedValue(generator = "comentario_seq")
	@Column(name = "cod_comentario")
	private Integer codComentario;

	private String comentario;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_comentario")
	private Date fechaComentario;

	@Column(name = "usuario_comentario")
	private String usuarioComentario;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Getter
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne
	@JoinColumn(name = "cod_reclamo_facturacion_det", referencedColumnName = "cod_reclamo_facturacion_det")
	private ReclamoFacturacionDet reclamoFacturacionDet;

	@Override
	public Integer getId() {
		return this.codComentario;
	}

}
