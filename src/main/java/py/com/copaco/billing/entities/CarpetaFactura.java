package py.com.copaco.billing.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * The persistent class for the carpeta_factura database table.
 * 
 * @author Adriana Coronel
 * @since 2.0
 * 
 * 
 */

@Entity
@Table(name="carpeta_factura")
@Data
@EqualsAndHashCode(of="codCarpetaFactura", callSuper=false)
@ToString(of="codCarpetaFactura")
public class CarpetaFactura extends BaseEntity<Integer>{
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="carpeta_factura_seq", sequenceName="carpeta_factura_seq", allocationSize=1)
	@GeneratedValue(generator="carpeta_factura_seq")
	@Column(name="cod_carpeta_factura")
	private Integer codCarpetaFactura;

	@ManyToOne
	@JoinColumn(name="cod_lote_boleta_dep")
	private LoteBoletaDeposito loteBoletaDep;
	
	@ManyToOne
	@JoinColumn(name="cod_factura")
	private Factura factura;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return this.codCarpetaFactura;
	}

}
