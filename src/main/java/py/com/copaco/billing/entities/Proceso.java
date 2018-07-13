package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 *
 * @author Mauro Vera
 * @author Arturo Volpe
 * @since 2.1
 * @version 2.3 Oct 23, 2014
 *
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codProceso", callSuper = true)
public class Proceso extends BaseEntity<Integer> implements Serializable {

	/**
	 * Define los tipos de parámetros aceptados.
	 *
	 * Se podrían agregar más tipos siempre y cuando el archivo lanzador.xhtml
	 * lo soporte.
	 * 
	 * <p>
	 * <b>Notar que siempre van como {@link String}</b> Al proceso
	 * </p>
	 * 
	 */
	public enum TipoParametro {
		STRING, INTEGER, DOUBLE, DATE
	}

	@Value(staticConstructor = "of")
	public static class Param {
		TipoParametro tipo;
		String descripcion;
		String nombre;
	}

	public enum TipoProceso {
		//HU-TAS-09-N2-V1-ProcesoTasador
		PROCESAR_EVENTOS("Procesar eventos (Tasación)",
				Param.of(TipoParametro.DATE,
						"Fecha de Inicio",
						"fechaInicio"),
				Param.of(TipoParametro.DATE,
						"Fecha de Fin",
						"fechaFin"),
				Param.of(TipoParametro.DATE,
						"Fecha de Vigencia (para variables y reglas)",
						"fechaVigenciaReglas")),
		
		SUMARIZADOR("Sumarizar"),
		
		REPROCESAR_EVENTOS("Reprocesar eventos"),
		
		REPROCESAR_LOTE("Reprocesar lote de eventos"),
		
		REINTENTAR_RECHAZADOS("Reintentar eventos rechazados"),
		
		ELIMINAR_LOTE("Eliminar lote de eventos"),
		
		FACTURACION_ADELANTADA("Facturacion Adelantada"),
		
		CICLICOS("Generación de cíclicos",  
				Param.of(TipoParametro.INTEGER, "Anho", "anho"),
				Param.of(TipoParametro.INTEGER, "Mes", "mes")),

		TASAR_EVENTOS("Tasar eventos"),
		
		DESCUENTO("Descuentos", 
				Param.of(TipoParametro.INTEGER, "Anho", "anho"),
				Param.of(TipoParametro.INTEGER, "Mes", "mes")),
		
		FACTURACION("Facturación"),
				
		ROLLBACK_CICLICOS("Deshacer cíclicos"),
		
		ELIMINAR_EVENTOS_ACEPTADOS("Eliminar eventos aceptados"),
		
		ROLLBACK_DESCUENTO("Deshacer descuento"),
		
		ROLLBACK_FACTURA("Deshacer facturación"),
		
		ALMACENADO("Proceso almacenado"),

		BORRADO_EV("Borrado de eventos temporales"),

		APROVISION("Aprovisionamiento"),
		
		DESCUENTO_PUNTUAL("Descuento Puntual"),
		
		GENERACION_FACTURA_PDF("Generación de Facturas PDF"),
		
		ENVIO_FACTURA_PDF("Envío de Facturas PDF"),
		
		GENERAR_FIRMA_DIGITAL("Generar Firma Digital"),
		
		TRATAMIENTO_FALTA_PAGO("Proceso Tratamiento por falta de pagos",
				Param.of(TipoParametro.INTEGER, "Anho", "anho"),
				Param.of(TipoParametro.INTEGER, "Mes", "mes"),
				Param.of(TipoParametro.STRING, "Ciclo", "ciclo")),
			
		ROLLBACK_TRAT_FALTA_PAGO("Rollback Tratamiento por falta de pagos",
				Param.of(TipoParametro.INTEGER, "Lote Tratamiento", "loteTratamiento")), 
		
		ARCHIVOS_CSV_COB("Generación de Archivos CSV para Cobranzas"),
		
		PAGOS_OFFLINE("Registro de Pagos Offline"),
		
		PAGOS_OFFLINE_ANT("Registro de Pagos Anteriores Offline"),
		
