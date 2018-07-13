package py.com.copaco.billing.entities;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Fabiana Romero
 * @version 24/01/2017
 */
@Data
@NoArgsConstructor
public class ResultadoAsientosFacturacion {
	String localidad;
	String cod_contable;
	String signo;
	String desc_contable;
	BigDecimal total;
}
