package py.com.copaco.core.backend.jackson;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.jboss.resteasy.annotations.StringParameterUnmarshallerBinder;

/**
 * 
 * @author Eduardo Mendez
 * 
 */
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@StringParameterUnmarshallerBinder(DateFormatter.class)
public @interface DateFormat {

	String value() default "EEE MMM dd kk:mm:ss z yyyy";
}
