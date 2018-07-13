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
import lombok.NoArgsConstructor;

/**
 * @author Claudia Valenzuela <cvalenzuela@pol.una.py>
 * @since 1.0
 * @version 3/12/2015
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "material_deposito")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codMaterialDeposito", callSuper = true)
public class MaterialDeposito extends BaseEntity<Integer> {

	@Id
	@SequenceGenerator(name = "material_deposito_seq", sequenceName = "material_deposito_seq", allocationSize = 1)
	@GeneratedValue(generator = "material_deposito_seq")
	@Column(name = "cod_material_deposito")
	private Integer codMaterialDeposito;

	@Column(name = "codigo")
	private String codigo;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "cant_existente")
	private String cantExistente;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Column(name = "unidad")
	private String unidad;
	
	@Override
	public Integer getId() {
		return this.codMaterialDeposito;
	}

}
