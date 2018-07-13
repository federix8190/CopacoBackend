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
 * @version 1.0 Set 25, 2014
 * The persistent class for the cargo_ciclico_ciclo_facturacion database table.
 */

@Entity
@Table(name="cargo_ciclico_ciclo_facturacion")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codCargoCiclicoCicloFacturacion", callSuper = false)
public class CargoCiclicoCicloFacturacion extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "cargo_ciclico_ciclo_facturacion_seq", sequenceName = "cargo_ciclico_ciclo_facturacion_seq", allocationSize = 1)
	@GeneratedValue(generator = "cargo_ciclico_ciclo_facturacion_seq")
	@Column(name="cod_cargo_ciclico_ciclo_facturacion")
	private Integer codCargoCiclicoCicloFacturacion;

	//bi-directional many-to-one association to CicloFacturacion
	@ManyToOne
	@JoinColumn(name="cod_ciclo_facturacion")
	private CicloFacturacion cicloFacturacion;

	//bi-directional many-to-one association to EventoCab
	@ManyToOne
	@JoinColumn(name="cod_evento_cab")
	private EventoCab eventoCab;
		
	@Column(name="anho")
	private Integer anho;
	
	@Column(name="mes")
	private Integer mes;
	
	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return codCargoCiclicoCicloFacturacion;
	}
}