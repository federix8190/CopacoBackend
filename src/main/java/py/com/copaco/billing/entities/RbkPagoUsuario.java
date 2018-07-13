package py.com.copaco.billing.entities;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "rbk_pago_usuario")
@Data
@EqualsAndHashCode(of = "codRbkPagoUsuario", callSuper = false)
@ToString(of = "codRbkPagoUsuario")
public class RbkPagoUsuario extends BaseEntity<BigInteger> {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "rbk_pago_usuario_seq", sequenceName = "rbk_pago_usuario_seq", allocationSize = 1)
	@GeneratedValue(generator = "rbk_pago_usuario_seq")
	@Column(name = "cod_rbk_pago_usuario")
	private BigInteger codRbkPagoUsuario;

	@Column(name = "cod_pago")
	private BigInteger codPago;

	@Column(name = "cod_lote_pagos")
	private BigInteger codLotePagos;

	@Column(name = "operacion")
	private String operacion;

	@Column(name = "cod_usuario")
	private String codUsuario;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha")
	private Date fecha;

	@Override
	public BigInteger getId() {
		return this.codPago;
	}
}
