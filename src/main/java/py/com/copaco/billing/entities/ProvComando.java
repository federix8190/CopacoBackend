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

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * @author Clara Lopez
 * @since 1.0
 * @version 1.0 Jun 30, 2015
 * 
 */

@Entity
@Data
@EqualsAndHashCode(of="codProvComando", callSuper=false)
@ToString(of="codProvComando")
@Table(name="prov_comando")
public class ProvComando extends BaseEntity<Integer>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "prov_comando_seq", sequenceName = "prov_comando_seq", allocationSize = 1)
	@GeneratedValue(generator = "prov_comando_seq")
	@Column(name = "cod_prov_comando_pk")
	private Integer codProvComando;
	
	private String motivo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_hora")
	private Date fechaHora;
	
	private String modulo;
	
	private String comando;
	
	@ManyToOne
	@JoinColumn(name="cod_conmutador")
	private Conmutador conmutador;
	
	@ManyToOne
	@JoinColumn(name="cod_prov_accion_det")
	private ProvAccionDet provAccionDet;
	
	@ManyToOne
	@JoinColumn(name="cod_lote_comando")
	private ProvLoteComando lote;
	
	@ManyToOne
	@JoinColumn(name="cod_contrato_servicio")
	@NotFound(action=NotFoundAction.IGNORE)
	private ContratoServicio contratoServicio;
	
	private String estado;
	
	@Column(name = "cod_prov_nivel_det")
	private Integer codigoNivel;
	
	@Column( name = "monto_recarga" )
	private Integer montoRecarga;
		
	private Integer confirmation;
	
	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {		
		return this.codProvComando;
	}
	
	@Formula("(case cod_lote_comando when null then 'SIN' else 'CON' end)")
	private String loteString;

}
