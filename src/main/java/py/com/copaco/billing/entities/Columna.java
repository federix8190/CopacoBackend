package py.com.copaco.billing.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Claudia Valenzuela
 * @since 1.0
 * @version 16/03/2015
 */
@SuppressWarnings("serial")
@Entity
@Data
@ToString(of = "codColumna")
@EqualsAndHashCode(of = "codColumna", callSuper = false)
public class Columna extends BaseEntity<Integer> {

	@Id
	@SequenceGenerator(name = "columna_seq", sequenceName = "columna_seq", allocationSize = 1)
	@GeneratedValue(generator = "columna_seq")
	@Column(name = "cod_columna")
	private Integer codColumna;

	@Column(name = "cant_posiciones")
	private Integer cantPosiciones;

	@Column(name = "pares_por_posicion")
	private Integer paresPorPosicion;

	@Column(name = "columna_nro")
	private Integer columnaNro;

	@Column(name = "cant_filas")
	private Integer cantFilas;

	@ManyToOne()
	@JoinColumn(name = "cod_distribuidor")
	private Distribuidor distribuidor;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Column(name = "en_serie")
	private String enSerie;

	private transient boolean numeracionSerie;

	@Override
	public Integer getId() {
		return codColumna;
	}
}
