
package py.com.copaco.billing.entities;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CuentasNumeroFields {

	Timestamp desde;
	Timestamp hasta;
	Integer cod_cuenta;
	Integer nro_item_contrato;
	String codigo;
	String valor_mostrar;
	String nombre_cliente;
	Integer cod_contrato;

}
