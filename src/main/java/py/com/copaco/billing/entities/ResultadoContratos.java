package py.com.copaco.billing.entities;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lila Perez
 * @since 2.0
 * @version 2.0 Abr 19, 2016
 */
@Data
@NoArgsConstructor
public class ResultadoContratos {
	Integer codContrato;
	String nroSolicitud;
	String categoria;
	String oferta;
	Integer codSolicitud;
	String nombresCliente;
	String apellidosCliente;
	String nroDocumentoCliente;
	String numerosLinea;
	Integer codCuenta;
	String estadoContrato;
	Date fechaInicio;
	Date fechaFin;
	String codUsuario;
	Integer nroItem;
	Date fechaModificacion;
}
