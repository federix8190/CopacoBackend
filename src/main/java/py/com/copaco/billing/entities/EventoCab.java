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
*
* @author Mauro Vera
* @since 1.1
* @version 1.2 Oct 17, 2014
* 
*/
@Entity
@Table(name = "evento_cab")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codEventoCab", callSuper = false)
public class EventoCab extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "evento_cab_seq", sequenceName = "evento_cab_seq", allocationSize = 1)
	@GeneratedValue(generator = "evento_cab_seq")
	@Column(name = "cod_evento_cab")
	private Integer codEventoCab;

	@ManyToOne
	@JoinColumn(name = "cod_evento")
	private Evento evento;

	private String estado;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_ultima_retasacion")
	private Date fechaUltimaRetasacion;
	
	@Column(name = "tipo_evento_cab")
	private String tipoEventoCab;
	
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return codEventoCab;
	}
}