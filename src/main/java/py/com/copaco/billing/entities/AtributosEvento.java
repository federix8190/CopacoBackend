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
 * @since 1.0
 * @version 1.0 Oct 07, 2014
 *
 */
@Entity
@Table(name = "atributos_evento")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codAtributosEvento", callSuper = true)
public class AtributosEvento extends BaseEntity<Integer> implements
		Serializable {

	private static final long serialVersionUID = -2396464253009530772L;

	@Id
	@SequenceGenerator(name = "atributos_evento_seq", sequenceName = "atributos_evento_seq", allocationSize = 1)
	@GeneratedValue(generator = "atributos_evento_seq")
	@Column(name = "cod_atributos_evento")
	private Integer codAtributosEvento;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Column(name = "cod_tipo")
	private String codTipo;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Column(name = "nro_orden")
	private Integer numeroOrden;

	@Column(name = "nombre_lista_valor")
	private String nombreListaValor;

	private String nombre;

	@Column(name = "nombre_mostrar")
	private String nombreMostrar;

	@ManyToOne
	@JoinColumn(name = "cod_evento")
	private Evento evento;

	@Override
	public Integer getId() {

		return codAtributosEvento;
	}

}
