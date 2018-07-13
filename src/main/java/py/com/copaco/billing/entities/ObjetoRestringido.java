package py.com.copaco.billing.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Eduardo Mendez
 * @since 1.0
 * @version 1.0 Feb 2, 2015
 * 
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codObjetoRestringido", callSuper = true)
@Table(name="objeto_restringido")
public class ObjetoRestringido extends BaseEntity<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_objeto_restringido")
	private String codObjetoRestringido;


	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	
	private String nombre;
	
	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	
	@Override
	public String getId() {
		return codObjetoRestringido;
	}

}