package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lila Perez
 * @since 2.0
 * @version 1.0 Oct 27, 2014 The persistent class for the factura database
 *          table.
 */

@Entity
@Table(name = "factura")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codFactura", callSuper = false)
public class Factura extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "factura_seq", sequenceName = "factura_seq", allocationSize = 1)
	@GeneratedValue(generator = "factura_seq")
	@Column(name = "cod_factura")
	private Integer codFactura;

	@Column(name = "num_factura")
	private String numFactura;

	@Column(name = "tipo_factura")
	private String tipoFactura;

	@Column(name = "nombre_facturar")
	private String nombreFacturar;

	@Column(name = "ci_ruc")
	private String ciRuc;

	@Column(name = "cuenta_catastral")
	private String cuentaCatastral;

	@Column(name = "direccion_correspondencia")
	private String direccionCorrespondencia;

	@Column(name = "ciudad_correspondencia")
	private String ciudadCorrespondencia;

	@Column(name = "numero_casa")
	private Integer numeroCasa;

	// bi-directional many-to-one association to Despacho Detalle
	@ManyToOne
	@JoinColumn(name = "cod_despacho_det")
	private DespachoDetalle despachoDet;

	@Column(name = "secuencia")
	private Integer secuencia;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "consumo_desde")
	private Date consumoDesde;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "consumo_hasta")
	private Date consumoHasta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_emision")
	private Date fechaEmision;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "vencimiento")
	private Date vencimiento;

	@Column(name = "monto")
	private Double monto;

	@Column(name = "impuesto")
	private Double impuesto;

	// bi-directional many-to-one association to Cuenta
	@ManyToOne
	@JoinColumn(name = "cod_cuenta")
	private Cuenta cuenta;

	// bi-directional many-to-one association to FacturaCabecera
	@ManyToOne
	@JoinColumn(name = "cod_factura_cab")
	private FacturaCabecera facturaCabecera;

	@ManyToOne
	@JoinColumn(name = "diseno_factura_det")
	private DisenoFacturaDet disenoFactura;

	@Column(name = "cod_factura_estado")
	private String estado;
	
	@Column(name = "monto_interes_moratorio")
	private Double montoInteresMoratorio; 
	
	@Column(name = "monto_total")
	private Double montoTotal; 

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	/**
	 * Actualizacion [25-06-2015] Se agrega una referencia a la factura
	 * contenedora
	 */
	@ManyToOne
	@JoinColumn(name = "cod_factura_contenedor")
	private Factura facturaContenedora;

	/**
	 * Actualizacion [10-06-2015] Se le agregan los attrs. numLinea y codAcceso
	 * como una ayuda para mostrarlos en la vista de reclamos
	 */
	@Transient
	@Getter
	@Setter
	String numLinea;
	
	@Transient
	@Getter
	@Setter
	String codAcceso;

	@Column(name = "codigo_barras")
	private String codigoBarras;
	
	@Column(name = "monto_fact_ven_imp")
	private Double montoFactVenImp;
	
	@Column(name = "monto_fact_ven_imp_orig")
	private Double montoFactVenImpOrig;
	
	@Column(name = "monto_total_orig")
	private Double montoTotalOrig;
	
	@Column(name = "cant_fact_ven_imp")
	private Integer cantFactVenImp;
	
	@Column(name = "cant_fact_ven_imp_orig")
	private Integer cantFactVenImpOrig;
	
	@ManyToOne
	@JoinColumn(name = "cod_solicitud")
	private Solicitud solicitud;
	
	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "factura", cascade = { CascadeType.ALL })
	private List<FacturaDetalle> listaFacturaDet;
	
	@ManyToOne
	@JoinColumn(name = "cod_lv_estado")
	private ListaValoresDet listaValoresDetEstado;
	
	@Column(name = "comision")
	private Double comision;

	@ManyToOne
	@JoinColumn(name = "cod_tipo_cuenta")
	private TipoCuenta tipoCuenta;
	
	@Override
	public Integer getId() {
		return codFactura;
	}
}