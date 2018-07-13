package py.com.copaco.billing.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fabiana Romero
 * @version 16/02/2017
 * 
 * @author Adriana Coronel
 * @version 21/03/2017
 */
@Data
@NoArgsConstructor
public class ResultadoCantidadClientesRep {
	String nombre_central;
	String localidad;
	String concepto_servicio;
	BigDecimal cantidad;
	Integer codigo_cliente;
	String nombres_cliente;
	Integer codigo_cuenta;
	Integer codigo_contrato;
	String nro_linea;
	String codigo_servicio;
	Timestamp fecha_inicio_contrato;
	Timestamp fecha_fin_contrato;
}
