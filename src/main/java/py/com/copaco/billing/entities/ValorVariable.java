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
 * @version 1.1 Sep 18, 2014
 * 
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "valor_variable")
@EqualsAndHashCode(of = "codValorVariable", callSuper = true)
public class ValorVariable extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "valor_variable_seq", sequenceName = "valor_variable_seq", allocationSize = 1)
	@GeneratedValue(generator = "valor_variable_seq")
	@Column(name="cod_valor_variable")
	private Integer codValorVariable;

	private String dim1;

	private String dim10;

	private String dim11;

	private String dim12;

	private String dim13;

	private String dim14;

	private String dim15;

	private String dim2;

	private String dim3;

	private String dim4;

	private String dim5;

	private String dim6;

	private String dim7;

	private String dim8;

	private String dim9;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	private String valor;

	@ManyToOne
	@JoinColumn(name="cod_lote_variable")
	private LoteVariable loteVariable;
	
	@ManyToOne
	@JoinColumn(name="cod_variable")
	private Variable variable;

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return codValorVariable;
	}


}