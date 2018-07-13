package py.com.copaco.billing.entities;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultadoFaltasReportadasRep {

	String  central;
	String numero;
	String tipo_reclamo;
	String estado;
	Integer dias_sin_solucionar;
	Integer cod_reclamo;
	Timestamp fecha_inicio;
	Timestamp fecha_estado;
	String user_modificacion ;
	String nombre_contacto;
	String telefono_contacto;
	String diagnostico; 
	String solucion; 
	String descripcion;
	}