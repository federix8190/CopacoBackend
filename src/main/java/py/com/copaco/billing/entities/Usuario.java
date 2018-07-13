package py.com.copaco.billing.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_usuario")
	private String codUsuario;

	private String apellidos;

	private String nombres;

	//bi-directional many-to-one association to ListaValoresDet
	@ManyToOne
	@JoinColumn(name="cod_lv_tipo")
	private ListaValoresDet listaValoresDet;

	public Usuario() {
	}

	public String getCodUsuario() {
		return this.codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public ListaValoresDet getListaValoresDet() {
		return this.listaValoresDet;
	}

	public void setListaValoresDet(ListaValoresDet listaValoresDet) {
		this.listaValoresDet = listaValoresDet;
	}

}