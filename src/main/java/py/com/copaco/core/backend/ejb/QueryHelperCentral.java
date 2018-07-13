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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.torpedoquery.jpa.Function;
import org.torpedoquery.jpa.OnGoingLogicalCondition;
import org.torpedoquery.jpa.OnGoingStringCondition;
import org.torpedoquery.jpa.Query;
import org.torpedoquery.jpa.TorpedoFunction;

import py.com.copaco.billing.entities.Central;
import py.com.copaco.billing.entities.Distribuidor;

/**
 * 
 * @author Clara López
 * @since 1.0
 * @version 1.0 Jun 10, 2015
 * 
 */
public class QueryHelperCentral {

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
		public OnGoingLogicalCondition firstWhere(Central from) {
			return null;
		};

		/**
		 * Permite modificar los primeros orders.
		 */
		public void firstOrders(Central from) {
		};

	}

	public <T> Query<Central> get(int firstResult, int pageCount,
			List<SortInfo> sortInfo, Map<String, String> params,
			Class<T> classOfT, QueryCustomizer<T> customizer) {

		if (customizer == null)
			customizer = new QueryCustomizer<T>();		
		
		Central fromCentral = from(Central.class);		

		applyWhere(params, Central.class, customizer, fromCentral);
		customizer.firstOrders(fromCentral);
		if (sortInfo != null)
			addOrders(fromCentral, sortInfo, classOfT);
		
		
		Query<Central> query = select(fromCentral).setFirstResult(firstResult)
				.setMaxResults(pageCount);
		return query;
	}

	private <T> void applyWhere(Map<String, String> params, Class<Central> classOfT,
			QueryCustomizer<T> customizer, Central from) {
		
		OnGoingLogicalCondition previous = customizer.firstWhere(from);
		
		Distribuidor fromDistribuidor = from(Distribuidor.class);
		Query<Integer> allCodeCentrales = select(fromDistribuidor.getCentral().getCodCentral()); 		
		

		if (params.size()>0){
			for (Entry<String, String> entry : params.entrySet()) {
				OnGoingLogicalCondition current = getCondition(from,
						entry.getKey(), entry.getValue(), classOfT);
				if (previous == null) {
					previous = where(from.getCodCentral()).in(allCodeCentrales).and(current);
				} else {
					previous = previous.and(current);
				}
			}
		}else{
			previous = where(from.getCodCentral()).in(allCodeCentrales);
		}
		
	}

	public <T> Query<Long> getCount(Map<String, String> params,
			Class<T> classOfT, QueryCustomizer<T> customizer) {

		if (customizer == null)
			customizer = new QueryCustomizer<T>();
		
		Central fromCentral = from(Central.class);		
		
		applyWhere(params, Central.class, customizer, fromCentral);

		return select(TorpedoFunction.count(fromCentral));

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

		try {
			if (propertyName.contains("."))
				return doComplexPath(object, propertyName, compareTo, parent);
			return doSimplePath(object, propertyName, compareTo, parent);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
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

		// Si el campo a filtrar es de tipo cadena
		if (getter.getReturnType() == String.class) {
			OnGoingStringCondition<Function<String>> comp = (OnGoingStringCondition<Function<String>>) condition(TorpedoFunction
					.lower((String) getter.invoke(root)));
			return comp.like().any(object.toLowerCase());
		}

		// Si el campo a filtrar es de tipo fecha
		if (getter.getReturnType() == Date.class) {

			String[] parts = object.split("-");
			System.out.println("parts" + parts[0]);

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
		if (classType == Long.class)
			return Long.valueOf(value);
		if (classType == Double.class)
			return Double.valueOf(value);
		if (classType.isEnum()) {
			for (Object o : classType.getEnumConstants()) {
				if (o.toString().equals(value))
					return o;
			}
		}
		// TODO add more types.

		return value;
	}
}
