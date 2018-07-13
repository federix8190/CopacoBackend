package py.com.copaco.billing.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * @author Samuel Acosta
 * @since 1.0
 * @version 1.0 May 24, 2016
 * 
 */

@Entity
@Data
@EqualsAndHashCode(of="codTipoConmutador", callSuper=false)
@ToString(of="codTipoConmutador")
@Table(name="tipo_conmutador")
public class TipoConmutador extends BaseEntity<Integer>{	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "tipo_conmutador_seq", sequenceName = "tipo_conmutador_seq", allocationSize = 1)
	@GeneratedValue(generator = "tipo_conmutador_seq")
	@Column(name = "cod_tipo_conmutador")
	private Integer codTipoConmutador;
	
	@Column(name="codigo_tipo")
	private String codigoTipo;
	
	private String descripcion;

	@Override
	public Integer getId() {		
		return this.codTipoConmutador;
	}

}
