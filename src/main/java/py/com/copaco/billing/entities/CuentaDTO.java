package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(of = "codCuenta")
@EqualsAndHashCode(of = "codCuenta")
public class CuentaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Integer codCuenta;

	@Getter
	@Setter
	private Integer codDespacho;

	@Getter
	@Setter
	private List<String> oficinas;

	@Getter
	@Setter
	private List<String> ofertas;

	@Getter
	@Setter
	private List<String> servicios;

	@Getter
	@Setter
	private String estado;

	@Getter
	@Setter
	private String formaDesconexion;

	@Getter
	@Setter
	private String plazoFacturacion;

	@Getter
	@Setter
	private String formaPago;

	@Getter
	@Setter
	private String tipoDebito;

	@Getter
	@Setter
	private String tipoFacturacion;
	
	@Getter
	@Setter
	private Boolean movido = false;


}
