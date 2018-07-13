package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Entity
@Data
@EqualsAndHashCode(of = "codRedADSL", callSuper = false)
@ToString(of = "codRedADSL")
@Table(name = "red_adsl")

public class RedADSL extends BaseEntity<Integer>  implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "red_adsl_seq", sequenceName = "red_adsl_seq", allocationSize = 1)
	@GeneratedValue(generator = "red_adsl_seq")
	@Column(name = "cod_red_adsl")
	private Integer codRedADSL;
	
	@Column(name = "tarjeta")
	private Integer tarjeta;
	
	@Column(name = "puerto")
	private Integer puerto;
	
	@Column(name = "dslam")
	private String dslam;
	
	@ManyToOne
	@JoinColumn(name = "cod_direccion_dslam")
	private Direccion direccion;
	
	@Column(name = "usr_pppoe")
	private String usrPppoe;
	
	@Column(name = "cuenta_pppoe")
	private String cuentaPppoe;
	
	@Column(name = "fecha_creacion_noc")
	private Date fechaCreacionNoc;
	
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	
	@Override
	public Integer getId() {
		return this.codRedADSL;
	}

}
