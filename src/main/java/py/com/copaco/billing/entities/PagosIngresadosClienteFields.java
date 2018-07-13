package py.com.copaco.billing.entities;


import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PagosIngresadosClienteFields {

	
	String tipo_cuenta;
	Integer codigo_cuenta;
	Long codigo_lote;
	String nro_linea;
	String cliente_nombre;
	Timestamp fecha_pago;
	BigDecimal importe_efectivo;
	BigDecimal importe_cheque;
	BigDecimal importe_tarj;
	BigDecimal vuelto;
	BigDecimal total;	

	BigDecimal importe_ret_iva;
	BigDecimal importe_ret_renta;
	BigDecimal importe_ret_ley;
	
	BigDecimal contador;
	BigDecimal importe_ret;


}


