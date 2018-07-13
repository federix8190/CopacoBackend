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
 * The persistent class for the caja database table.
 * 
 * @author Adriana Coronel
 * @since 1.0
 * 
 * 
 */

@Entity
@Table(name="deposito_det")
@Data
@EqualsAndHashCode(of="codDepositoDet", callSuper=false)
@ToString(of="codDepositoDet")
public class DepositoDetalle extends BaseEntity<Integer>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="deposito_det_seq", sequenceName="deposito_det_seq", allocationSize=1)
	@GeneratedValue(generator="deposito_det_seq")
	@Column(name="cod_deposito_det")
	private Integer codDepositoDet;
	
	@ManyToOne
	@JoinColumn(name="cod_deposito")
	private Deposito deposito;
	
	@ManyToOne
	@JoinColumn(name="cod_concepto_cobranza")
	private ConceptoCobranza conceptoCob;

	
	@ManyToOne
	@JoinColumn(name="cod_lote_pagos")
	private LotePagos lotePagos;

	@Column(name="importe")
	private Double importe;
	
	@ManyToOne
	@JoinColumn(name="cod_deposito_ref")
	private Deposito depositoRef;
	
	@Column(name="motivo")
	private String motivo;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;


	@Override
	public Integer getId() {
		return this.codDepositoDet;
	}

}
