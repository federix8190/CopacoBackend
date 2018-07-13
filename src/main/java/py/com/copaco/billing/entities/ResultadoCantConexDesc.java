package py.com.copaco.billing.entities;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ResultadoCantConexDesc{
	
		String nombre_central;
		String localidad;
		String concepto_servicio;
		Integer cantidad;
		String cliente;
		Integer codCuenta;
		Integer codContrato;
		String codServicio;
		String fechaSolicitud;
		String fechaInicio;
		String fechaFin;
}