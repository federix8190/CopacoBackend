package py.com.copaco.billing.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the definicion_credito database table.
 * 
 */
@Entity
@Table(name="definicion_credito")
public class DefinicionCredito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "definicion_credito_seq", sequenceName = "definicion_credito_seq", allocationSize = 1)
	@GeneratedValue(generator = "definicion_credito_seq")
	@Column(name="cod_definicion_credito")
	private Integer codDefinicionCredito;

	//bi-directional many-to-one association to Credito
	@ManyToOne
	@JoinColumn(name="cod_credito")
	private Credito credito;

	public DefinicionCredito() {
	}

	public Integer getCodDefinicionCredito() {
		return this.codDefinicionCredito;
	}

	public void setCodDefinicionCredito(Integer codDefinicionCredito) {
		this.codDefinicionCredito = codDefinicionCredito;
	}

	public Credito getCredito() {
		return this.credito;
	}

	public void setCredito(Credito credito) {
		this.credito = credito;
	}

}