package py.com.copaco.billing.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

public class ResultadoControlCuentaRep {
	@Data
	@NoArgsConstructor
	public static class ResultControlCuenta {
				 	String  version ;
					Integer codigo_cliente ;
					Integer codigo_cuenta;
					String direccion_desc ;
					String agente ;
					String tipo;
					String envio;
					String email;
					String tipo_facturacion;
					Integer cliente_dif;
					String nombre_facturar;
					String ruc;
					String impuesto;
					String ciclo;
					String disenho_factura;
					String direccion_corresp;
					String plazo;
					String despacho_desc;
					String despacho_det;
					String forma_pago;
					String tipo_debito;
					String nro_debito;
					String tratamiento;
					String estado;
					String fecha_operacion;
					String fecha_mod;
					String usuario_operacion;
					String usuario_mod;
			}
		

}
