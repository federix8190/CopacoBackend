package py.com.copaco.core.backend.ejb;

import static org.torpedoquery.jpa.Torpedo.condition;
import static org.torpedoquery.jpa.Torpedo.from;
import static org.torpedoquery.jpa.Torpedo.orderBy;
import static org.torpedoquery.jpa.Torpedo.select;
import static org.torpedoquery.jpa.Torpedo.where;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.torpedoquery.jpa.Function;
import org.torpedoquery.jpa.OnGoingLogicalCondition;
import org.torpedoquery.jpa.OnGoingStringCondition;
import org.torpedoquery.jpa.Query;
import org.torpedoquery.jpa.TorpedoFunction;

import py.com.copaco.billing.entities.BuscarCliente;

/**
 * 
 * @author Arturo Volpe
 * @since 1.0
 * @version 1.0 Sep 5, 2014
 * 
 * @author Mirta Gonzalez
 * @version 1.0 May 12, 2016
 * 
 */
public class QueryHelper {

	/**
	 * Clase que permite interceptar la creación de la consulta, y permite
	 * modificar los filtros y la ordenación.
	 * 
	 * @param <T>
	 *            clase origen, la misma que el from.
	 */
	public static class QueryCustomizer<T> {

		/**
		 * Permite agregar condifiones al where.
		 * <p>
		 * El parámetro <code>from</code> es la raiz de la expresión.
		 * </p>
		 * 
		 * @param from
		 *            principal del query
		 * @return condición a la que se le concatenarán las demas condiciones
		 *         típicas del filtro.
		 */
		public OnGoingLogicalCondition firstWhere(T from) {
			return null;
		};

		/**
		 * Permite modificar los primeros orders.
		 */
		public void firstOrders(T from) {
		};

	}

	public <T> Query<T> get(int firstResult, int pageCount,
			List<SortInfo> sortInfo, Map<String, String> params,
			Class<T> classOfT, QueryCustomizer<T> customizer) {
		
		if (customizer == null)
			customizer = new QueryCustomizer<T>();
		T from = from(classOfT);

		applyWhere(params, classOfT, customizer, from);
		customizer.firstOrders(from);
		if (sortInfo != null)
			addOrders(from, sortInfo, classOfT);
		Query<T> query = select(from).setFirstResult(firstResult)
				.setMaxResults(pageCount);
		return query;
	}

	private <T> void applyWhere(Map<String, String> params, Class<T> classOfT,
			QueryCustomizer<T> customizer, T from) {
		OnGoingLogicalCondition previous = customizer.firstWhere(from);

		if (params != null){
			
			for (Entry<String, String> entry : params.entrySet()) {
				
				OnGoingLogicalCondition current = getCondition(from,
						entry.getKey(), entry.getValue(), classOfT);
				
				if (previous == null) {
					previous = where(current);
				} else {
					previous = previous.and(current);
				}
				
			}
		}
	}

	public <T> Query<Long> getCount(Map<String, String> params,
			Class<T> classOfT, QueryCustomizer<T> customizer) {

		if (customizer == null)
			customizer = new QueryCustomizer<T>();

		T from = from(classOfT);
		applyWhere(params, classOfT, customizer, from);

		return select(TorpedoFunction.count(from));

	}

	protected <T> OnGoingLogicalCondition doComplexPath(T from,
			String propertyName, String compareValue, Class<?> clazz)
			throws Exception {

		Pair<Method, Object> info = getMethodAndObjectInvokeThroug(
				propertyName, clazz, from);
		return getCondition(info.getValue(), compareValue, info.getKey());

	}

