package py.com.copaco.billing.entities;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultadoCantidadOSRetraso{
	
	String nombre_central;
	String localidad;
	Integer cantidad;
	Integer ordenservicio;
	String tipoorden;
	String numeronuevo;
	String numeroactual;
	String estado;
	Timestamp fechacreacion;

}