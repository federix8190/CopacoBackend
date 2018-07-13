package py.com.copaco.billing.entities;

import java.util.Date;

import lombok.Data;

/**
 * @author Robert Adlán Sanabria - COPACO
 * @since 1.0
 * @version 1.0 Ago 19, 2016
 */

@Data
public class ResultadoConsultaFact {

	Integer cod_factura;
	Integer cod_cuenta;
	String ci_ruc;
	String nombres;
	String apellidos;
	int cod_despacho_det;
	String num_factura;
	Date fecha_emision;
	Date fecha_vencimietno;
	double monto;
	double monto_total;
	double monto_total_orig;
	String estado_fact;
	
	
}
