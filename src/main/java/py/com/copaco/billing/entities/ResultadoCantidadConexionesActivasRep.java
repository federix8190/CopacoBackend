package py.com.copaco.billing.entities;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultadoCantidadConexionesActivasRep {
	//String nombre_central;
	String localidad;
	String concepto_servicio;
	BigDecimal cantidad;
}
