package py.com.copaco.core.backend.ejb;

import static org.torpedoquery.jpa.Torpedo.from;
import static org.torpedoquery.jpa.Torpedo.select;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * 
 * @author Arturo Volpe
 * @since 1.0
 * @version 1.0 Aug 19, 2014
 * 
 */
public abstract class BaseDAO<T, K extends Serializable> {

	@Inject
	private EntityManager entityManager;
	
	protected Class<T> classOfT;
	protected Class<K> classOfK;

	@SuppressWarnings("unchecked")
	public BaseDAO() {

		Class<?> thisClass = getClass();
		if (thisClass.getName().contains("$"))
			thisClass = thisClass.getSuperclass();
		Type superClass = thisClass.getGenericSuperclass();
		ParameterizedType type = (ParameterizedType) superClass;

		classOfT = (Class<T>) type.getActualTypeArguments()[0];
		classOfK = (Class<K>) type.getActualTypeArguments()[1];
		if (classOfT == null)
			throw new RuntimeException(
					"Cant get the parameterizedClass of claas "
							+ getClass().getName());

	}

	public List<T> getAll() {

		return select(from(getClassOfT())).list(entityManager);
	}

	public T add(T entity) {
		Objects.requireNonNull(entity, "No se puede agregar una entidad nula");

		entityManager.persist(entity);
		return entity;
	}

	public void remove(T entity) {

		entityManager.remove(entityManager.merge(entity));
	}

	public void remove(K key) {

		entityManager.remove(getById(key));
	}

	public T update(T entity) {

		return entityManager.merge(entity);
	}

	public List<T> get(int firstResult, int pageCount, List<SortInfo> sortInfo,
			Map<String, String> params) {

		return new QueryHelper().get(firstResult, pageCount, sortInfo, params,
				getClassOfT(), null).list(entityManager);
	}

	public long getCount(Map<String, String> params) {

		return new QueryHelper().getCount(params, getClassOfT(), null).get(
				entityManager);

	}

	public T getById(K key) {

		return entityManager.find(getClassOfT(), key);
	}

	public Class<T> getClassOfT() {

		return classOfT;
	}
}
