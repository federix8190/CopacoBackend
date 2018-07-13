package py.com.copaco.billing.entities;

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
import lombok.ToString;

/**
 * 
 * The persistent class for the cuenta_contable_det database table.
 * 
 * @author Adriana Coronel
 * @since 1.0
 * 
 * 
 */

@Entity
@Table(name="cuenta_bancaria_det")
@Data
@EqualsAndHashCode(of="codCuentaBancariaDet", callSuper=false)
@ToString(of="codCuentaBancariaDet")
public class CuentaBancariaDetalle extends BaseEntity<Integer>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="cuenta_bancaria_det_seq", sequenceName="cuenta_bancaria_det_seq", allocationSize=1)
	@GeneratedValue(generator="cuenta_bancaria_det_seq")
	@Column(name="cod_cuenta_bancaria_det")
	private Integer codCuentaBancariaDet;
	
	@ManyToOne
	@JoinColumn(name="cod_cuenta_bancaria")
	private CuentaBancaria cuentaBancaria;
	
	@ManyToOne
	@JoinColumn(name="cod_cuenta_contable")
	private CuentaContable cuentaContable;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_inicio_vigencia")
	private Date fechaInicioVigencia;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_fin_vigencia")
	private Date fechaFinVigencia;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	

	@Override
	public Integer getId() {
		return this.codCuentaBancariaDet;
	}

}
