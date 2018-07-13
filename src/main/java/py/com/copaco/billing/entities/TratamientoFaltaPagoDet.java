package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * Representacion de la entidad de BD correspondiente a Tratamiento falta pago
 * Detalle
 * 
 * @author Mauro Vera
 * @since 1.0
 * @version 1.0 May 11, 2015
 * 
 */

@Data
@Entity
@Table(name = "tratamiento_falta_pago_det")
@EqualsAndHashCode(of = "codTratamientoFaltaPagoDet")
@ToString(of = "codTratamientoFaltaPagoDet")
public class TratamientoFaltaPagoDet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2335217973208422032L;

	@Id
	@NotNull
	@SequenceGenerator(name = "tratamiento_falta_pago_det_seq", sequenceName = "tratamiento_falta_pago_det_seq", allocationSize = 1)
	@GeneratedValue(generator = "tratamiento_falta_pago_det_seq")
	@Column(name = "cod_tratamiento_falta_pago_det")
	private Integer codTratamientoFaltaPagoDet;

	@NotNull
	@Getter(onMethod = @_(@JsonIgnoreBackend))
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_tratamiento_falta_pago")
	private TratamientoFaltaPago tratamientoFaltaPago;

	@NotNull
	@Column(name = "cantidad_cuotas_impagas")
	private Integer cantidadCuotasImpagas;

	@NotNull
	@Column(name = "proceso")
	private String proceso;

	@NotNull
	@Column(name = "cancelacion_deudas")
	private String cancelacionDeudas;

/*	@NotNull
	@Column(name = "finalizacion_contrato")
	private String finalizacionContrato;
*/

	@Nullable
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_despacho_detalle")
	private DespachoDetalle despachoDetalle;

	@Nullable
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "debito_generado")
	private ListaValoresDet debitoGenerado;

	@Nullable
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_tipo_cuenta")
	private TipoCuenta tipoCuenta;

	@Nullable
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estado_deuda")
	private ListaValoresDet estadoDeuda;

	
	@Nullable
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_prov_nivel")
	private ProvNivel nivel;

	@NotNull
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;


	@Nullable
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_diseno_factura")
	private DisenoFactura disenoFactura;

	
	@Column(name="estado_contrato")
	private String estadoContrato;

	@Column(name="cantidad_dias_emision_venc")
	private Integer cantidadDiasEmisionVencimiento;
	
	@Column(name="cantidad_dias_evento")
	private Integer cantidadDiasEvento;
	
}
