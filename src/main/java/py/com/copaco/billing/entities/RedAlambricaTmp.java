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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * @author Mirta Gonzalez
 * @since 1.0
 * @version 1.0 Ene 25, 2016
 * 
 */

@Entity
@Data
@EqualsAndHashCode(of = "codRedAlambricaTmp", callSuper = false)
@ToString(of = "codRedAlambricaTmp")
@Table(name = "red_alambrica_tmp")
public class RedAlambricaTmp extends BaseEntity<Integer> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "red_alambrica_tmp_seq", sequenceName = "red_alambrica_tmp_seq", allocationSize = 1)
	@GeneratedValue(generator = "red_alambrica_tmp_seq")
	@Column(name = "cod_red_alambrica_tmp")
	private Integer codRedAlambricaTmp;

	@ManyToOne
	@JoinColumn(name = "cod_numero")
	private Numero numero;

	@ManyToOne
	@JoinColumn(name = "cod_puerto")
	private Puerto puerto;

	@ManyToOne
	@JoinColumn(name = "cod_par_primario")
	private Par parPrimario;

	@ManyToOne
	@JoinColumn(name = "cod_par_secundario")
	private Par parSecundario;

	@Column(name = "nro_canal")
	private Integer nroCanal;

	@Column(name = "nro_par_caja")
	private Integer nroParCaja;

	@ManyToOne
	@JoinColumn(name = "cod_cable_troncal")
	private Cable cableTroncal;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {
		return this.codRedAlambricaTmp;
	}

}

