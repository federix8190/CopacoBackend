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
import lombok.ToString;

/**
 * 
 * @author Eduardo Mendez
 * @since 1.0
 * @version 1.0 Feb 3, 2015
 * 
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codPermisoObjeto", callSuper = true)
@Table(name="permiso_objeto")
public class PermisoObjeto extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "permiso_objeto_seq", sequenceName = "permiso_objeto_seq", allocationSize = 1)
	@GeneratedValue(generator = "permiso_objeto_seq")
	@Column(name="cod_permiso_objeto")
	private Integer codPermisoObjeto;

	private String nombre;
	
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "cod_objeto_restringido")
	private ObjetoRestringido objetoRestringido;

	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;


	@Override
	public Integer getId() {
		return codPermisoObjeto;
	}

}