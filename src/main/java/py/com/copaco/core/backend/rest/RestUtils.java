/*
 * @SortInterpreter.java 1.0 Sep 5, 2014
 * Sistema Integral de Gestion Hospitalaria
 * 
 */
package py.com.copaco.core.backend.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import py.com.copaco.core.backend.ejb.SortInfo;
import py.com.copaco.core.backend.util.ListUtil;

/**
 *
 * @author Arturo Volpe
 * @since 1.0
 * @version 1.0 Sep 5, 2014
 *
 */
public class RestUtils {

    public static final String ORDER_FORMAT_ASC = "asc";
    public static final String ORDER_FORMAT_DES = "des";
    public static final String ORDER_PATTERN = "(.*)\\.(.*)";

    /**
     * Retorna un mapa de ordenes dada una lista serializada.
     *
     * <p>
     * Dado:
     *
     * <pre>
     * 		"nombre.asc"
     * 		"apellido.des"
     * 		"documento.descripcion.des"
     * </pre>
     *
     * Retorna:
     *
     * <pre>
     * 		"nombre" : true
     * 		"apellido" : true
     * 		"documento.descripcion" : false
     * </pre>
     *
     * @param sorts
     * @return
     */
    public static List<SortInfo> deserializeSort(List<String> sorts) {

        if (ListUtil.isEmpty(sorts)) {
            return new ArrayList<>();
        }

        Pattern p = Pattern.compile(ORDER_PATTERN);
        ArrayList<SortInfo> toRet = new ArrayList<SortInfo>();
        for (String s : sorts) {
            if (StringUtils.isEmpty(s)) {
                continue;
            }
            Matcher matcher = p.matcher(s);
            if (!matcher.matches()) {
                throw new RuntimeException("Malformated order " + s);
            }

            String field = matcher.group(1);
            String order = matcher.group(2);

            toRet.add(new SortInfo(field, ORDER_FORMAT_ASC.equals(order)));

        }
        return toRet;
    }

    public static Map<String, String> joinAndCheckLists(
            List<String> properties, List<String> values, Class<?> entityClass) {

        if (ListUtil.isEmpty(properties) || ListUtil.isEmpty(values)) {
            return Collections.emptyMap();
        }

        if (properties.size() != values.size()) {
            throw new RuntimeException(
                    "Diferentes ordenes de propiedades y valores");
        }

        Map<String, String> toRet = new HashMap<>();
        for (int i = 0; i < properties.size(); i++) {
            toRet.put(properties.get(i), values.get(i));
        }

        return toRet;
    }
}
