package py.com.copaco.billing.entities;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultadoFaltasReportadasComRep {

	Integer cod_cuenta;
	String cod_despacho;
	String numero;
	String tipo_reclamo;
	String estado;
	//Integer dias_sin_solucionar;
	Integer cod_reclamo;
	Timestamp fecha_inicio;
	Timestamp fecha_estado;
	//String user_modificacion;
	String nombre_contacto;
	String telefono_contacto;
	String correo_contacto;
	String tipo_diagnostico; 
	String solucion;
	String descripcion;
	String tipo_error_reportado;
	}