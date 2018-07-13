package py.com.copaco.billing.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

public class ResultadoControlCliente {
	
	@Data
	@NoArgsConstructor
	public static class ResultControlCliente {
		 	String  version ;
			Integer codigo_cliente ;
			String tipo_per;
			String prof ;
			String tipo_doc ;
			String nro_doc;
			String nombre_cliente ;
			String fecha_nac ;
			String pais ;
			String rad ;
			String fecha_rad_tmp ;
			String correo ;
			String correo2 ;
			String es_exento;
			String cedula_trib ;
			String tipo_cliente ;
			String tipo_cliente_priv ;
			String tipo_cliente_est ;
			String direccion_desc ;
			String nombres_contacto ;
			String tipo_doc_contacto ;
			String nro_doc_contacto ;
			String tipo_contacto ;
			String tel_fijo_contacto ;
			String cel1_contacto ;
			String cel2_contacto ;
			String email_contacto ;
			String obs_contacto ;
			String fecha_operacion ;
			String fecha_modificacion ;
			String usuario_operacion ;
			String usuario_mod;
			String entidad_reten;
	}

}
