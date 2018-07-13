package py.com.copaco.billing.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Fabiana Romero
 * @since 1.0
 * @version 1.0 19/05/2017
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tecnico_reclamo")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codTecnicoReclamo", callSuper = true)
public class TecnicoReclamo extends BaseEntity<Integer>{
	
	//private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "tecnico_reclamo_seq", sequenceName = "tecnico_reclamo_seq", allocationSize = 1)
	@GeneratedValue(generator = "tecnico_reclamo_seq")
	@Column(name="cod_tecnico_reclamo")
	private Integer codTecnicoReclamo;

	@ManyToOne
	@JoinColumn(name = "cod_funcionario")
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name = "cod_orden_servicio")
	private OrdenServicio ordenServicio;
	
	@ManyToOne
	@JoinColumn(name = "cod_solucion")
	private Solucion solucion;
	
	@Override
	public Integer getId() {
	return this.codTecnicoReclamo;
	}
}
