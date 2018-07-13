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
 * The persistent class for the definicion_debito database table.
 * 
 */
@Entity
@Table(name="definicion_debito")
public class DefinicionDebito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "definicion_debito_seq", sequenceName = "definicion_debito_seq", allocationSize = 1)
	@GeneratedValue(generator = "definicion_debito_seq")
	@Column(name="cod_definicion_debito")
	private Integer codDefinicionDebito;

	private String descripcion;

	private String nombre;

	private String tasable;

	//bi-directional many-to-one association to Debito
	@ManyToOne
	@JoinColumn(name="cod_debito")
	private Debito debito;

	public DefinicionDebito() {
	}

	public Integer getCodDefinicionDebito() {
		return this.codDefinicionDebito;
	}

	public void setCodDefinicionDebito(Integer codDefinicionDebito) {
		this.codDefinicionDebito = codDefinicionDebito;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTasable() {
		return this.tasable;
	}

	public void setTasable(String tasable) {
		this.tasable = tasable;
	}

	public Debito getDebito() {
		return this.debito;
	}

	public void setDebito(Debito debito) {
		this.debito = debito;
	}

}