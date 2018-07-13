package py.com.copaco.billing.entities;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Robert Adlán Sanabria - COPACO
 * @since 1.0
 * @version 1.0 Ago 19, 2016
 */

@Data
@NoArgsConstructor
public class ResultadoConsultaCreditos {
	
	String num_factura;
	Integer cuenta;
	String numero_documento;
	String nombre;
	String apellido;
	Timestamp fecha;
	Double creditos;
	Integer cod_despacho;
	Integer saldo;
	String lote;
	String tp1;
	String tp2;
	String id;
	
}
