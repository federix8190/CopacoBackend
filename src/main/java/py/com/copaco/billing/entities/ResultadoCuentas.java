package py.com.copaco.billing.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lila Perez
 * @since 2.0
 * @version 2.0 Abr 22, 2016
 */
@Data
@NoArgsConstructor
public class ResultadoCuentas {
	Integer codCuenta;
	Integer codCliente;
	String nroDocumentoCliente;
	String nombresCliente;
	String apellidosCliente;
	String estado;
}
