package py.com.copaco.billing.entities;

import java.math.BigInteger;
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
 * @author Luis Fernandez
 * @since 1.0
 * @version 1.0
 *
 */

@Entity
@Table(name = "funcionario_caja_cobranza")
@Data
@EqualsAndHashCode(of = "codFuncionarioCajaCobranza", callSuper = false)
@ToString(of = "codFuncionarioCajaCobranza")
public class FuncionarioCajaCobranza extends BaseEntity<BigInteger> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "funcionario_caja_cobranza_seq", sequenceName = "funcionario_caja_cobranza_seq", allocationSize = 1)
	@GeneratedValue(generator = "funcionario_caja_cobranza_seq")
	@Column(name = "cod_funcionario_caja_cobranza")
	private BigInteger codFuncionarioCajaCobranza;

	@ManyToOne
	@JoinColumn(name = "cod_funcionario")
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "cod_caja_cobranza")
	private CajaCobranza cajaCobranza;

	@ManyToOne
	@JoinColumn(name = "cod_lote_pagos")
	private LotePagos lotePagos;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_cierre")
	private Date fechaCierre;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_apertura")
	private Date fechaApertura;

	@Override
	public BigInteger getId() {
		return codFuncionarioCajaCobranza;
	}

}
