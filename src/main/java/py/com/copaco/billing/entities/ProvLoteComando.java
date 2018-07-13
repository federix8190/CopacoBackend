package py.com.copaco.billing.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * @author Clara Lopez
 * @since 1.0
 * @version 1.0 Jun 30, 2015
 * 
 */

@Entity
@Data
@EqualsAndHashCode(of = "codProvLoteComando", callSuper = false)
@ToString(of = "codProvLoteComando")
@Table(name = "prov_lote_comando")
public class ProvLoteComando extends BaseEntity<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "prov_lote_comando_seq", sequenceName = "prov_lote_comando_seq", allocationSize = 1)
	@GeneratedValue(generator = "prov_lote_comando_seq")
	@Column(name = "cod_prov_lote_comando_pk")
	private Integer codProvLoteComando;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_hora")
	private Date fechaHora;

	@Column(name = "comentario")
	private String comentario;

	private String estado;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Column(name = "lote_archivo")
	private Integer loteArchivo;

	@Column(name = "tipo_lote")
	private String tipoLote;

	@Override
	public Integer getId() {
		return this.codProvLoteComando;
	}

}
