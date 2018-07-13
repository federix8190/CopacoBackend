package py.com.copaco.billing.entities;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultadoCantConexDescDetalleRep {
String nombre_central;
String localidad;
String concepto_servicio;
Integer codigo_os;
String tipo_orden_os;
String numero_nuevo;
String numero_actual;
String estado_os;
Date fecha_creacion_os;
Date fecha_ejecucion_os;
}
