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
 * The persistent class for the regla_etiqueta database table.
 * 
 */
@Entity
@Table(name="regla_etiqueta")
public class ReglaEtiqueta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "regla_etiqueta_seq", sequenceName = "regla_etiqueta_seq", allocationSize = 1)
	@GeneratedValue(generator = "regla_etiqueta_seq")
	@Column(name="cod_regla_etiqueta")
	private Integer codReglaEtiqueta;

	//bi-directional many-to-one association to Etiqueta
	@ManyToOne
	@JoinColumn(name="cod_etiqueta")
	private Etiqueta etiqueta;

	//bi-directional many-to-one association to Regla
	@ManyToOne
	@JoinColumn(name="cod_regla")
	private Regla regla;

	public ReglaEtiqueta() {
	}

	public Integer getCodReglaEtiqueta() {
		return this.codReglaEtiqueta;
	}

	public void setCodReglaEtiqueta(Integer codReglaEtiqueta) {
		this.codReglaEtiqueta = codReglaEtiqueta;
	}

	public Etiqueta getEtiqueta() {
		return this.etiqueta;
	}

	public void setEtiqueta(Etiqueta etiqueta) {
		this.etiqueta = etiqueta;
	}

	public Regla getRegla() {
		return this.regla;
	}

	public void setRegla(Regla regla) {
		this.regla = regla;
	}

}