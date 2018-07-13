package py.com.copaco.billing.entities;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Fabiana Romero
 * @version 16/02/2017
 * 
 */
@Data
@NoArgsConstructor
public class ResultadoContratoSinFechaInicio {
String desc_departamento;
String desc_distrito;
String desc_ciudad;
String grupo_servicio;
BigDecimal cantidad;
}
