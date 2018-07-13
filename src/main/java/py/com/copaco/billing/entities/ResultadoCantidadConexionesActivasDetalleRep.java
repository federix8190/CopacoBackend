package py.com.copaco.billing.entities;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ResultadoCantidadConexionesActivasDetalleRep {
	String localidad;
	String concepto_servicio;
	Integer codigo_cliente;
	String nombres_cliente;
	Integer codigo_cuenta;
	Integer codigo_contrato;
	String nro_linea;
	String codigo_servicio;
	Date fecha_inicio_contrato;
	Date fecha_fin_contrato;
}
