package py.com.copaco.billing.entities;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuditoriaCuentaFields {

		String nuevo;
		String nombre;
		String apellido;
		String numero_documento;
		String direccion;
		String margen_impuesto;
		String nombre_facturar;
		String ruc;
		String deb_aut;
		String form_pag;
		String lv_estado;
		String clco;
		String activo;
		String codigo_orig_datos;
		String n_cuenta_diferida;
		String n_cod_usuario_modificacion;
		String n_email;
		String n_tipo_envio_factura;
		String n_cod_diseno_factura;
		String n_cod_tipo_cuenta;
		String n_cod_tratamiento_falta_pago;
		String n_motivo_modificacion;
		
		Integer cuenta;      						

		Integer cliente;       						

		Integer tip_deb;       						
		Integer n_cod_cliente_facturacion;      		
		Integer n_cant_fact_venc_imp;       			
			
		Integer saldo;     						 	
		Integer consumo_periodo;      				
		Integer n_monto_fact_ven_imp;      			
		
		Date n_fecha_modificacion;     			
		Timestamp fecha_audit; 						
		Date COLUMN_32;       					

}


