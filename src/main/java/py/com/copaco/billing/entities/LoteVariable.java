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
 * @version 1.0 Sep 26, 2014
 * 
 */
@Entity
@Table(name="lote_variable")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codLoteVariable", callSuper = true)
public class LoteVariable  extends BaseEntity<Integer> implements Serializable  {

	private static final long serialVersionUID = -4032979433157631601L;

	@Id
	@SequenceGenerator(name = "lote_variable_seq", sequenceName = "lote_variable_seq", allocationSize = 1)
	@GeneratedValue(generator = "lote_variable_seq")
	@Column(name="cod_lote_variable")
	private Integer codLoteVariable;

	@ManyToOne
	@JoinColumn(name="cod_variable")
	private Variable variable;
		
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	
	@Override
	public Integer getId() {
		return codLoteVariable;
	}


}
