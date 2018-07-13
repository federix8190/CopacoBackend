package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase auxiliar utilizada en la vista de Reclamos
 * 
 * @author Luis Fernandez
 * @since 11 June, 2015
 * @version 1.0
 *
 */
@Data
@NoArgsConstructor
public class ReclamoViewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer codigoEvento;
	private String codConcepto;
	private Integer sysEvtAce;
	private String moneda;
	private String concepto;
	private Date fecha;
	private Double iva;
	private Double montoIva;
	private String estado;
	private String comentario;
	private String detalleCargo;
	private String moraFact;

}
