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
@EqualsAndHashCode(of="codNivelBloqueoDet", callSuper=false)
@ToString(of="codNivelBloqueoDet")
@Table(name="nivel_bloqueo_det")
public class NivelBloqueoDet extends BaseEntity<Integer>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "nivel_bloqueo_det_seq", sequenceName = "nivel_bloqueo_det_seq", allocationSize = 1)
	@GeneratedValue(generator = "nivel_bloqueo_det_seq")
	@Column(name = "cod_nivel_bloqueo_det")
	private Integer codNivelBloqueoDet;
	
	@ManyToOne
	@JoinColumn(name="cod_tipo_conmutador")
	private TipoConmutador tipoConmutador;
	
	@Column(name="cod_bloq_central")
	private Integer codBloqCentral;
	
	@ManyToOne
	@JoinColumn(name="cod_nivel_bloqueo")
	private NivelBloqueo nivelBloqueo;
	
	@Override
	public Integer getId() {		
		return this.codNivelBloqueoDet;
	}

}
