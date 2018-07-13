package py.com.copaco.billing.entities;

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
import lombok.ToString;

/**
 * 
 * The persistent class for the funcionario_oficina database table.
 * 
 * @author Adriana Coronel
 * @since 1.0
 * 
 * 
 */

@Entity
@Table(name="funcionario_oficina")
@Data
@EqualsAndHashCode(of="codFuncionarioOficina", callSuper=false)
@ToString(of="codFuncionarioOficina")
public class FuncionarioOficina extends BaseEntity<Integer>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="funcionario_oficina_seq", sequenceName="funcionario_oficina_seq", allocationSize=1)
	@GeneratedValue(generator="funcionario_oficina_seq")
	@Column(name="cod_funcionario_oficina")
	private Integer codFuncionarioOficina;
	
	@ManyToOne
	@JoinColumn(name="cod_funcionario")
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name="cod_oficina")
	private Oficina oficina;
	
	@Column (name="estado")
	private String estado;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_asignacion")
	private Date fechaAsignacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_desasignacion")
	private Date fechaDesasignacion;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;


	@Override
	public Integer getId() {
		return this.codFuncionarioOficina;
	}

}
