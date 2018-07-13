package py.com.copaco.billing.entities;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultDetallesCC {
	String codigo;
	String descripcion;	
	BigDecimal cantidad_producto;
	BigDecimal monto;
	Integer cuenta;
	String nombre;
	BigDecimal saldo;
	String ciclo;
	String telefono;
	Integer pendientes;
	String despacho;
	BigDecimal saldo_periodo;
	BigDecimal cargo;
	BigDecimal interes;
}
