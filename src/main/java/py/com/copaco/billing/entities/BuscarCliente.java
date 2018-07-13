package py.com.copaco.billing.entities;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "buscar_cliente_112")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "codigo", callSuper = true)
public class BuscarCliente extends BaseEntity<Integer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6232313768682410265L;
	
	@Id
	@Column(name = "codigo")
	private Integer codigo;

	private Integer cuenta;
	
	@Column(name = "figura_guia")
	private String figuraGuia;
	
	@Column(name = "numero_documento")
	private String numeroDocumento;
	
	private String nombres;
	
	private String apellidos;
	
	private String departamento	;
	
	private String ciudad;
	
	private String direccion;
	
	@Column(name = "nombre_fantasia")
	private String nombreFantasia;
	
	private String comentarios;
	
	@Column(name = "tipo_documento")
	private String tipoDocumento;
	
	private String referencia;
	
	private String latitud;
	
	private String longitud;
	
	private String numero;
	
	@Column(name= "cuenta_catastral")
	private String cuentaCatastral;
	
	@Column(name= "servicio")
	private String servicio;
	
	
	private String distrito;
	
	/** Campos de busqueda avanzados*/ 
	
	@Formula("nombres")
	private String nombresAvanzada;
	
	@Formula("apellidos")
	private String apellidosAvanzada;
	
	@Formula("direccion")
	private String direccionAvanzada;

	@Formula("referencia")
	private String referenciaAvanzada;
	
	@Formula("numero")
	private String numeroAvanzada;
	
	@Formula("nombre_fantasia")
	private String nombreFantasiaAvanzada;
	
	@Formula("comentarios")
	private String comentariosAvanzada;

	
	@Formula("ciudad")
	private String ciudadAvanzada;

	@Formula("numero_documento")
	private String numeroDocumentoAvanzada;
	
	@Formula("departamento")
	private String departamentoAvanzada	;

	@Formula("tipo_documento")
	private String tipoDocumentoAvanzada;

		
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return codigo;
	}

	
}
