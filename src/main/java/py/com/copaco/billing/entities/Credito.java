package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.codehaus.jackson.annotate.JsonIgnore;


/**
 * The persistent class for the credito database table.
 * 
 */
@Entity
public class Credito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "credito_seq", sequenceName = "credito_seq", allocationSize = 1)
	@GeneratedValue(generator = "credito_seq")
	@Column(name="cod_credito")
	private Integer codCredito;

	//bi-directional many-to-one association to DefinicionCredito
	@OneToMany(mappedBy="credito")
	private List<DefinicionCredito> definicionCreditos;

	public Credito() {
	}

	public Integer getCodCredito() {
		return this.codCredito;
	}

	public void setCodCredito(Integer codCredito) {
		this.codCredito = codCredito;
	}

	@JsonIgnore
	public List<DefinicionCredito> getDefinicionCreditos() {
		return this.definicionCreditos;
	}

	public void setDefinicionCreditos(List<DefinicionCredito> definicionCreditos) {
		this.definicionCreditos = definicionCreditos;
	}

	public DefinicionCredito addDefinicionCredito(DefinicionCredito definicionCredito) {
		getDefinicionCreditos().add(definicionCredito);
		definicionCredito.setCredito(this);

		return definicionCredito;
	}

	public DefinicionCredito removeDefinicionCredito(DefinicionCredito definicionCredito) {
		getDefinicionCreditos().remove(definicionCredito);
		definicionCredito.setCredito(null);

		return definicionCredito;
	}

}