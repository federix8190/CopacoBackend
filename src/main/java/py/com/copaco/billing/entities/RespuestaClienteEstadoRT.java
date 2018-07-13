package py.com.copaco.billing.entities;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Fabiana Romero
 * @version 24/04/2017
 */
@Data
@NoArgsConstructor
public class RespuestaClienteEstadoRT {
String codigo_despacho;
String desc_departamento;
String desc_distrito;
String desc_ciudad;
BigDecimal cantidad;
BigDecimal monto_facturado;
}
