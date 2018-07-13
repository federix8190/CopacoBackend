/**
 * 
 */
package py.com.copaco.core.backend.model;

import org.hibernate.exception.ConstraintViolationException;

import py.com.copaco.core.backend.exception.ApplicationRuntimeException;
import py.com.copaco.core.backend.exception.CheckFailException;
import py.com.copaco.core.backend.exception.NotUniqueException;
import py.com.copaco.core.backend.exception.ReferencedKeyException;

/**
 * @author Arturo Volpe
 * @version 1.0 Nov 4, 2014
 */
public class ConstraintToExceptionMapper {

	/**
	 * Si empieza con esto, se considera una violacion de unique.
	 * <p>
	 * Se lanza cuando un atributo que no es clave primaria es duplicado
	 * </p>
	 */
	public static final String UNIQUE_START = "u_";
	/**
	 * Si contiene esta cadena, se considera una violacion de unique.
	 * 
	 * <p>
	 * Se lanza cuando la clave primaria se duplica
	 * </p>
	 */
	public static final String UNIQUE_KEY = "Unique constraint";
	public static final String UNIQUE_INDEX = "Unique Index:";
	public static final String FOREING_KEY_START = "fk_";
	public static final String CHECK_START = "ch_";
	public static final String FOREING_KEY_END = "_pk";

	public ApplicationRuntimeException mapException(String constraintName,
			ConstraintViolationException exception) {

		if (exception.getMessage().contains(UNIQUE_INDEX)
				|| exception.getMessage().contains(UNIQUE_KEY)
				|| constraintName.startsWith(UNIQUE_START))
			return getUnique(constraintName, exception);
		if (constraintName.startsWith(FOREING_KEY_START))
			return getForeing(constraintName, exception);
		if (constraintName.startsWith(CHECK_START))
			return getCheck(constraintName, exception);
		if (constraintName.endsWith(FOREING_KEY_END))
			return getForeing(constraintName, exception);
		return null;
	}

	private ApplicationRuntimeException getCheck(String constraintName,
			ConstraintViolationException exception) {
		return new CheckFailException(constraintName);
	}

	private ApplicationRuntimeException getForeing(String constraintName,
			ConstraintViolationException exception) {
		return new ReferencedKeyException(constraintName);
	}

	private ApplicationRuntimeException getUnique(String constraintName,
			ConstraintViolationException exception) {
		return new NotUniqueException(constraintName);
	}

}
