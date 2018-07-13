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
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(of="codNivelBloqueo", callSuper=false)
@ToString(of="codNivelBloqueo")
@Table(name="nivel_bloqueo")
public class NivelBloqueo extends BaseEntity<Integer>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "nivel_bloqueo_seq", sequenceName = "nivel_bloqueo_seq", allocationSize = 1)
	@GeneratedValue(generator = "nivel_bloqueo_seq")
	@Column(name = "cod_nivel_bloqueo")
	private Integer codNivelBloqueo;
	
	private String nombre;
	
	private String descripcion;
	
	@Override
	public Integer getId() {
		return this.codNivelBloqueo;
	}

}
