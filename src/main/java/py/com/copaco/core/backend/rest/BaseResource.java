/*
 * @RestBaseService.java 1.0 Aug 19, 2014 
 */
package py.com.copaco.core.backend.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import py.com.copaco.billing.entities.BaseEntity;
import py.com.copaco.billing.entities.InstanciaProceso;
import py.com.copaco.core.backend.ejb.BaseDAO;
import py.com.copaco.core.backend.ejb.SortInfo;

/**
 *
 * TODO agregar soporte a loggers
 *
 * @author Arturo Volpe
 * @since 1.0
 * @version 1.0 Aug 19, 2014
 *
 * @author Lila Perez
 * @since 2.0
 * @version 2.0 Feb 23, 2015
 */
public abstract class BaseResource<T extends BaseEntity<K>, K extends Serializable>
        implements IBaseResource<T, K> {

    @Override
    public RespuestaList<List<T>> getAll(List<String> orders,
            List<String> values, List<String> columns, int first, int pageSize) {

        if (values != null && !values.isEmpty() && columns != null && !columns.isEmpty()) {
            List<SortInfo> sort = RestUtils.deserializeSort(orders);
            Map<String, String> filters = RestUtils.joinAndCheckLists(columns,
                    values, getBaseBean().getClassOfT());
            try {
                if (getBaseBean().getClassOfT().equals(InstanciaProceso.class)) {
                    getBaseBean().getClassOfT().getDeclaredField("fechaHoraInicio");
                    sort.add(new SortInfo("fechaHoraInicio", false));
                }
                getBaseBean().getClassOfT().getDeclaredField("fechaModificacion");
                sort.add(new SortInfo("fechaModificacion", false));
            } catch (ReflectiveOperationException exception) {
                // suppressed
            }

            List<T> data = getBaseBean().get(first, pageSize, sort, filters);
            long count = getBaseBean().getCount(filters);

            return new RespuestaList<List<T>>(data, count);
        } else {
            return new RespuestaList<List<T>>(new ArrayList<T>(), 0);
        }
    }

    @Override
    public Respuesta<List<T>> getAll() {

        return new Respuesta<List<T>>(getBaseBean().getAll());
    }

    @Override
    public Respuesta<T> get(K id) {

        return new Respuesta<T>(getBaseBean().getById(id));
    }

    @Override
    public Respuesta<T> add(T entity) {

        T added = getBaseBean().add(entity);
        return new Respuesta<T>(added);
    }

    @Override
    public Respuesta<T> update(T entity) {

        return new Respuesta<T>(getBaseBean().update(entity));
    }

    @Override
    public Respuesta<T> delete(K id) {

        T toDelete = getBaseBean().getById(id);
        getBaseBean().remove(toDelete);
        return new Respuesta<T>(toDelete);
    }

    protected abstract BaseDAO<T, K> getBaseBean();
}
