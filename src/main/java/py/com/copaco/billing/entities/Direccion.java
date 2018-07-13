package py.com.copaco.billing.entities;

import java.io.Serializable;
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

import lombok.ToString;

import org.codehaus.jackson.annotate.JsonIgnore;


/**
 * The persistent class for the direccion database table.
 * 
 */
@Entity
@ToString
public class Direccion  extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "direccion_seq", sequenceName = "direccion_seq", allocationSize = 1)
	@GeneratedValue(generator = "direccion_seq")
	@Column(name="cod_direccion")
	private Integer codDireccion;

	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Column(name="calle_principal")
	private String callePrincipal;

	private String calle1;

	private String calle2;
	
	@Column(name="cuenta_catastral")
	private String cuentaCatastral;
	
	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Column(name="numero_casa")
	private Integer numeroCasa;
	
	private String referencia;
	
	private String latitud;
	
	private String longitud;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="direccion")
	private List<Cliente> clientes;

	//bi-directional many-to-one association to ContratoServicio
	@OneToMany(mappedBy="direccion")
	private List<ContratoServicio> contratoServicios;

	//bi-directional many-to-one association to Cuenta
	@OneToMany(mappedBy="direccion")
	private List<Cuenta> cuentas;
	
	//bi-directional many-to-one association to Cuenta
	@OneToMany(mappedBy="direccion")
	private List<OrdenServicio> ordenesServicio;

	//bi-directional many-to-one association to ListaValoresDet
    @ManyToOne
    @JoinColumn(name="cod_lv_tipo")
    private ListaValoresDet listaValoresDet;
	
	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cod_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name="cod_ciudad")
	private Ciudad ciudad;
	
	//bi-directional many-to-one association to Barrio
	@ManyToOne
	@JoinColumn(name="cod_barrio")
	private Barrio barrio;

	public Direccion() {
	}

	public Integer getCodDireccion() {
		return this.codDireccion;
	}

	public void setCodDireccion(Integer codDireccion) {
		this.codDireccion = codDireccion;
	}

	public String getCodUsuarioModificacion() {
		return this.codUsuarioModificacion;
	}

	public void setCodUsuarioModificacion(String codUsuarioModificacion) {
		this.codUsuarioModificacion = codUsuarioModificacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Integer getNumeroCasa() {
		return this.numeroCasa;
	}

	public void setNumeroCasa(Integer numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	@JsonIgnore
	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setDireccion(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setDireccion(null);

		return cliente;
	}

	@JsonIgnore
	public List<ContratoServicio> getContratoServicios() {
		return this.contratoServicios;
	}

	public void setContratoServicios(List<ContratoServicio> contratoServicios) {
		this.contratoServicios = contratoServicios;
	}
	
	@JsonIgnore
	public List<OrdenServicio> getOrdenesServicio() {
		return this.ordenesServicio;
	}

	public void setOrdenesServicio(List<OrdenServicio> ordenesServicio) {
		this.ordenesServicio = ordenesServicio;
	}

	public ContratoServicio addContratoServicio(ContratoServicio contratoServicio) {
		getContratoServicios().add(contratoServicio);
		contratoServicio.setDireccion(this);

		return contratoServicio;
	}

	public ContratoServicio removeContratoServicio(ContratoServicio contratoServicio) {
		getContratoServicios().remove(contratoServicio);
		contratoServicio.setDireccion(null);

		return contratoServicio;
	}

	@JsonIgnore
	public List<Cuenta> getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Cuenta addCuenta(Cuenta cuenta) {
		getCuentas().add(cuenta);
		cuenta.setDireccion(this);

		return cuenta;
	}

	public Cuenta removeCuenta(Cuenta cuenta) {
		getCuentas().remove(cuenta);
		cuenta.setDireccion(null);

		return cuenta;
	}

	@JsonIgnore
	public Cliente getCliente() {
		return this.cliente;
	}

	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getCallePrincipal() {
		return callePrincipal;
	}

	public void setCallePrincipal(String callePrincipal) {
		this.callePrincipal = callePrincipal;
	}

	public String getCalle1() {
		return calle1;
	}

	public void setCalle1(String calle1) {
		this.calle1 = calle1;
	}

	public String getCalle2() {
		return calle2;
	}

	public void setCalle2(String calle2) {
		this.calle2 = calle2;
	}

	public String getCuentaCatastral() {
		return cuentaCatastral;
	}

	public void setCuentaCatastral(String cuentaCatastral) {
		this.cuentaCatastral = cuentaCatastral;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Barrio getBarrio() {
		return barrio;
	}

	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}
	
	public ListaValoresDet getListaValoresDet() {
		return listaValoresDet;
	}

	public void setListaValoresDet(ListaValoresDet listaValoresDet) {
		this.listaValoresDet = listaValoresDet;
	}

	@Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.codDireccion == null && other.codDireccion != null) || (this.codDireccion != null && ! this.codDireccion.equals(other.codDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        
        int hash = 0;
        hash += (codDireccion != null ? codDireccion.hashCode() : 0);
        return hash;
    }

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return this.codDireccion;
	}

}