		RBK_PAGOS_OFF("Rollback de Pagos Offline"),
		
		RBK_MIO("Rollback de Pagos Offline"),
				
		DEBITO_MANUAL("Débito Manual"),
		
		LLAMADA_MANUAL("Llamada Manual"),
		
		RECARGA_ERICSSON("Recarga de saldo via Ericsson"),
		
		RECARGA_LTE("Recarga mensual de LTE"
//				,Param.of(TipoParametro.INTEGER, "Lote Fact. Desde", "loteDesde"),
//				Param.of(TipoParametro.INTEGER, "Lote Fact. Hasta", "loteHasta")
				),
				
		RECARGA_BONOS_LTE("Recarga de bonos LTE"),
		
		RESUMEN_FACTURACION("Carga de datos para Resumen de Facturación"),

		ESTADO_CUENTA_MENSUAL("Actualización de estado de Cuentas mensual"),
		
		ENVIO_COMANDO_CORTE ("Envio de comandos de corte");
		
		@Getter
		private String descripcion;

		@Getter
		private List<Param> parametros;

		TipoProceso(String descripcion, Param... parametros) {

			this.descripcion = descripcion;
			if (parametros != null)
				this.parametros = Arrays.asList(parametros);
			else
				this.parametros = Collections.emptyList();
		}

	}

	public enum TipoProgramacion {

		INTERVALO("Intervalo de tiempo"),
		
		DIARIA("Diaria"),
		
		SEMANAL("Semanal"),

		MENSUAL("Mensual"),

		UNICA("Única"),

		ANUAL("Anual"),

		DEPENDIENTE("Dependiente de otro proceso"),
		
		NOAUTOMATICA("No admite ejecución automática"),
		
		MANUAL("Manual");

		@Getter
		private String descripcion;

		TipoProgramacion(String descripcion) {
			this.descripcion = descripcion;
		}

	}

	public static final class DiasSemana {

		public static final String DOMINGO = "Domingo";
		public static final String LUNES = "Lunes";
		public static final String MARTES = "Martes";
		public static final String MIERCOLES = "Miércoles";
		public static final String JUEVES = "Jueves";
		public static final String VIERNES = "Viernes";
		public static final String SABADO = "Sábado";

		public String[] values() {
			return new String[] { DOMINGO, LUNES, MARTES, MIERCOLES, JUEVES,
					VIERNES, SABADO };
		}
	}

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "proceso_seq", sequenceName = "proceso_seq", allocationSize = 1)
	@GeneratedValue(generator = "proceso_seq")
	@Column(name = "cod_proceso")
	private Integer codProceso;

	private Integer antiguedad;

	/*
	 * Se agrega una relacion de uno muchos consigo mismo
	 */
	@ManyToOne
	@JoinColumn(name = "cod_proceso_dependiente_pk")
	private Proceso dependienteDe;

	@Getter(onMethod = @_(@JsonIgnoreBackend))
	@Setter(onMethod = @_(@JsonProperty))

	@OneToMany(fetch = FetchType.EAGER,mappedBy = "dependienteDe")

	private List<Proceso> procesos;

	private String descripcion;

	@Column(name = "dia_mes")
	private Integer diaMes;

	@Column(name = "dia_semana")
	private String diaSemana;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	private Integer hora;

	private Integer minuto;

	private Integer mes;

	private Integer intervalo;

	private String nombre;

	@Column(name = "procedimiento_almacenado")
	private String procedimientoAlmacenado;

	@ManyToOne
	@JoinColumn(name = "cod_evento")
	private Evento evento;

	@ManyToOne
	@JoinColumn(name = "cod_ciclo_facturacion")
	private CicloFacturacion cicloFacturacion;

	@Column(name = "tipo_proceso")
	@Enumerated(EnumType.STRING)
	private TipoProceso tipoProceso;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_programacion")
	private TipoProgramacion tipoProgramacion;

	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(fetch=FetchType.LAZY,mappedBy = "proceso")
	private List<InstanciaProceso> instancias;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return codProceso;
	}

}
