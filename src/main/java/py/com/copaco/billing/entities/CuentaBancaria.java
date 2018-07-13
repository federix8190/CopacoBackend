package py.com.copaco.billing.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * 
 * 
 * @author Adriana Coronel
 * @since 1.0
 * 
 * 
 */

@Entity
@Table(name="cuenta_bancaria")
@Data
@EqualsAndHashCode(of="codCuentaBancaria", callSuper=false)
@ToString(of="codCuentaBancaria")
public class CuentaBancaria extends BaseEntity<Integer>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="cuenta_bancaria_seq", sequenceName="cuenta_bancaria_seq", allocationSize=1)
	@GeneratedValue(generator="cuenta_bancaria_seq")
	@Column(name="cod_cuenta_bancaria")
	private Integer codCuentaBancaria;
	
	@ManyToOne
	@JoinColumn(name="cod_entidad_financiera")
	private EntidadFinanciera entidadFinanciera;
	
	@Column(name="numero_cuenta")
	private String numeroCuenta;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	

	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "cuentaBancaria", cascade = { CascadeType.ALL })
	private List<CuentaBancariaDetalle> listaCuentaBancariaDet;

	@Override
	public Integer getId() {
		return this.codCuentaBancaria;
	}

}
