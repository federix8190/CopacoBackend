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
import lombok.NoArgsConstructor;


/**
 * 
 * @author Mauro Vera
 * @since 1.0
 * @version 1.0 Ago 21, 2015
 * 
 */
@Entity
@Table(name = "tecnico_cuadrilla")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codTecnicoCuadrilla", callSuper = true)
public class TecnicoCuadrilla extends BaseEntity<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9172880899236032310L;

	@Id
	@SequenceGenerator(name="tecnico_cuadrilla_seq", sequenceName="tecnico_cuadrilla_seq", allocationSize=1)
	@GeneratedValue(generator="tecnico_cuadrilla_seq")
	@Column(name="cod_tecnico_cuadrilla")
	private Integer codTecnicoCuadrilla;
	
	private String  encargado;
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_desde")
	private Date fechaDesde;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_hasta")
	private Date fechaHasta;
	
	@ManyToOne
	@JoinColumn(name="cod_funcionario")
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name="cod_cuadrilla")
	private Cuadrilla cuadrilla;
	
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	
	@Override
	public Integer getId() {
		
		return this.codTecnicoCuadrilla;
	}


}
