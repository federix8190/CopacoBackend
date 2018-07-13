package py.com.copaco.billing.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Mauro Vera
 * @since 1.0
 * @version 1.0 Sep 9, 2014
 * 
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codCiclico", callSuper = true)
public class Ciclico extends BaseEntity<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_ciclico")
	private String codCiclico;

	@Column(name="cant_cuota")
	private Integer cantCuota;

	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Column(name="cuota_infinita")
	private String cuotaInfinita;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	private String nombre;

	private String prorrateo;
	
	@Column(name="tipo_tasacion")
	private String tipoTasacion;
	

	@Override
	public String getId() {
		return codCiclico;
	}

}