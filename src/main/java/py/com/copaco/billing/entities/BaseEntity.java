/*
 * @BaseEntity.java 1.0 Sep 2, 2014
 * 
 */
package py.com.copaco.billing.entities;

import java.io.Serializable;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeInfo.As;

/**
 * 
 * @author Arturo Volpe
 * @since 1.0
 * @version 1.0 Sep 2, 2014
 * 
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property = "class")
public abstract class BaseEntity<T> implements Serializable {

	private static final long serialVersionUID = -55665915706744066L;
	private Map<String,Object> workFlowOutput;
	private Long taskId;
	
	private Integer rowIndex;

	/**
	 * Retorna el identificador de esta entidad.
	 * 
	 * @return
	 */
	@JsonIgnore
	public abstract T getId();

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		T id = getId();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result += getClass().hashCode();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		/**
		 * Si es la misma referencia necesariamente es igual.
		 */
		if (this == obj) {
			return true;
		}

		/**
		 * Nos aseguramos que sea asignable desde la clase actual, esto
		 * significa que es una subclase o de la misma clase.
		 */
		if (obj.getClass().isAssignableFrom(getClass())) {
			BaseEntity<T> other = (BaseEntity<T>) obj;
			T id = getId();
			T ot = other.getId();
			if (id == null) {
				return ot == null;
			} else {
				return id.equals(ot);
			}

		}

		return false;
	}

	@Override
	public String toString() {
		return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	}

	public Map<String, Object> getWorkFlowOutput() {
		return workFlowOutput;
	}

	public void setWorkFlowOutput(Map<String, Object> workFlowOutput) {
		this.workFlowOutput = workFlowOutput;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	
	public Integer getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(Integer rowIndex) {
		this.rowIndex = rowIndex;
	}
	
}
