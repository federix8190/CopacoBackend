package py.com.copaco.billing.entities;

import java.io.Serializable;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * The persistent class for the cronograma database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codCronograma", callSuper = true)
public class Cronograma extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "cronograma_seq", sequenceName = "cronograma_seq", allocationSize = 1)
	@GeneratedValue(generator = "cronograma_seq")
	@Column(name = "cod_cronograma")
	private Integer codCronograma;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	private Integer periodo;

	@ManyToOne
	@JoinColumn(name = "cod_ciclo_facturacion")
	private CicloFacturacion cicloFacturacion;

	
	@Getter(onMethod=@_({@JsonIgnoreBackend}))
	@Setter(onMethod=@_(@JsonProperty))
	@OneToMany(mappedBy = "cronograma", cascade = CascadeType.ALL)
	private List<CronogramaDetalle> detalles;
	//@OneToMany(mappedBy = "cronograma")
	//@JsonIgnoreBackend
	

	@Override
	public Integer getId() {
		return codCronograma;
	}

}