package py.com.copaco.billing.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * @author Willian Martinez
 * @since 1.0
 * @version 1.0 Mar 26, 2015
 */

/**
 * 
 * @author Clara Lopez
 * @since 1.0
 * @version 1.0 Ago 04, 2015
 * 
 */

@Entity
@Data
@EqualsAndHashCode(of = "codNumero", callSuper = false)
@ToString(of = "codNumero")
public class Numero extends BaseEntity<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "numero_seq", sequenceName = "numero_seq", allocationSize = 1)
	@GeneratedValue(generator = "numero_seq")
	@Column(name = "cod_numero")
	private Integer codNumero;

	private String numero;

	@ManyToOne
	@JoinColumn(name = "cod_prefijo")
	private Prefijo prefijo;

	@ManyToOne
	@JoinColumn(name = "cod_distribuidor")
	private Distribuidor distribuidor;

	@ManyToOne
	@JoinColumn(name = "cod_lv_tipo")
	private ListaValoresDet lvTipo;

	@Column(name = "estado")
	private String estado;

	@ManyToOne
	@JoinColumn(name = "cod_tecnologia")
	private Tecnologia tecnologia;
	
	@ManyToOne
	@JoinColumn(name = "cod_nivel_bloqueo_det_actual")
	private NivelBloqueoDet nivelBloqueoDetActual;
	
	@ManyToOne
	@JoinColumn(name = "cod_nivel_bloqueo_det_original")
	private NivelBloqueoDet nivelBloqueoDetOriginal;
	
	@ManyToOne
	@JoinColumn(name = "cod_nivel_bloqueo_det_rbk")
	private NivelBloqueoDet nivelBloqueoDetRbk;
	
	@OneToOne
	@JoinColumn(name = "cod_conmutador")
	private Conmutador conmutador;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Override
	public Integer getId() {
		return this.codNumero;
	}
}
