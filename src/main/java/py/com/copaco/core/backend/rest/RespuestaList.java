package py.com.copaco.core.backend.rest;

public class RespuestaList<T> extends Respuesta<T> {

	private long count;

	public RespuestaList() {
	}

	public RespuestaList(T data, long count) {

		super(data);
		this.count = count;

	}

	protected void setCount(long count) {
		this.count = count;
	}

	public long getCount() {
		return count;
	}

}
