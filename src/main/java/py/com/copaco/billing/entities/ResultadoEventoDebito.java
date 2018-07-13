package py.com.copaco.billing.entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Adriana Coronel
 * @since 2.0
 * @version 2.0 June 14, 2016
 */
@Data
@NoArgsConstructor
public class ResultadoEventoDebito {

	Integer eventocab;
	String nombre;
	char estado;
	Timestamp fechacreacion;
	Timestamp fechaultima;
	char tipoevento;
	String usuariomod;
	Timestamp fechamod;
	BigInteger coddebito;
	String concepto;
	BigDecimal monto;
	Integer cuenta;

	public BigInteger getId() {
		return coddebito;
	}
}
