package py.com.copaco.billing.entities;

import java.util.Date;

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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Claudia Valenzuela
 * @since 1.0
 * @version 14/10/2015
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codReclamoPex", callSuper = false)
@SuppressWarnings("serial")
@Table(name = "reclamo_pex")
public class ReclamoPex extends BaseEntity<Integer> {

	@Id
	@Column(name = "cod_reclamo_pex")
	@SequenceGenerator(name = "reclamo_pex_seq", sequenceName = "reclamo_pex_seq", allocationSize = 1)
	@GeneratedValue(generator = "reclamo_pex_seq")
	private Integer codReclamoPex;

	@ManyToOne
	@JoinColumn(name = "cod_central")
	private Central central;

	private Integer prioridad;

	private String descripcion;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "cod_lv_error_reportado")
	private ListaValoresDet errorReportado;

	@ManyToOne
	@JoinColumn(name = "cod_cable")
	private Cable cable;

	@ManyToOne
	@JoinColumn(name = "cod_armario")
	private Armario armario;

	@ManyToOne
	@JoinColumn(name = "cod_conmutador")
	private Conmutador conmutador;

	private String estado;

	@Column(name = "tipo_equipo")
	private String tipoEquipo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_inicio")
	private Date fechaInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_fin")
	private Date fechaFin;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return codReclamoPex;
	}
}
