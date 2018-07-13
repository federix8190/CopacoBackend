package py.com.copaco.billing.entities;


import java.math.BigDecimal;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultadoArchivoFacturadoPorMes {
	
		String fecha_fac;
		BigDecimal cont;
		BigDecimal lla_nac;
		BigDecimal lla_inter;
		BigDecimal lla_cel;
		BigDecimal audiotexto;
		BigDecimal abo_basico;
		BigDecimal cargos_ip;
		BigDecimal otros_serv;
		BigDecimal total;


}