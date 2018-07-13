package py.com.copaco.billing.entities;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultadoCargosPendientesCuotas{
	String codigo_tipo_cuenta;
	Date ultima_fecha_fact;
	Integer codigo_cuenta;
	String codigo_producto;
	String nombre_producto;
	String codigo_ciclico;
	Integer codigo_contrato;
	Timestamp fecha_inicio_cont;
	Timestamp fecha_fin_cont;
	BigDecimal precio_ci;
	Integer cantidad_cuotas;
	Integer cantidad_cuotas_generadas;
	BigDecimal cantidad_cuotas_facturadas;
}