package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * Clase que representa a tabla reclamo_facturacion_cab en la BD
 * 
 * @author Luis Fernandez
 * @since May 27, 2015
 * @version 1.0 
 *
 */
@Entity
@Table(name = "reclamo_facturacion_cab")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codReclamoFacturacionCab", callSuper = true)
public class ReclamoFacturacionCab extends BaseEntity<Integer> implements
		Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "reclamo_facturacion_cab_seq", sequenceName = "reclamo_facturacion_cab_seq", allocationSize = 1)
	@GeneratedValue(generator = "reclamo_facturacion_cab_seq")
	@Column(name = "cod_reclamo_facturacion_cab")
	private Integer codReclamoFacturacionCab;

	@Getter(onMethod = @_(@JsonIgnoreBackend))
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_factura")
	private Factura factura;

	@Getter
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_lv_derivacion")
	private ListaValoresDet derivacion;

	@Column(name = "nombre_contacto")
	private String nombreContacto;

	@Column(name = "telefono_contacto")
	private String telefonoContacto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_reclamo")
	private Date fechaReclamo;

	@Column(name = "estado")
	private String estado;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
		
	@Column(name = "cod_tipo_cuenta")
	private String tipoCuenta;

	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "reclamoFacturacionCab")
	private List<ReclamoFacturacionDet> listaReclamoFactDetalle;

	@Override
	public Integer getId() {
		return codReclamoFacturacionCab;
	}

}
