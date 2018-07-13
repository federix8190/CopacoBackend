package py.com.copaco.core.backend.hibernate;

import org.hibernate.dialect.InformixDialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

/**
 * 
 * @author Adolfo Martinez
 * @since 1.0
 * @version 1.0 25/04/2014
 * 
 *          Fuente: http://www.iiug.org/opensource/files/InformixDialect.java
 * 
 */
public class InformixDialect2 extends InformixDialect {

	public InformixDialect2() {
		super();
		registerFunction("distanciageo", new StandardSQLFunction("distanciageo", StandardBasicTypes.BIG_DECIMAL));

	}

	@Override
	public boolean supportsLimitOffset() {
		return true;
	}

	@Override
	public String getLimitString(String query, int offset, int limit) {
		/*
		 * SQL Syntax: SELECT FIRST <limit> ... SELECT SKIP <offset> FIRST
		 * <limit> ...
		 */

		if (offset < 0 || limit < 0) {
			throw new IllegalArgumentException(
					"Cannot perform limit query with negative limit and/or offset value(s)");
		}

		StringBuffer limitQuery = new StringBuffer(query.length() + 10);
		limitQuery.append(query);
		int indexOfEndOfSelect = query.toLowerCase().indexOf("select") + 6;

		if (offset == 0) {
			limitQuery.insert(indexOfEndOfSelect, " first " + limit);
		} else {
			limitQuery.insert(indexOfEndOfSelect, " skip " + offset + " first "
					+ limit);
		}
		return limitQuery.toString();
	}

}
