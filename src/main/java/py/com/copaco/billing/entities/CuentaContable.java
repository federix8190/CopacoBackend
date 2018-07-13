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
 * Representacion de clase de la entidad de la BD CodigoContable
 * 
 * @author Luis Fernandez
 * @since 1.0
 * @version 1.0 Apr 16, 2015
 * 
 */

@Entity
@Data
@Table(name = "cuenta_contable")
@NoArgsConstructor
@EqualsAndHashCode(of = "codCuentaContable", callSuper = true)
public class CuentaContable extends BaseEntity<String> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_cuenta_contable")
	private String codCuentaContable;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public String getId() {
		return codCuentaContable;
	}
}
