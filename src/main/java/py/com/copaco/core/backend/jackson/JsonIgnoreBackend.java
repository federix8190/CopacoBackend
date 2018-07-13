/**
 * 
 */
package py.com.copaco.core.backend.jackson;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.codehaus.jackson.annotate.JacksonAnnotation;

/**
 * @author Mirta Gonzalez
 * @since 2.0
 * @version 2.0 02/09/2014
 */
@Target({ ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface JsonIgnoreBackend {

	boolean value() default true;
}
