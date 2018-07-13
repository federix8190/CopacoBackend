package py.com.copaco.billing.entities;

import java.io.Serializable;
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
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Adriana Coronel
 * @since 1.0
 * @version 1.0 Aug 27, 2015
 *
 */


@Entity
@Table(name = "lote_tratamiento")
@Data
@ToString(of = "codLoteTratamiento")
@NoArgsConstructor
@EqualsAndHashCode(of = "codLoteTratamiento", callSuper = true)
public class LoteTratamiento extends BaseEntity<Integer> implements
		Serializable {

	private static final long serialVersionUID = 7838590699745025102L;

	@Id
	@SequenceGenerator(name = "lote_tratamiento_seq", sequenceName = "lote_tratamiento_seq", allocationSize = 1)
	@GeneratedValue(generator = "lote_tratamiento_seq")
	@Column(name = "cod_lote_tratamiento")
	private Integer codLoteTratamiento;

	@Column(name = "cod_evento_cab_ciclicos")
	private Integer codEventoCabCiclicos;
	
	@Column(name = "cod_evento_cab_debitos")
	private Integer codEventoCabDebitos;

	@Column(name = "subproceso")
	private String subproceso;
	
	@Column(name = "ejecucion")
	private String ejecucion;
	
	@Column(name = "periodo")
	private String periodo;
	
	@Column(name = "cod_ciclo_facturacion")
	private String codCicloFacturacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_ejecucion")
	private Date fechaEjecucion;
	
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return codLoteTratamiento;
	}

}
