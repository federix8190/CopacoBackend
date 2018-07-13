package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Mauro Vera
 * @author Arturo Volpe
 * @since 2.0
 * @version 2.1 Sep 23, 2014
 * 
 */
@Entity
@Table(name = "instancia_proceso")
@Data
@NoArgsConstructor
@Cacheable
@EqualsAndHashCode(of = "codInstanciaProceso", callSuper = false)
public class InstanciaProceso extends BaseEntity<Integer> implements
		Serializable, Comparable<InstanciaProceso> {

	/**
	 * Define el estado del proceso actual.
	 * 
	 * @author Arturo Volpe
	 * @since 1.0
	 * @version 1.0 Oct 15, 2014
	 * 
	 */
	public enum State {

		CONFIGURANDO("Configurando"), EJECUTANDO("Ejecutando"), DETENIDO_USUARIO(
				"Detenido por Usuario"), DETENIDO_ERROR("Error"), DETENIDO_NORMAL(
				"Satisfactorio");

		String descripcion;

		State(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getDescripcion() {
			return descripcion;
		}
	}

	/**
	 * Define el tipo de ejecución de un proceso
	 * 
	 * @author Arturo Volpe
	 * @since 1.0
	 * @version 1.0 Oct 15, 2014
	 * 
	 */
	public enum ExecutionType {

		MANUAL, AUTOMATICO
	}

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "instancia_proceso_seq", sequenceName = "instancia_proceso_seq", allocationSize = 1)
	@GeneratedValue(generator = "instancia_proceso_seq")
	@Column(name = "cod_instancia_proceso")
	private Integer codInstanciaProceso;

	@Column(name = "cod_usuario")
	private String codUsuario;

	@Column(name = "dato_adicional")
	private String datoAdicional;

	@Column(name = "ejecucion_descripcion")
	private String ejecucionDescripcion;

	@Enumerated(EnumType.STRING)
	private State estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_hora_fin")
	private Date fechaHoraFin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_hora_inicio")
	private Date fechaHoraInicio;

	private String mensaje;

	@Column(name = "metodo_ejecucion")
	@Enumerated(EnumType.STRING)
	private ExecutionType metodoEjecucion;

	@ManyToOne
	@JoinColumn(name = "cod_proceso")
	private Proceso proceso;

	@Override
	public Integer getId() {
		return codInstanciaProceso;
	}

	@JsonIgnore
	public boolean isRunning() {
		return estado == State.CONFIGURANDO || estado == State.EJECUTANDO;
	}

	@Override
	public int compareTo(InstanciaProceso o) {
		return this.getCodInstanciaProceso().compareTo(o.getCodInstanciaProceso());
	}
}