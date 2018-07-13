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
@EqualsAndHashCode(of="codProvLitespanRangos", callSuper=false)
@ToString(of="codProvLitespanRangos")
@Table(name="prov_litespan_rangos")
public class ProvLitespanRangos extends BaseEntity<Integer>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "prov_litespan_rangos_seq", sequenceName = "prov_litespan_rangos_seq", allocationSize = 1)
	@GeneratedValue(generator = "prov_litespan_rangos_seq")
	@Column(name = "cod_prov_litespan_rangos_pk")
	private Integer codProvLitespanRangos;
	
	@ManyToOne
	@JoinColumn(name="cod_prov_litespan")
	private ProvLitespan litespan;
	
	@Column(name="rango_desde")
	private Integer rangoDesde;
	
	@Column(name="rango_hasta")
	private Integer rangoHasta;
	
	@Column(name="servidor_aplicacion")
	private String servidorAplicacion;
	
	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;
	
	@Override
	public Integer getId() {		
		return this.codProvLitespanRangos;
	}

}
