package py.com.copaco.billing.entities;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultadoFactLocalidadServ {
	String departamento;
	String distrito;
	String localidad;
	String servicio;
	BigDecimal monto;
	
}
