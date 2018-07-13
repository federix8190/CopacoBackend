package py.com.copaco.billing.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Lila Perez
 * @since 2.0
 * @version 2.0 Dec 11, 2015
 */
@Entity
@Table(name="boca_cobranza_externa")
@Data
@EqualsAndHashCode(of="codBocaCobranzaExt", callSuper=false)
@ToString(of="codBocaCobranzaExt")
public class BocaCobranzaExterna extends BaseEntity<String>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="cod_boca_cobranza_ext")
	private String codBocaCobranzaExt;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="codigo_auten")
	private String codigo_auten;
	
	@Column(name="activo")
	private String activo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;
	
	@Column(name="orden")
	private Integer orden;

	@Override
	public String getId() {
		return this.codBocaCobranzaExt;
	}

}
