package py.com.copaco.billing.entities;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Robert Adlán
 * @since 1.0
 * @version 24/01/2016
 */

@Data
@NoArgsConstructor
public class ResultadoTelefonoDeServicio {
	
	int codCuenta;
	String tipoServicio;
	String numLinea;
	Timestamp fechaHabilitacion;
	String nombreResponsable;
	String apellidoResponsable;
	String direccion;
	String SituacionActual;
	int costoMensualProm;
	int facturaActual;
	int facturaAnterior;
	int diferenciaActAnt;
	Timestamp fechaHoy;
	String central;
	
}
