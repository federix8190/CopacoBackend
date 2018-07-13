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

@Data
@Entity
@Table(name = "lista_valores_det")
@EqualsAndHashCode(of = "codListaValoresDet")
@ToString(of = "codListaValoresDet")
public class ListaValoresDet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "lista_valores_det_seq", sequenceName = "lista_valores_det_seq", allocationSize = 1)
	@GeneratedValue(generator = "lista_valores_det_seq")
	@Column(name = "cod_lista_valores_det")
	private Integer codListaValoresDet;

	@Column(name = "cod_usuario_modificacion")
	private String codUsuarioModificacion;

	private String codigo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Column(name = "valor_mostrar")
	private String valorMostrar;

	@ManyToOne()
	@JoinColumn(name = "cod_lista_valores_cab")
	private ListaValoresCab listaValoresCab;

}