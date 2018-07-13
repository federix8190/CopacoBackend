/**
 * 
 */
package py.com.copaco.core.backend.jackson;

import java.lang.annotation.Annotation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.jboss.resteasy.spi.StringParameterUnmarshaller;
import org.jboss.resteasy.util.FindAnnotation;

/**
 * @author Eduardo Mendez
 * 
 */
public class DateFormatter implements StringParameterUnmarshaller<Date> {

	private SimpleDateFormat formatter;

	public void setAnnotations(Annotation[] annotations) {
		DateFormat format = FindAnnotation.findAnnotation(annotations,
				DateFormat.class);
		formatter = new SimpleDateFormat(format.value(), Locale.ENGLISH);
	}

	public Date fromString(String str) {
		try {
			return formatter.parse(str);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
