package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
 * @author Luis Fernandez
 *
 */
@Entity
@Data
@Table(name = "diseno_factura_det")
@EqualsAndHashCode(of = "codDisenoFacturaDet", callSuper = true)
@ToString(of = "codDisenoFacturaDet")
public class DisenoFacturaDet extends BaseEntity<Integer> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "diseno_factura_det_seq", sequenceName = "diseno_factura_det_seq", allocationSize = 1)
	@GeneratedValue(generator = "diseno_factura_det_seq")
	@Column(name = "cod_diseno_factura_det")
	private Integer codDisenoFacturaDet;

	@Getter
	@Setter
	@Column(name = "utilizacion")
	private String utilizacion;

	@ManyToOne
	@JoinColumn(name = "tipo_papel")
	private ListaValoresDet tipoPapel;

	@Basic(fetch = FetchType.LAZY)
	@Lob
	@Column(name = "archivo_jrxml")
	private byte[] archivoJrxml;

	@Basic(fetch = FetchType.LAZY)
	@Lob
	@Column(name = "archivo_jasper")
	private byte[] archivoJasper;

	@Basic(fetch = FetchType.LAZY)
	@Lob
	@Column(name = "subreporte_jrxml")
	private byte[] subreporteJrxml;

	@Basic(fetch = FetchType.LAZY)
	@Lob
	@Column(name = "subreporte_jasper")
	private byte[] subreporteJasper;

	@Getter
	@Setter
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_inicio_vig")
	private Date fechaInicioVigencia;

	@Getter
	@Setter
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Getter
	@Setter
	@Column(name = "tiene_subreporte")
	private String tieneSubreporte;

	@Getter
	@Setter
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Getter(onMethod = @_(@JsonIgnoreBackend) )
	@Setter(onMethod = @_(@JsonProperty) )
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_diseno_factura")
	private DisenoFactura disenoFactura;

	@Override
	public Integer getId() {
		return codDisenoFacturaDet;
	}

}
