package py.com.copaco.billing.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonProperty;

import py.com.copaco.core.backend.jackson.JsonIgnoreBackend;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(of="codCable", callSuper=false)
@ToString(of="codCable")
public class Cable extends BaseEntity<Integer>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="cable_seq", sequenceName="cable_seq", allocationSize=1)
	@GeneratedValue(generator="cable_seq")
	@Column(name="cod_cable")
	private Integer codCable;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="clase")
	private String clase;
	
	@Column(name="del_par")
	private Integer delPar;
	
	@Column(name="al_par")
	private Integer alPar;
	
	@Column(name="cant_pares")
	private Integer cantPares;
	
	@OneToOne
	@JoinColumn(name="cod_central_orig")
	private Central centralOrigen;
	
	@OneToOne
	@JoinColumn(name="cod_distribuidor_orig")
	private Distribuidor distribuidorOrigen;
	
	@OneToOne
	@JoinColumn(name="cod_armario_orig")
	private Armario armarioOrigen;
	
	@ManyToOne
	@JoinColumn(name = "cod_lv_tipo")
	private ListaValoresDet listaValoresTipo;
	
	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Override
	public Integer getId() {
		return this.codCable;
	}
	
	
	@Getter(onMethod = @_({ @JsonIgnoreBackend }))
	@Setter(onMethod = @_(@JsonProperty))
	@OneToMany(mappedBy="cable", cascade= CascadeType.ALL)
	private List<ConexionCableEquipo> conexiones;
	
	@Transient
	private List<ConexionCableEquipo> eliminados;
	
}
