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
 * The persistent class for the caja database table.
 * 
 * @author Adriana Coronel
 * @since 1.0
 * 
 * 
 */

@Entity
@Table(name="concepto_cobranza")
@Data
@EqualsAndHashCode(of="codConceptoCob", callSuper=false)
@ToString(of="codConceptoCob")
public class ConceptoCobranza extends BaseEntity<Integer>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="concepto_cobranza_seq", sequenceName="concepto_cobranza_seq", allocationSize=1)
	@GeneratedValue(generator="concepto_cobranza_seq")
	@Column(name="cod_concepto_cobranza")
	private Integer codConceptoCob;	
	
	@Column(name="descripcion")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "cod_lv_tipo_factura")
	private ListaValoresDet lvTipoFactura;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	

	@Override
	public Integer getId() {
		return this.codConceptoCob;
	}

}
