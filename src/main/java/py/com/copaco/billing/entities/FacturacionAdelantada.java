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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * 
 * @author Adolfo Martinez
 * @since 2.0
 * @version 2.0 04/08/15
 * 
 */
@Entity
@Table(name = "facturacion_adelantada")
@Data
@EqualsAndHashCode(of = "codFacturacionAdelantada", callSuper = false)
@ToString(of = "codFacturacionAdelantada")
public class FacturacionAdelantada extends BaseEntity<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "facturacion_adelantada_seq", sequenceName = "facturacion_adelantada_seq", allocationSize = 1)
	@GeneratedValue(generator = "facturacion_adelantada_seq")
	@Column(name = "cod_facturacion_adelantada")
	private Integer codFacturacionAdelantada;

	@ManyToOne
	@JoinColumn(name = "cod_cuenta")
	private Cuenta cuenta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_solicitud")
	private Date fechaSolicitud;

	@ManyToOne
	@JoinColumn(name = "cod_evento_cab")
	private EventoCab eventoCab;

	private Integer anho;

	private Integer mes;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "facturacionAdelantada", cascade = {
			CascadeType.PERSIST, CascadeType.MERGE })
	private List<FacturacionAdelantadaDet> listaFacturacionAdelantadaDet;

	@Override
	public Integer getId() {
		return this.codFacturacionAdelantada;
	}

}