	/**
	 * Este método provee una funcionalidad similar al Resolver de
	 * apache-beanutils.
	 * 
	 * <p>
	 * La cadena de nodos de un propiedad como:
	 * 
	 * <pre>
	 * ciudad.pais.nombre
	 * </pre>
	 * 
	 * Esta llena de proxies, los cuales deben ser accedidos si se quiere
	 * utilizar el proxy para realizar comparaciones utilizando torpedo.
	 * 
	 * </p>
	 * <p>
	 * Este código debe provocar el mismo resultado, que se si hiciese:
	 * 
	 * <pre>
	 * String torpedoProxyDelTipoDeNombre = ciudad.getPais().getNombre()
	 * </pre>
	 * 
	 * De esta forma, con el objeto retornado, se puede hacer lo siguiente
	 * 
	 * <pre>
	 * where(torpedoProxyDelTipoNombre).eq(lower(&quot;Paraguay&quot;));
	 * </pre>
	 * 
	 * Lo cual solo es posible, si el objeto retornado es del tipo proxy, que
	 * torpedo necesita.
	 * </p>
	 * 
	 * @param propertyName
	 *            propiedad a buscar, no debe ser nula y debe estar separada por
	 *            puntos.
	 * @param clazz
	 *            raiz de la expresión
	 * @param from
	 *            objeto del tipo <code>clazz</code> que representa el
	 *            <code>from</code> de torpedo
	 * @return par, donde el key es el getter y el valor es el objeto raiz de
	 *         ese getter.
	 * @throws Exception
	 *             excepción de reflexión
	 */
	private Pair<Method, Object> getMethodAndObjectInvokeThroug(
			String propertyName, Class<?> clazz, Object from) throws Exception {
		String[] parts = propertyName.split("\\.");
		Class<?> lastClass = clazz;
		Object lastRoot = from;
		Method getter = null;
		for (int i = 0; i < parts.length - 1; i++) {

			String s = parts[i];
			getter = getGetter(s, lastClass);
			lastClass = getter.getReturnType();
			lastRoot = getter.invoke(lastRoot);
		}

		getter = getGetter(parts[parts.length - 1], lastClass);
		return new ImmutablePair<Method, Object>(getter, lastRoot);
	}

	protected <T> OnGoingLogicalCondition doSimplePath(T from,
			String propertyName, String compareValue, Class<?> clazz)
			throws Exception {

		return getCondition(from, compareValue, getGetter(propertyName, clazz));
	}

	public void addOrders(Object from, List<SortInfo> sortInfo, Class<?> parent) {

		try {
			for (SortInfo si : sortInfo) {
				addOrder(from, si, parent);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);

		}

	}

	private void addOrder(Object from, SortInfo si, Class<?> parent)
			throws Exception {

		Pair<Method, Object> info = getMethodAndObjectInvokeThroug(
				si.getField(), parent, from);
		if (si.isAsc())
			orderBy(TorpedoFunction.asc(info.getKey().invoke(info.getValue())));
		else
			orderBy(TorpedoFunction.desc(info.getKey().invoke(info.getValue())));
	}

