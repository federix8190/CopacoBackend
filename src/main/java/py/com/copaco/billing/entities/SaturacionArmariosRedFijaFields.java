package py.com.copaco.billing.entities;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaturacionArmariosRedFijaFields {
	String nombre;
	BigDecimal total_pares;
	BigDecimal en_servicio;
	BigDecimal libres;
	BigDecimal averiados;
	BigDecimal total_pares_sec;
	BigDecimal en_servicio_1;
	BigDecimal libres_1;
	BigDecimal averiados_1;

	
}
