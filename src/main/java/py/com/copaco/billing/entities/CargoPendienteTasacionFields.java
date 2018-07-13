package py.com.copaco.billing.entities;


import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CargoPendienteTasacionFields {
	
	String nombre;
	 Timestamp fecha_carga;
	 
	 Long sys_cod_evt_llamada_tmp;
	 BigDecimal lmonto;
	 BigDecimal importe_impuesto;
	 BigDecimal importe_sin_impuesto;
	 String moneda;
	 BigDecimal unidades_tasadas ;
	 String codigo_concep;
	 String codigo_cont;
	 Timestamp fecha;
	 String origen;
	 String destino;
	 Timestamp fecha_inicio;
	 Timestamp fecha_fin;
	 BigDecimal duracion;
	 String troncal_entrada;
	 String troncal_salida;
	 String cobro_revertido;
	 String tipo;
	 String tipo_destino;
	 String id_particion;
	 String central;
	 String proceso;
	 String cod_pais_origen;
	 String cod_area_origen;
	 String numero_origen;
	 String cod_pais_destino;
	 String cod_area_destino;
	 String numero_destino;
	 String pais_destino;
	 String tipo_horario;
	 String nombre_archivo_source;
	 String tipo_impuesto;
	 Integer sys_cod_evento_cab;
	 String sys_reglas;
	 Integer sys_contrato_servicio;
	 String sys_resultado;
}
