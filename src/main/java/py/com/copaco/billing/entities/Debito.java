package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;


/**
 * The persistent class for the debito database table.
 * 
 */
@Entity
public class Debito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "debito_seq", sequenceName = "debito_seq", allocationSize = 1)
	@GeneratedValue(generator = "debito_seq")
	@Column(name="cod_debito")
	private Integer codDebito;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private BigDecimal monto;

	//bi-directional many-to-one association to Contrato
	@ManyToOne
	@JoinColumn(name="cod_contrato")
	private Contrato contrato;

	//bi-directional many-to-one association to ContratoServicio
	@ManyToOne
	@JoinColumn(name="cod_contrato_servicio")
	private ContratoServicio contratoServicio;

	//bi-directional many-to-one association to Cuenta
	@ManyToOne
	@JoinColumn(name="cod_cuenta")
	private Cuenta cuenta;

	//bi-directional many-to-one association to DefinicionDebito
	@OneToMany(mappedBy="debito")
	private List<DefinicionDebito> definicionDebitos;

	public Debito() {
	}

	public Integer getCodDebito() {
		return this.codDebito;
	}

	public void setCodDebito(Integer codDebito) {
		this.codDebito = codDebito;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Contrato getContrato() {
		return this.contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public ContratoServicio getContratoServicio() {
		return this.contratoServicio;
	}

	public void setContratoServicio(ContratoServicio contratoServicio) {
		this.contratoServicio = contratoServicio;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@JsonIgnore
	public List<DefinicionDebito> getDefinicionDebitos() {
		return this.definicionDebitos;
	}

	public void setDefinicionDebitos(List<DefinicionDebito> definicionDebitos) {
		this.definicionDebitos = definicionDebitos;
	}

	public DefinicionDebito addDefinicionDebito(DefinicionDebito definicionDebito) {
		getDefinicionDebitos().add(definicionDebito);
		definicionDebito.setDebito(this);

		return definicionDebito;
	}

	public DefinicionDebito removeDefinicionDebito(DefinicionDebito definicionDebito) {
		getDefinicionDebitos().remove(definicionDebito);
		definicionDebito.setDebito(null);

		return definicionDebito;
	}

}