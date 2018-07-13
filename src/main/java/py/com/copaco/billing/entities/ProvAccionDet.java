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

import org.codehaus.jackson.annotate.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(of="codProvAccionDet", callSuper=false)
@ToString(of="codProvAccionDet")
@Table(name = "prov_accion_det")
public class ProvAccionDet extends BaseEntity<Integer>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "prov_accion_det_seq", sequenceName = "prov_accion_det_seq", allocationSize = 1)
	@GeneratedValue(generator = "prov_accion_det_seq")
	@Column(name = "cod_prov_accion_det_pk")
	private Integer codProvAccionDet;
	
	@Column(name = "template_comando")
	private String templateComando;
	
	private String subtipo1;
	
	private String subtipo2;
	
	private String subtipo3;
	
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
		return this.codProvAccionDet;
	}
	
	@JsonIgnore
	public String getTemplateComandoVista()
	{
		if(templateComando.length()>20)
		{
			return templateComando.substring(0, 20);
		}
		else
		{
			return templateComando;
		}
	}
	
	

}
