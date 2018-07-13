package py.com.copaco.core.backend.rest;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeInfo.As;
import org.codehaus.jackson.annotate.JsonTypeInfo.Id;

public class Respuesta<T> {

	@JsonTypeInfo(use = Id.CLASS, include = As.PROPERTY, property = "class")
	private T data;

	public Respuesta() {

	}

	public Respuesta(T data) {

		this.data = data;
	}

	public T getData() {

		return data;
	}

	public void setData(T data) {

		this.data = data;
	}

}
