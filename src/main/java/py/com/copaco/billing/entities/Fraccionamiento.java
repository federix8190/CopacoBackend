package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 
 * @author Luis Fernandez
 * @since 18 June, 2015
 * @version 1.0
 *
 */
@Entity
@Table(name = "fraccionamiento")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codFraccionamiento", callSuper = true)
public class Fraccionamiento extends BaseEntity<Integer> implements
		Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "fraccionamiento_seq", sequenceName = "fraccionamiento_seq", allocationSize = 1)
	@GeneratedValue(generator = "fraccionamiento_seq")
	@Column(name = "cod_fraccionamiento")
	private Integer codFraccionamiento;

	@Getter
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_factura")
	private Factura factura;

	@Getter
	@Setter(onMethod = @_(@JsonProperty))
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_contrato")
	private Contrato contrato;

	@Column(name = "telefono_contacto")
	private String telefonoContacto;

	@Column(name = "entrega_inicial")
	private Double entregaInicial;

	@Column(name = "gastos_administrativos")
	private Double gastosAdm;

	@Column(name = "otros_gastos")
	private Double otrosGastos;

	@Column(name = "monto_fraccionar")
	private Double montoFraccionar;

	@Column(name = "cant_cuotas")
	private Integer cantCuotas;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Column(name = "interes_fracc")
	private Double interesFraccionamiento;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "cod_tipo_cuenta")
	private String tipoCuenta;

	@Override
	public Integer getId() {
		return codFraccionamiento;
	}

}
