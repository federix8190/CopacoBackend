package py.com.copaco.billing.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 
 * @author Arturo Volpe
 * @autor Mauro Vera
 * @since 1.0
 * @version 1.1 oct 07, 2014
 * 
 */
@Entity
@Data
@EqualsAndHashCode(of = "id", callSuper = false)
@ToString(of = "id")
@SequenceGenerator(name = "configuraciones_seq", sequenceName = "configuraciones_seq", allocationSize = 1)
@Table(name = "configuraciones")
@NamedQueries({
	@NamedQuery(name = "configuracion.modulo.value", query = "select c.valor from Configuracion c where lower(c.modulo) = :modulo and lower(c.nombre) = :nombre"),
	@NamedQuery(name = "configuracion.modulo.host", query = "select c from Configuracion c where lower(c.nombre) = :nombre")
})
public class Configuracion extends BaseEntity<Integer> {

	private static final long serialVersionUID = -8789621535673479641L;
	@Id
	@GeneratedValue(generator = "configuraciones_seq")
	@Column(name = "cod_configuracion")
	@Getter(onMethod = @__(@JsonIgnore(false)))
	private Integer id;

	@NotNull
	@Size(max = 50, min = 1)
	private String modulo;

	@Size(max = 50, min = 1)
	@Column(name = "nombre_variable")
	private String nombre;

	@NotNull
	@Size(max = 255, min = 1)
	private String valor;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	/**
	 * Se encarga de auditar el usuario y la fecha de modificacion.
	 */
	@PrePersist
	@PreUpdate
	void audit() {
		if(getCodUsuarioModificacion()==null || getCodUsuarioModificacion().isEmpty())
			setCodUsuarioModificacion("ADMIN");
		setFechaModificacion(new Date());
	}

	/**
	 * Retorna el valor boleano de la configuración.
	 * <p>
	 * Estas comparaciones no son case sensitive
	 * </p>
	 * <p>
	 * <ol>
	 * <li>True son: <code>v</code>, <code>t</code>, <code>verdadero</code>,
	 * <code>false</code>.</li>
	 * <li>False cualquier otro valor</li>
	 * </ol>
	 * 
	 * 
	 * @return ver descripción.
	 */
	public boolean asBool() {
		String valor = this.valor.toLowerCase();
		return valor.equals("v") || valor.equals("t") || valor.equals("true")
				|| valor.equals("verdadero");
	}

	/**
	 * Retorna el valor como un entero.
	 * 
	 */
	public Integer asInteger() {
		return Integer.parseInt(valor);
	}

	/**
	 * Retorna el valor como un número de punto flotante de precisión doble.
	 * 
	 */
	public Double asDouble() {
		return Double.parseDouble(valor);
	}
}
