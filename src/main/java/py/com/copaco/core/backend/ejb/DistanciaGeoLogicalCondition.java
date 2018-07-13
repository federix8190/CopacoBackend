package py.com.copaco.core.backend.ejb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.torpedoquery.core.QueryBuilder;
import org.torpedoquery.jpa.ComparableFunction;
import org.torpedoquery.jpa.Function;
import org.torpedoquery.jpa.OnGoingCollectionCondition;
import org.torpedoquery.jpa.OnGoingComparableCondition;
import org.torpedoquery.jpa.OnGoingLogicalCondition;
import org.torpedoquery.jpa.OnGoingStringCondition;
import org.torpedoquery.jpa.ValueOnGoingCondition;
import org.torpedoquery.jpa.internal.Parameter;
import org.torpedoquery.jpa.internal.conditions.LogicalCondition;

import static org.torpedoquery.jpa.Torpedo.*;
import py.com.copaco.billing.entities.BuscarCliente;

public class DistanciaGeoLogicalCondition extends LogicalCondition {

    private BigDecimal latitud;
    private BigDecimal longitud;
    private LogicalCondition logicalCondition;

    public DistanciaGeoLogicalCondition(BigDecimal latitud, BigDecimal longitud, BuscarCliente buscarCliente) {
        super(null, null);
        this.latitud = latitud;
        this.longitud = longitud;
        logicalCondition = (LogicalCondition) ((OnGoingStringCondition) condition(buscarCliente.getNumeroDocumento())).eq("1");
    }

    public String createQueryFragment(AtomicInteger incrementor) {
        return "distanciageo(" + latitud + "," + longitud
                + ",buscarCliente_0.latitud,buscarCliente_0.longitud)<200";
    }

    public <T1> OnGoingCollectionCondition<T1> and(Collection<T1> object) {
        return logicalCondition.and(object);
    }

    public <T> OnGoingComparableCondition<T> and(ComparableFunction<T> function) {
        return logicalCondition.and(function);
    }

    public OnGoingStringCondition<String> and(Function<String> function) {
        return logicalCondition.and(function);
    }

    public OnGoingLogicalCondition and(OnGoingLogicalCondition condition) {
        return logicalCondition.and(condition);
    }

    public OnGoingStringCondition<String> and(String property) {
        return logicalCondition.and(property);
    }

    public <V, T extends Comparable<V>> OnGoingComparableCondition<V> and(
            T property) {
        return logicalCondition.and(property);
    }

    public <T1> ValueOnGoingCondition<T1> and(T1 property) {
        return logicalCondition.and(property);
    }

    public boolean equals(Object obj) {
        return logicalCondition.equals(obj);
    }

    public QueryBuilder<?> getBuilder() {
        return logicalCondition.getBuilder();
    }

    public List<Parameter> getParameters() {
        return new ArrayList();
    }

    public int hashCode() {
        return logicalCondition.hashCode();
    }

    public <T1> OnGoingCollectionCondition<T1> or(Collection<T1> object) {
        return logicalCondition.or(object);
    }

    public <T> OnGoingComparableCondition<T> or(ComparableFunction<T> function) {
        return logicalCondition.or(function);
    }

    public OnGoingStringCondition<String> or(Function<String> function) {
        return logicalCondition.or(function);
    }

    public OnGoingLogicalCondition or(OnGoingLogicalCondition condition) {
        return logicalCondition.or(condition);
    }

    public OnGoingStringCondition<String> or(String property) {
        return logicalCondition.or(property);
    }

    public <V, T extends Comparable<V>> OnGoingComparableCondition<V> or(
            T property) {
        return logicalCondition.or(property);
    }

    public <T1> ValueOnGoingCondition<T1> or(T1 property) {
        return logicalCondition.or(property);
    }

    public String toString() {
        return logicalCondition.toString();
    }

}
