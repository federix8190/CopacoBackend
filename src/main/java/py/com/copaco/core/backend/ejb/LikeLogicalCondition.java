package py.com.copaco.core.backend.ejb;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class LikeLogicalCondition extends LogicalCondition {

	private LogicalCondition likeLogicalCondition;

	public LikeLogicalCondition(OnGoingLogicalCondition onGoingLogicalCondition) {
		super(null, null);
		this.likeLogicalCondition = (LogicalCondition) onGoingLogicalCondition;
	}

	public <T1> OnGoingCollectionCondition<T1> and(Collection<T1> object) {
		return likeLogicalCondition.and(object);
	}

	public <T> OnGoingComparableCondition<T> and(ComparableFunction<T> function) {
		return likeLogicalCondition.and(function);
	}

	public OnGoingStringCondition<String> and(Function<String> function) {
		return likeLogicalCondition.and(function);
	}

	public OnGoingLogicalCondition and(OnGoingLogicalCondition condition) {
		return likeLogicalCondition.and(condition);
	}

	public OnGoingStringCondition<String> and(String property) {
		return likeLogicalCondition.and(property);
	}

	public <V, T extends Comparable<V>> OnGoingComparableCondition<V> and(
			T property) {
		return likeLogicalCondition.and(property);
	}

	public <T1> ValueOnGoingCondition<T1> and(T1 property) {
		return likeLogicalCondition.and(property);
	}

	/**
	 * Se cambia el metodo para que acepte caracteres especiales de busqueda
	 * 
	 */
	public String createQueryFragment(AtomicInteger incrementor) {
		String cadena = likeLogicalCondition.createQueryFragment(incrementor);

		
		cadena = cadena.trim();
		
		
		Pattern patron = Pattern.compile("lower\\(.*\\)");
		Matcher encaja = patron.matcher(cadena);
		
		Integer a, b;
		String resultado = null;
		final String STARTCONSULTA = "replace( replace( replace( replace( replace( replace(" ;
		final String ENDCONSULTA= ",'á','a'), 'é','e'),'í','i'),'ó','o'),'ú','u'),' ','')";
		final String LIKESTRING = " like ";
		final String TILDE = "'";
		boolean pos = encaja.find();

		if(pos){
			a = encaja.start();
			b = encaja.end();
			//System.out.println(a + " - " + b);
			resultado = cadena.substring(a, b);
			//tem.out.println("\n"+resultado);
			resultado = STARTCONSULTA + resultado + ENDCONSULTA + LIKESTRING; 
			//System.out.println("\n"+resultado);	
		}
		
		/**Segunda Parte del like*/
		patron = Pattern.compile("'%");
		encaja = patron.matcher(cadena);
		String segunda = null;
		Integer c; //Integer para comienzo de la cadena
		Integer d = cadena.length() - 2; // se resta menos dos para quitarle el operador final %'
		boolean posicion = encaja.find();
		if(posicion)
		{
			c = encaja.start() + 2 ; // su suma dos para quitarle el operador inicial '%
			segunda = cadena.substring(c, d);
			segunda = STARTCONSULTA +  TILDE + segunda + TILDE + ENDCONSULTA; 
			//System.out.println("\nSegunda Parte: "+ segunda);
		}
		
		resultado = resultado + segunda;

		return resultado;
	}

	public boolean equals(Object obj) {
		return likeLogicalCondition.equals(obj);
	}

	public QueryBuilder<?> getBuilder() {
		return likeLogicalCondition.getBuilder();
	}

	public List<Parameter> getParameters() {
		return likeLogicalCondition.getParameters();
	}

	public int hashCode() {
		return likeLogicalCondition.hashCode();
	}

	public <T1> OnGoingCollectionCondition<T1> or(Collection<T1> object) {
		return likeLogicalCondition.or(object);
	}

	public <T> OnGoingComparableCondition<T> or(ComparableFunction<T> function) {
		return likeLogicalCondition.or(function);
	}

	public OnGoingStringCondition<String> or(Function<String> function) {
		return likeLogicalCondition.or(function);
	}

	public OnGoingLogicalCondition or(OnGoingLogicalCondition condition) {
		return likeLogicalCondition.or(condition);
	}

	public OnGoingStringCondition<String> or(String property) {
		return likeLogicalCondition.or(property);
	}

	public <V, T extends Comparable<V>> OnGoingComparableCondition<V> or(
			T property) {
		return likeLogicalCondition.or(property);
	}

	public <T1> ValueOnGoingCondition<T1> or(T1 property) {
		return likeLogicalCondition.or(property);
	}

	public String toString() {
		return likeLogicalCondition.toString();
	}

}
