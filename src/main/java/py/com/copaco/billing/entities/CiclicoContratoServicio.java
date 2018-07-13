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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Mauro Vera
 * @since 1.0
 * @version 1.0 Sep 24, 2014
 * 
 */
@Entity
@Table(name = "ciclico_contrato_servicio")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codCiclicoContratoServicio", callSuper = true)
public class CiclicoContratoServicio extends BaseEntity<Integer> implements
		Serializable {

	private static final long serialVersionUID = -5517244685313397311L;

	@Id
	@SequenceGenerator(name = "ciclico_contrato_servicio_seq", sequenceName = "ciclico_contrato_servicio_seq", allocationSize = 1)
	@GeneratedValue(generator = "ciclico_contrato_servicio_seq")
	@Column(name = "cod_ciclico_contrato_servicio")
	private Integer codCiclicoContratoServicio;

	@ManyToOne
	@JoinColumn(name = "cod_servicio_ciclico")
	private ServicioCiclico servicioCiclico;

	@ManyToOne
	@JoinColumn(name = "cod_contrato_servicio")
	private ContratoServicio contratoServicio;

	@Column(name = "cant_cuotas")
	private Integer cantidadCuotas;

	@Column(name = "precio")
	private Double precio;

	@Column(name = "estado")
	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_hasta_generada")
	private Date fechaHastaGenerada;

	@Column(name = "cant_cuotas_generadas")
	private Integer cantidadCuotasGeneradas;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	// bi-directional many-to-one association to ListaValoresDet
	@ManyToOne
	@JoinColumn(name = "moneda_lv")
	private ListaValoresDet moneda;

	@Override
	public Integer getId() {
		return codCiclicoContratoServicio;
	}

}
