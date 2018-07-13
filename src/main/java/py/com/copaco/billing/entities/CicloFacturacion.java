package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * 
 * @author Mauro Vera
 * @author Mirta Gonzalez
 * @since 1.0
 * @version 1.0 Sep 22, 2014
 */
@Entity
@Data
@ToString(of = "codCicloFacturacion")
@Table(name = "ciclo_facturacion")
@NoArgsConstructor
@EqualsAndHashCode(of = "codCicloFacturacion", callSuper = true)
public class CicloFacturacion extends BaseEntity<String> implements
		Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_ciclo_facturacion")
	private String codCicloFacturacion;

	private String activo;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_ultima_facturacion")
	private Date fechaUltimaFacturacion;

	@Column(name = "auto_credito")
	private String autoCredito;

	@ManyToOne
	@JoinColumn(name = "cod_lv_estado")
	private ListaValoresDet listaValoresDet;

	@Column(name = "usuario_ultima_facturacion")
	private String usuarioUltimaFacturacion;

	@OneToMany(mappedBy = "cicloFacturacion")
	@Getter(onMethod = @_(@JsonIgnoreBackend))
	@Setter(onMethod = @_(@JsonProperty))
	private List<Cuenta> cuentas;

	@Column(name = "dia_corte")
	private Integer diaCorte;

	// bi-directional many-to-one association to FacturaCabecera
	@OneToMany(mappedBy = "cicloFacturacion")
	@Getter(onMethod = @_(@JsonIgnoreBackend))
	@Setter(onMethod = @_(@JsonProperty))
	private List<FacturaCabecera> facturasCabecera;

	@Override
	public String getId() {
		return codCicloFacturacion;
	}

}
