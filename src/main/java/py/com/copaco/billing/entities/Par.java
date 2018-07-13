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

import org.hibernate.annotations.Formula;

/**
 * 
 * The persistent class for the par database table.
 * 
 * @author Clara López
 * @since 1.0
 * @version 1.0, 23/03/15
 * 
 */

@Entity
@Data
@EqualsAndHashCode(of = "codPar", callSuper = false)
@ToString(of = "codPar")
public class Par extends BaseEntity<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "par_seq", sequenceName = "par_seq", allocationSize = 1)
	@GeneratedValue(generator = "par_seq")
	@Column(name = "cod_par")
	private Integer codPar;

	@ManyToOne
	@JoinColumn(name = "cod_cable")
	private Cable cable;

	@Column(name = "nro_par")
	private Integer nroPar;

	private String referencia;

	@ManyToOne
	@JoinColumn(name = "cod_lv_estado")
	private ListaValoresDet listaEstado;

	@ManyToOne
	@JoinColumn(name = "conectado_a")
	private Par conectadoA;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return this.codPar;
	}

	@Formula("(select  gc(nvl(np.numero,ns.numero)) from par p left join red_alambrica rap on p.cod_par=rap.cod_par_primario left join numero np on rap.cod_numero=np.cod_numero left join red_alambrica ras on p.cod_par=ras.cod_par_secundario left join numero ns on ras.cod_numero=ns.cod_numero where p.cod_par=cod_par)")
	private String numero;
}
