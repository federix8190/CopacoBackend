package py.com.copaco.billing.entities;

import java.io.Serializable;
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
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Lila Perez
 * @since 2.0
 * @version 14/07/2015
 */
@Entity
@Table(name = "agrupador_contable")
@Data
@ToString(of = "codAgrupadorContable")
@NoArgsConstructor
@EqualsAndHashCode(of = "codAgrupadorContable", callSuper = true)
public class AgrupadorContable extends BaseEntity<Integer> implements
		Serializable {

	private static final long serialVersionUID = -3992139624182822281L;

	@Id
	@SequenceGenerator(name = "agrupador_contable_seq", sequenceName = "agrupador_contable_seq", allocationSize = 1)
	@GeneratedValue(generator = "agrupador_contable_seq")
	@Column(name = "cod_agrupador_contable")
	private Integer codAgrupadorContable;

	@ManyToOne
	@JoinColumn(name = "cod_evento")
	private Evento evento;
	
	@ManyToOne
	@JoinColumn(name = "cod_servicio")
	private Servicio servicio;
	
	@Column(name = "subtipo_evento")
	private String subtipoEvento;
	
	@ManyToOne
	@JoinColumn(name = "cod_margen_impuesto")
	private MargenImpuesto tipoImpuesto;
	
	@ManyToOne
	@JoinColumn(name = "cod_ciudad")
	private Ciudad ciudad;
	
	@Column(name = "periodo")
	private String periodo;
	
	@ManyToOne
	@JoinColumn(name = "cod_cuenta")
	private Cuenta cuenta;
	
	@ManyToOne
	@JoinColumn(name = "moneda")
	private ListaValoresDet moneda;
	
	@ManyToOne
	@JoinColumn(name = "cod_factura_cab")
	private FacturaCabecera facturaCab;
	
	@Column(name = "monto_impuesto")
	private Double montoImpuesto;
	
	@Column(name = "monto_sin_impuesto")
	private Double montoSinImpuesto;
	
	@Column(name = "monto_impuesto_moneda_local")
	private Double montoImpuestoMonedaLocal;
	
	@Column(name = "monto_sin_imp_moneda_local")
	private Double montoSinImpMonedaLocal;
	
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return codAgrupadorContable;
	}

}