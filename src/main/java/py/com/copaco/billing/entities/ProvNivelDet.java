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
 * @version 1.0 Jun 22, 2015
 * 
 */

@Entity
@Data
@EqualsAndHashCode(of="codProvNivelDet", callSuper=false)
@ToString(of="codProvNivelDet")
@Table(name="prov_nivel_det")
public class ProvNivelDet extends BaseEntity<Integer>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "prov_nivel_det_seq", sequenceName = "prov_nivel_det_seq", allocationSize = 1)
	@GeneratedValue(generator = "prov_nivel_det_seq")
	@Column(name = "cod_prov_nivel_det_pk")
	private Integer codProvNivelDet;
	
	@ManyToOne
	@JoinColumn(name="cod_prov_nivel")
	private ProvNivel nivel;
	
	@ManyToOne
	@JoinColumn(name="cod_tecnologia")
	private Tecnologia tecnologia;
		
	@ManyToOne
	@JoinColumn(name="cod_prov_accion")
	private ProvAccion accion;

	
	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {		
		return this.codProvNivelDet;
	}

}
