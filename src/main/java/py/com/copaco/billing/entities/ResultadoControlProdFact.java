package py.com.copaco.billing.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultadoControlProdFact {
	Integer codcliente;	
	String apellido;
	String nombre;
	String nrodoc;
	Integer codcuenta;	
	String estadocuenta;
	Integer codcontrato;
	Integer nrocontrato;
	String estadocontrato;
	String telefono;
	Timestamp fechainicio;
	Timestamp fechafin;
	String descripcion;
	BigDecimal cantidad;
	
}
