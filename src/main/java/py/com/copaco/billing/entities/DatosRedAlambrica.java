package py.com.copaco.billing.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(of = "codNumero", callSuper = false)
@Table(name = "datos_red_alambrica")
public class DatosRedAlambrica extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1385663416648312668L;

	@Id
	@Column(name = "numero")
	private String codNumero;

	@Column(name = "sigla_central")
	private String siglaCentral;

	@Column(name = "nombre_central")
	private String nombreCentral;

	@Column(name = "nombre_distribuidor")
	private String nombreDistribuidor;

	@Column(name = "nombre_conmutador")
	private String nombreConmutador;

	@Column(name = "tipo_conmutador")
	private String tipoConmutador;

	@Column(name = "cod_area")
	private String codArea;

	@Column(name = "puerto_horizontal")
	private String puertoHorizontal;

	@Column(name = "puerto_digital")
	private String puertoDigital;

	@Column(name = "cable_primario")
	private String cablePrimario;

	@Column(name = "nro_primario")
	private Integer nroPrimario;

	private String armario;

	@Column(name = "cable_secundario")
	private String cableSecundario;

	@Column(name = "nro_secundario")
	private Integer nroSecundario;

	private String caja;

	@Column(name = "par_caja")
	private Integer parCaja;

	@Column(name = "nro_canal")
	private Integer nroCanal;

	@Column(name = "tarjeta_adsl")
	private Integer tarjetaAdsl;

	@Column(name = "puerto_adsl")
	private Integer puertoAdsl;

	@Column(name = "nombre_dslam")
	private String nombreDslam;

	@Column(name = "direccion_adsl")
	private String direccionAdsl;

	@Column(name = "dslam_latitud")
	private String dslamLatitud;

	@Column(name = "dslam_longitud")
	private String dslamLongitud;

	@Override
	public Integer getId() {
		return null;
	}

}
