package py.com.copaco.billing.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
	
	@Data
	@NoArgsConstructor
	public class ResultadoClientesMorosos {
		String nombre_ciudad;
		String ciclo;
		Integer codigo_cuenta;
		String nro_linea;
		String cliente_ape_nom;
		String nro_documento;
		String nombre_contacto;
		String telefono_contacto;
		Integer cant_fac_ven;
		BigDecimal saldo_cuenta;
		String codigo_despacho;
		String estado_cuenta;
		String direccion_desc;
		Timestamp fecha_ultima_fac;
		Timestamp fecha_ultimo_pago;
		String tipo_cuenta_cu;
	}

