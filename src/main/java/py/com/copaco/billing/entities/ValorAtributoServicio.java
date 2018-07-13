package py.com.copaco.billing.entities;

import java.io.Serializable;
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


/**
 * The persistent class for the valor_atributo_servicio database table.
 * 
 */
@Entity
@Table(name="valor_atributo_servicio")
public class ValorAtributoServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "valor_atributo_servicio_seq", sequenceName = "valor_atributo_servicio_seq", allocationSize = 1)
	@GeneratedValue(generator = "valor_atributo_servicio_seq")
	@Column(name="cod_valor_atributo_servicio")
	private Integer codValorAtributoServicio;

	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	private String valor;

	//bi-directional many-to-one association to AtributosServicio
	@ManyToOne
	@JoinColumn(name="cod_atributos_servicio")
	private AtributosServicio atributosServicio;

	//bi-directional many-to-one association to ContratoServicio
	@ManyToOne
	@JoinColumn(name="cod_contrato_servicio")
	private ContratoServicio contratoServicio;

	public ValorAtributoServicio() {
	}

	public Integer getCodValorAtributoServicio() {
		return this.codValorAtributoServicio;
	}

	public void setCodValorAtributoServicio(Integer codValorAtributoServicio) {
		this.codValorAtributoServicio = codValorAtributoServicio;
	}

	public String getCodUsuarioModificacion() {
		return this.codUsuarioModificacion;
	}

	public void setCodUsuarioModificacion(String codUsuarioModificacion) {
		this.codUsuarioModificacion = codUsuarioModificacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public AtributosServicio getAtributosServicio() {
		return this.atributosServicio;
	}

	public void setAtributosServicio(AtributosServicio atributosServicio) {
		this.atributosServicio = atributosServicio;
	}

	public ContratoServicio getContratoServicio() {
		return this.contratoServicio;
	}

	public void setContratoServicio(ContratoServicio contratoServicio) {
		this.contratoServicio = contratoServicio;
	}

}