package py.com.copaco.billing.entities;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultadoFacturadoCobrado {
	String departamento;
	String distrito;
	String localidad;
	Integer cuenta;
	String ciclo;	
	BigDecimal saldo_pendiente;
	BigDecimal facturado;
	BigDecimal cobrado;
	BigDecimal acreditado;
	BigDecimal saldo_final;
}