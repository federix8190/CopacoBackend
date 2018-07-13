package py.com.copaco.billing.entities;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Robert Adlán
 * @since 1.0
 * @version 22/02/2017
 */

@Data
@NoArgsConstructor
public class ResultadoTipoCredito {
	String codTipoCredito;
	String descripcion;
	String observacion;
	String codUsuarioModificacion;
	Timestamp fechaModificacion;
}
