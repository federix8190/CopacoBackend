package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
 * Representacion de la entidad de BD correspondiente a Diseno Factura
 * 
 * @author Luis Fernandez
 * @since 1.0
 * @version 1.0 May 06, 2015
 *
 */

@Entity
@Data
@Table(name = "diseno_factura")
@EqualsAndHashCode(of = "codDisenoFactura", callSuper = true)
@ToString(of = "codDisenoFactura")
public class DisenoFactura extends BaseEntity<String> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_diseno_factura")
	private String codDisenoFactura;

	@Column(name = "descripcion")
	private String descripcion;

	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "disenoFactura", cascade = CascadeType.ALL)
	private List<DisenoFacturaDet> listaDetalles;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public String getId() {
		return codDisenoFactura;
	}

}
