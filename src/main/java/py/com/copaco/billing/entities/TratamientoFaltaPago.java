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
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Representacion de la entidad de BD correspondiente a Tratamiento falta pago.
 * 
 * @author Mauro Vera
 * @since 1.0
 * @version 1.0 May 06, 2015
 *
 */

@Entity
@Table(name = "tratamiento_falta_pago")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codTratamientoFaltaPago", callSuper = true)
public class TratamientoFaltaPago extends BaseEntity<String> implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3462912781110100613L;

	@Id
	@Column(name = "cod_tratamiento_falta_pago")
	private String codTratamientoFaltaPago;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Getter(onMethod=@_({@JsonIgnoreBackend}))
	@Setter(onMethod=@_(@JsonProperty))
	@OneToMany(mappedBy = "tratamientoFaltaPago", cascade = CascadeType.ALL)
	private List<TratamientoFaltaPagoDet> listaTratamientoFaltaPagoDet;
	


	@Override
	public String getId() {
		return codTratamientoFaltaPago;
	}

}
