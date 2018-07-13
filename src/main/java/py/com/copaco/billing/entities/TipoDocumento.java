package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The persistent class for the tipo_documento database table.
 * 
 */
@Entity
@Table(name = "tipo_documento")
@Cacheable
@Data
@ToString(of = "codTipoDocumento")
@EqualsAndHashCode(of = "codTipoDocumento")
@NoArgsConstructor
public class TipoDocumento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_tipo_documento")
	private String codTipoDocumento;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String activo;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

}