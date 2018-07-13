package py.com.copaco.core.backend.exception;

import lombok.Getter;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeInfo.As;

@javax.ejb.ApplicationException(rollback = true)
@JsonIgnoreProperties(value = { "suppressed", "stackTrace", "cause" }, ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property = "class")
public class ApplicationException extends Exception {

	private static final long serialVersionUID = 4183357516385092326L;

	@Getter
	@Setter
	private int codigoError = 500;

	@Getter
	@Setter
	private String message;

	public ApplicationException() {

		this("");
	}

	public ApplicationException(String message) {

		this(message, null);
	}

	public ApplicationException(Throwable cause) {

		this("", cause);
	}

	public ApplicationException(String message, Throwable cause) {

		super(message, cause);
		this.message = message;
	}

	@Override
	public String getLocalizedMessage() {

		return message;
	}

}
