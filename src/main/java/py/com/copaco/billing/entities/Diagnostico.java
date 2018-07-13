package py.com.copaco.billing.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author Claudia Valenzuela
 * @since 1.0
 * @version 18/9/2015
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codDiagnostico", callSuper = false)
@SuppressWarnings("serial")
@Table(name = "diagnostico")
public class Diagnostico extends BaseEntity<Integer> {

	@Id
	@Column(name = "cod_diagnostico")
	@SequenceGenerator(name = "diagnostico_seq", sequenceName = "diagnostico_seq", allocationSize = 1)
	@GeneratedValue(generator = "diagnostico_seq")
	private Integer codDiagnostico;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_diagnostico")
	@NotNull
	private Date fechaDiagnostico;

	@NotNull
	@Size(max = 2)
	private String estado;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "cod_lv_tipo_diagnostico")
	private ListaValoresDet tipoDiagnostico;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "cod_lv_diagnostico")
	private ListaValoresDet diagnostico;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "cod_lv_tipo_prueba")
	private ListaValoresDet tipoPrueba;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_solucion", referencedColumnName = "cod_solucion")
	private Solucion solucion;

	@Getter
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne
	@JoinColumn(name = "cod_reclamo")
	private Reclamo reclamo;

	@NotNull
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return codDiagnostico;
	}
}
