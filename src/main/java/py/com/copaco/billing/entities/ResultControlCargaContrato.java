package py.com.copaco.billing.entities;



import java.math.BigDecimal;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultControlCargaContrato {
		String version;
		Integer codigo_cliente;
		Integer codigo_cuenta;
		Integer codigo_contrato;
		String nro_solicitud;
		String fecha_solicitud;
		String nombre_oferta;
		String codigo_producto;
		String categoria_contrato;
		String tipo_facturacion;
		String fecha_inicio;
		String fecha_fin;
		String estado_contrato;
		String codigo_servicio;
		String estado_servicio;
		String direccion_inst;
		String fecha_instalacion_cs;
		String fecha_inicio_cs;
		String nombre_atributo;
		String valor_atributo;
		String codigo_ciclico;
		String tipo_tasacion;
		BigDecimal precio_por_contrato;
		String fecha_creacion;
		String usuario_creacion;
		String fecha_modificacion;
		String usuario_modificacion;
}