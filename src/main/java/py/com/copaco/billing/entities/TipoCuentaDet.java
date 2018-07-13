package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Representacion de la entidad de BD correspondiente a Tipo Cuenta Detalle
 * 
 * @author Luis Fernandez
 * @since 1.0
 * @version 1.0 Apr 16, 2015
 *
 */

@Data
@Entity
@Table(name = "tipo_cuenta_det")
@EqualsAndHashCode(of = "codTipoCuentaDet")
@ToString(of = "codTipoCuentaDet")
public class TipoCuentaDet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "tipo_cuenta_det_seq", sequenceName = "tipo_cuenta_det_seq", allocationSize = 1)
	@GeneratedValue(generator = "tipo_cuenta_det_seq")
	@Column(name = "cod_tipo_cuenta_det")
	private Integer codTipoCuentaDet;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_inicio_vig")
	private Date fechaInicioVigencia;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_fin_vig")
	private Date fechaFinVigencia;

	@Getter
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_cuenta_contable")
	private CuentaContable cuentaContable;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Getter(onMethod = @_(@JsonIgnoreBackend))
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_tipo_cuenta")
	private TipoCuenta tipoCuenta;
}
