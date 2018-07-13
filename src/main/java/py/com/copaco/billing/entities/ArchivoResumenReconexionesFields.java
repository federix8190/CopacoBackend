package py.com.copaco.billing.entities;


import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArchivoResumenReconexionesFields {
	String dsc_dpto;
	String dsc_distrito;
	String dsc_ciudad;
	String desc_concepto;
	String ciclo_facturado;
	Date fecha_emision;
	BigDecimal total;
	
}