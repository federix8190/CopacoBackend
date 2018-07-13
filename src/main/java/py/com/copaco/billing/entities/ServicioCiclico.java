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
 * @author Lila Perez
 * @since 2.0
 * @version 1.0 Set 17, 2014
 * The persistent class for the servicios_ciclico database table.
 */

@Entity
@Table(name="servicio_ciclico")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codServicioCiclico", callSuper = false)
public class ServicioCiclico extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "servicio_ciclico_seq", sequenceName = "servicio_ciclico_seq", allocationSize = 1)
	@GeneratedValue(generator = "servicio_ciclico_seq")
	@Column(name="cod_servicio_ciclico")
	private Integer codServicioCiclico;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="cod_servicio")
	private Servicio servicio;
		
	//bi-directional many-to-one association to Ciclico
	@ManyToOne
	@JoinColumn(name="cod_ciclico")
	private Ciclico ciclico;
	
	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Column(name="precio_min")
	private Integer precioMinimo;
	
	@Column(name="precio_max")
	private Integer precioMaximo;
	
	@Override
	public Integer getId() {
		return codServicioCiclico;
	}
}