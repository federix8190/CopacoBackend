package py.com.copaco.billing.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * 
 * @author Mauro Vera
 * @since 1.0
 * @version 1.0 Nov 23, 2015
 * 
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codFuncionario", callSuper = true)
public class Funcionario extends BaseEntity<Integer> {/**
	 * 
	 */
	private static final long serialVersionUID = 6991469486746100434L;

	@Id
	@SequenceGenerator(name="funcionario_seq", sequenceName="funcionario_seq", allocationSize=1)
	@GeneratedValue(generator="funcionario_seq")
	@Column(name="cod_funcionario")
	private Integer codFuncionario;
	
	@ManyToOne
	@JoinColumn(name="cod_cliente")
	private Cliente cliente;
	
	@Column(name="nro_legajo")
	private String nroLegajo;
	
	@ManyToOne
	@JoinColumn(name="cod_tipo_documento")
	private TipoDocumento tipoDocumento;
	
	
	@Column(name="numero_documento")
	private String numeroDocumento;
	
	private String nombres;
	
	private String apellidos;
	
	private String cargo;
	
	private String categoria;
	
	private String dependencia;
	
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
		
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return this.codFuncionario;
	}
	

}