	/**
	 * Retorna el Getter de una propiedad especifica de una clase.
	 * 
	 * <p>
	 * TODO: simplificar el método, debería ser similar a
	 * 
	 * <pre>
	 * Method toRet = clazz.getMethod("get" + 
	 * 				propertyName.substring(0,1).toLowerCase() +
	 * 				propertyName.substring(1);
	 * toRet.setAccesible(true);
	 * return toRet;
	 * </pre>
	 * 
	 * Se podría buscar en apache-commons algún PropertyUtils que ya contenga
	 * una cache de valores.
	 * 
	 * </p>
	 * 
	 * @param propertyName
	 * @param clazz
	 * @return
	 * @throws IntrospectionException
	 */
	private Method getGetter(String propertyName, Class<?> clazz)
			throws IntrospectionException {
		BeanInfo beaninfo = Introspector.getBeanInfo(clazz);
		PropertyDescriptor[] properties = beaninfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : properties) {
			if (pd.getName().equals(propertyName))
				return pd.getReadMethod();
		}
		throw new IntrospectionException("Cant get the getter of "
				+ propertyName + " of class: " + clazz.getName());
	}

	protected <T> OnGoingLogicalCondition getCondition(T object,
			String propertyName, String compareTo, Class<T> parent) {
		try{
			if(compareTo.contains("|")){
	
				String parte1;
				String parte2;
				String parte3;
				String[] parts = compareTo.split("\\|");
				
				if(parts.length == 2){
					parte1 = parts[0].toLowerCase();
					parte2 = parts[1].toLowerCase();
					
					if (propertyName.contains(".")){
						return doComplexPath(object, propertyName, parte1, parent).or(doComplexPath(object, propertyName, parte2, parent));
							
					}else {
						return doSimplePath(object, propertyName, parte1, parent).or(doSimplePath(object, propertyName, parte2, parent));
							
					}
				} else if(parts.length == 3){
					
					parte1 = parts[0].toLowerCase();
					parte2 = parts[1].toLowerCase();
					parte3 = parts[2].toLowerCase();
						
					if (propertyName.contains(".")){
						return doComplexPath(object, propertyName, parte1, parent).or(doComplexPath(object, propertyName, parte2, parent)).
								or(doComplexPath(object, propertyName, parte3, parent));
								
					}else {
						return doSimplePath(object, propertyName, parte1, parent).or(doSimplePath(object, propertyName, parte2, parent)).
								or(doSimplePath(object, propertyName, parte3, parent));
								
					}
					
					
				}
				
			} else {
	
				if (propertyName.contains(".")){
					return doComplexPath(object, propertyName, compareTo, parent);
		
				}else {
					return doSimplePath(object, propertyName, compareTo, parent);
						
				}
			}
			
		} catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Realiza la comparación entre dos atributos utilizando los proxies de
	 * torpedo.
	 * 
	 * <p>
	 * Como en el ejemplo mostrado en {@link #getCompareValue(Class, String)},
	 * se puede utilizar esté metodo para realizar una comparación entre fechas
	 * como sigue:
	 * 
	 * <pre>
	 * if (getter.getReturnType() == Date.class) {
	 * 	OnGoingComparableCondition&lt;Date&gt; comp = condition(getter.invoke(root));
	 * 	Pair&lt;Date, Date&gt; dates = getCompareValue(getter.getReturnType(), object);
	 * 	return comp.between(dates.key(), dates.value());
	 * }
	 * </pre>
	 * 
	 * @param root
	 *            raiz de la condición actual.
	 * @param object
	 *            objeto a comparar, es un string, por que todo se serializa.
	 * @param getter
	 *            de la propiedad.
	 * @return condicion que puede ser encadenada a otra.
	 * @throws Exception
	 *             reflexión exception
	 */
	private OnGoingLogicalCondition getCondition(Object root, String object,
			Method getter) throws Exception {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String desde;
		String hasta;
		
		/*if(object.contains("|")){
			System.out.println("entro a pipe");
			String parte1;
			String parte2;
			String[] parts = object.split("\\|");
			
			if(parts.length == 2){
				parte1 = parts[0].toLowerCase();
				parte2 = parts[1].toLowerCase();
				
				System.out.println("parte 1: "+parte1);
				System.out.println("parte 2: "+parte2);
				
				if("null".equals(parte1) && !"null".equals(parte2)){
					return getCondition(root, parte2, getter).or(condition(getter.invoke(root)).isNull());
				
				} else if(!"null".equals(parte1) && "null".equals(parte2)){
					return getCondition(root, parte1, getter).or(condition(getter.invoke(root)).isNull());
				
				} else if(!"null".equals(parte1) && !"null".equals(parte2)){
					return  getCondition(root, parte1, getter).or(getCondition(root, parte2, getter));
					
				} else{
					return (OnGoingLogicalCondition) condition(getter.invoke(root)).isNull();
				}		
			}
		}*/
		
		if("null".equals(object.toLowerCase())){
			return (OnGoingLogicalCondition) condition(getter.invoke(root)).isNull();
		
		}

		// Si el campo a filtrar es de tipo cadena
		if (getter.getReturnType() == String.class) {
			OnGoingStringCondition<Function<String>> comp = (OnGoingStringCondition<Function<String>>) condition(TorpedoFunction
					.lower((String) getter.invoke(root)));
			if(root instanceof BuscarCliente )
			{
				if (isAvanzadaBusquedaCliente(getter))
				{
					return new LikeLogicalCondition(comp.like().any(object.toLowerCase()));
				}else{
					return comp.like().any(object.toLowerCase());	
				}
			}
			else
			{
				return comp.like().any(object.toLowerCase());
			}			
		}

		// Si el campo a filtrar es de tipo fecha
		if (getter.getReturnType() == Date.class) {

			if(object.startsWith("<=")){
				
				String fecha = object.substring(2);
				Date f = simpleDateFormat.parse(fecha);
					
				return (OnGoingLogicalCondition) condition((Date)getter.invoke(root)).lte(f);
							
			} else if(object.startsWith(">=")) {
				String fecha = object.substring(2);
				Date f = simpleDateFormat.parse(fecha);
					
				return (OnGoingLogicalCondition) condition((Date)getter.invoke(root)).gte(f);
			
			} else if(object.startsWith(">")) {
				String fecha = object.substring(2);
				Date f = simpleDateFormat.parse(fecha);
					
				return (OnGoingLogicalCondition) condition((Date)getter.invoke(root)).gt(f);
			
			} else if(object.startsWith("<")) {
				String fecha = object.substring(2);
				Date f = simpleDateFormat.parse(fecha);
					
				return (OnGoingLogicalCondition) condition((Date)getter.invoke(root)).lt(f);
					
			}else {
			
				String[] parts = object.split("-");
		
				if (parts.length == 2) {
					desde = parts[0]; // fecha1
					hasta = parts[1]; // fecha2
				} else {
					desde = hasta = object;
				}
		
				Calendar c = Calendar.getInstance();
				Date d1 = simpleDateFormat.parse(desde);
				Date d2 = simpleDateFormat.parse(hasta);
		
				c.setTime(d2);
				c.add(Calendar.DATE, 1);
				d2 = c.getTime();
		
				return (OnGoingLogicalCondition) condition(getter.invoke(root))
						.between(d1, d2);
			}
		}
		
		

		// para todos los demas casos (números, etc)
		return (OnGoingLogicalCondition) condition(getter.invoke(root)).eq(
				getCompareValue(getter.getReturnType(), object));
	}

	/**
	 * Metodo que retorna el valor a comprar.
	 * 
	 * <p>
	 * Esté metodo, junto con {@link #getCondition(Object, String, Method)} son
	 * los que definen como se compara un atributo, los demás métodos se centran
	 * en como obtener log getters honrando a Torpedo.
	 * </p>
	 * <p>
	 * Aquí se pueden tener convenciones especiales para ciertos tipos de
	 * atributos, por ejemplo, si queremos comparar por rango de fechas, en
	 * value debería venir (si configuramos primefaces), algo como YYYY-MM-DD a
	 * YYYY-MM-DD, entonces aquí (junto con
	 * {@link #getCondition(Object, String, Method)}) deberiamos parsear esa
	 * cadena, y retornar las dos fechas.
	 * </p>
	 * 
	 * @param classType
	 *            clase de retorno del objeto deseado
	 * @param value
	 *            valor serializado
	 * @return valor convertido.
	 */
	protected Object getCompareValue(Class<?> classType, String value) {

		if (classType == String.class)
			return value;
		if (classType == Integer.class)
			return Integer.valueOf(value);
		if (classType == BigInteger.class)
			return BigInteger.valueOf(Long.valueOf(value));
		if (classType == Long.class)
			return Long.valueOf(value);
		if (classType == Double.class)
			return Double.valueOf(value);
		if (classType.isEnum()) {
			for (Object o : classType.getEnumConstants()) {
				if (o.toString().equals(value))
					return o;
			}
		}if(classType == Date.class){
			return null;
		}
		// TODO add more types.

		return value;
	}
	
	
	/**
	 * Busqueda avanzada de cliente. 
	 * <p>Se utiliza este metodo para diferenciar
	 * los atributos de busqueda avanzada de la 
	 * busqueda normal en busqueda de cliente 
	 * </p>*/
	private Boolean isAvanzadaBusquedaCliente(Method getter){
		Pattern patron = Pattern.compile("Avanzada");
		Matcher encaja = patron.matcher(getter.getName());
		return encaja.find();
	}
}
