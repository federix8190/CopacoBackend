package py.com.copaco.billing.entities;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultadoOrdenServicio {
	
		Integer codOrden;
		String estado;
		String tipo;
		String tecnologia;
		Date fechaCreacion;
		Integer diasPendientes;
		Integer codCuenta;
		Integer codContrato;
		String nombresCliente;
		String apellidosCliente;
		String tipoCuenta;
		Date fechaModificacion;
		String usuarioModificacion;
		Integer codContratoServicio;
	
}
