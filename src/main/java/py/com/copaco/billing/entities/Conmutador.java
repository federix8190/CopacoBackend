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
 * @author Clara Lopez
 * @since 1.0
 * @version 1.0 Ago 03, 2015
 * 
 */

@Entity
@Data
@EqualsAndHashCode(of="codConmutador", callSuper=false)
@ToString(of="codConmutador")
@Table(name="conmutador")
public class Conmutador extends BaseEntity<Integer>{	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "conmutador_seq", sequenceName = "conmutador_seq", allocationSize = 1)
	@GeneratedValue(generator = "conmutador_seq")
	@Column(name = "cod_conmutador")
	private Integer codConmutador;
	
	private String nombre;
	
	//private String tipo;
	
	private String marca;

	@ManyToOne
	@JoinColumn(name="cod_central")
	private Central central;
	
	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;
	
	@ManyToOne
	@JoinColumn(name="cod_tipo_conmutador")
	private TipoConmutador tipoConmutador;
	
	@Override
	public Integer getId() {		
		return this.codConmutador;
	}

}
