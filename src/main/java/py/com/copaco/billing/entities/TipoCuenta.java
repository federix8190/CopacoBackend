package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * Representacion de la entidad de BD correspondiente a Tipo Cuenta
 * 
 * @author Luis Fernandez
 * @since 1.0
 * @version 1.0 Apr 16, 2015
 *
 */

@Entity
@Table(name = "tipo_cuenta")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codTipoCuenta", callSuper = true)
public class TipoCuenta extends BaseEntity<String> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_tipo_cuenta")
	private String codTipoCuenta;

	@Column(name = "descripcion")
	private String descripcion;

	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "tipoCuenta", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE})
	private List<TipoCuentaDet> listaTipoCuentaDet;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public String getId() {
		return codTipoCuenta;
	}

}
