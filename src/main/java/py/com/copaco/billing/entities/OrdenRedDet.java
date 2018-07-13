package py.com.copaco.billing.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Claudia Valenzuela <cvalenzuela@pol.una.py>
 * @since 1.0
 * @version 3/12/2015
 * 
 * @author Mirta Gonzalez
 * @version 16/05/2016
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "orden_red_det")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codOrdenRedDet", callSuper = true)
public class OrdenRedDet extends BaseEntity<Integer> {

	@Id
	@SequenceGenerator(name = "orden_red_det_seq", sequenceName = "orden_red_det_seq", allocationSize = 1)
	@GeneratedValue(generator = "orden_red_det_seq")
	@Column(name = "cod_orden_red_det")
	private Integer codOrdenRedDet;

	@Column(name = "central")
	private String central;

	@Column(name = "distribuidor")
	private String distribuidor;

	@Column(name = "armario")
	private String armario;

	@Column(name = "caja")
	private String caja;

	@Column(name = "cable_primario")
	private String cablePrimario;

	@Column(name = "par_primario")
	private Integer parPrimario;

	@Column(name = "cable_secundario")
	private String cableSecundario;

	@Column(name = "par_secundario")
	private Integer parSecundario;

	@Column(name = "par_caja")
	private Integer parCaja;

	@Column(name = "nro_canal")
	private Integer nroCanal;

	@Column(name = "puerto_digital")
	private String puertoDigital;

	@Column(name = "puerto_horizontal")
	private String puertoHorizontal;

	@Column(name = "puerto_adsl")
	private Integer puertoAdsl;

	@Column(name = "tarjeta")
	private Integer tarjeta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion_noc")
	private Date fechaCreacionNoc;

	@Column(name = "usuario_pppoe")
	private String usuarioPppoe;

	@Column(name = "dslam")
	private String dslam;

	@Column(name = "coordenadas_dslam")
	private String coordenadasDslam;

	@Column(name = "numero")
	private String numero;

	@Column(name = "prefijo_numero")
	private String prefijoNumero;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "referencia")
	private String referencia;

	@Column(name = "departamento")
	private String departamento;

	@Column(name = "distrito")
	private String distrito;

	@Column(name = "cuidad")
	private String cuidad;

	@Column(name = "barrio")
	private String barrio;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "cod_red_alambrica")
	private RedAlambrica redAlambrica;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return this.codOrdenRedDet;
	}

}
