package py.com.copaco.billing.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Robert Adlán Sanabria
 * @since 1.0
 * @version 1.0 Nov 14, 2016
 */

@Data
@NoArgsConstructor
public class ResultadoCuentasPagoCTA {

		Integer codCuenta;
		Integer codCliente;
		String nroDocumentoCliente;
		String nombresCliente;
		String apellidosCliente;
		String estado;
		Double saldo;
		
		
}
