package py.com.copaco.core.backend.exception;

import lombok.Getter;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeInfo.As;

@javax.ejb.ApplicationException(rollback = true)
@JsonIgnoreProperties(value = { "suppressed", "stackTrace", "cause" }, ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property = "class")
public class ApplicationRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 4183357516385092326L;

	@Getter
	@Setter
	private int codigoError = 500;

	@Getter
	@Setter
	private String message;

	public ApplicationRuntimeException() {

		this("");
	}

	public ApplicationRuntimeException(String message) {

		this(message, null);
	}

	public ApplicationRuntimeException(Throwable cause) {

		this("", cause);
	}

	public ApplicationRuntimeException(String message, Throwable cause) {

		super(message, cause);
		this.message = message;
	}

	@Override
	public String getLocalizedMessage() {
		return message;
	}

}
