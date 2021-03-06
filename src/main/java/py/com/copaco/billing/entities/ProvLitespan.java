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

@Entity
@Data
@EqualsAndHashCode(of="codProvLitespan", callSuper=false)
@ToString(of="codProvLitespan")
@Table(name="prov_litespan")
public class ProvLitespan extends BaseEntity<Integer>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "prov_litespan_seq", sequenceName = "prov_litespan_seq", allocationSize = 1)
	@GeneratedValue(generator = "prov_litespan_seq")
	@Column(name = "cod_prov_litespan_pk")
	private Integer codProvLitespan;
	
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="cod_prefijo")
	private Prefijo prefijo;
	
	private String exchange_abbr;
	
	private String tipo;
	
	private Integer bloqueo;
	
	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {		
		return this.codProvLitespan;
	}

}
