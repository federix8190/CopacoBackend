package py.com.copaco.billing.entities;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fabiana Romero
 * @version 01/03/2017
 * 
 * @author Mirta Gonzalez
 * @version 28/03/2017
 */
@Data
@NoArgsConstructor
public class RespuestaLineasRetiradas {

	 String desc_departamento;
	 String desc_distrito;
	 String localidad;
	 Integer codigo_cuenta;
	 Integer contrato;
	 String nro_linea;
	 Integer lote;
	 String cod_ciclo_facturacion;
	 String est_contrato;
	 String cod_tratamiento_falta_pago;
	 String desp;
	 Timestamp fecha_ult_fact;
	 Timestamp fecha_fin_contrato;
	 String accion;
	 String motivo;
	 String fecha;
	 String codigo_servicio;
}
