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
 * The persistent class for the caja database table.
 * 
 * @author Adriana Coronel
 * @since 1.0
 * 
 * 
 */

@Entity
@Table(name="caja_cobranza")
@Data
@EqualsAndHashCode(of="codCajaCobranza", callSuper=false)
@ToString(of="codCajaCobranza")
public class CajaCobranza extends BaseEntity<Integer>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="caja_cobranza_seq", sequenceName="caja_cobranza_seq", allocationSize=1)
	@GeneratedValue(generator="caja_cobranza_seq")
	@Column(name="cod_caja_cobranza")
	private Integer codCajaCobranza;
	
	@Column(name="boca_cobranza")
	private String bocaCobranza;
	
	@Column(name="estado_caja")
	private String estadoCaja;
	
	@Column(name="activo")
	private String activo;
	
	@ManyToOne
	@JoinColumn(name="cod_oficina")
	private Oficina oficina;
	
	@Column(name="fact_contado")
	private String factContado;
	
	@Column(name="boca_expedicion")
	private Integer bocaExpedicion;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "cajaCobranza", cascade = { CascadeType.ALL })
	private List<LotePagos> listaLotePagos;

	@Override
	public Integer getId() {
		return this.codCajaCobranza;
	}

}
