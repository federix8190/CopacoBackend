package py.com.copaco.billing.entities.util;

import lombok.Getter;


/**
 * @author Clara Lopez
 * @since 1.0
 * @version 1.0 Ago 21, 2015
 * 
 * */

/*
 * Mantenedor de las variables que van en los template de Comando
 * */
public enum ProvComandoVariables {
	
	SERV_AREA_CODE ("{servareacode}"),
	SERV_NUMBER ("{servnumber}"),
	FECHA_INI ("{fechaini}"),
	FECHA_FIN ("{fechafin}"),
	FECHA_CORTE ("{fechacorte}"),
	ACCOUNT_NUMBER ("{accountnumber}"),
	CONTRACT_NR ("{contractnr}"),
	PRODUCT_CODE ("{productcode}"),
	LITESPAN ("{litespan}"),
	PORT_NUMBER ("{portnumber}"),
	LITE_NUMBER ("{litenumber}"),	
	CABECERA ("{cabecera}"),
	NRO_LINEA ("{nrolinea}"),	
	TIPO_LINEA("{tipoLinea}"),//si es que es "ABO" o "LNPBX"	
	COMPLEMENTARIO("{cmpl}"),//mientras para los templ
	BLOQ ("{bloq}"),
	FLG_PREPAGO ("{flgprepago}"), // Flag prepago usado en IMS
	IMSI ("{imsi}");
	
	@Getter
	private String codigo;
	
	private ProvComandoVariables(String codigo) {
		this.codigo = codigo;
	}

}
