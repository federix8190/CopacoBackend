package py.com.copaco.billing.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultadoCantConexDescRep {
	
		String nombre_central;
		String localidad;
		String concepto_servicio;
		String tipo_orden;
		String estado_orden;
		Integer cantidad;	
}