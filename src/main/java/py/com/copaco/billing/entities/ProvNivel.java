package py.com.copaco.billing.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;

/**
 * 
 * @author Clara Lopez
 * @since 1.0
 * @version 1.0 Jun 22, 2015
 * 
 */

@Entity
@Data
@EqualsAndHashCode(of="codProvNivel", callSuper=false)
@ToString(of="codProvNivel")
@Table(name="prov_nivel")
public class ProvNivel extends BaseEntity<Integer>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "prov_nivel_seq", sequenceName = "prov_nivel_seq", allocationSize = 1)
	@GeneratedValue(generator = "prov_nivel_seq")
	@Column(name = "cod_prov_nivel_pk")
	private Integer codProvNivel;
	
	@Column(name="codigo_nivel")
	private String codigoNivel;
	
	private String descripcion;	
	
	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy = "nivel")
	private List<ProvNivelDet> nivelesDet;
	
	@Column(name="cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Override
	public Integer getId() {		
		return this.codProvNivel;
	}

}
