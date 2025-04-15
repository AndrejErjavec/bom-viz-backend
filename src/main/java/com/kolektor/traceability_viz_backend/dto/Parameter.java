package com.kolektor.traceability_viz_backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Parameter {
	private Object value;
	private String parameterName;
	private Object limitLow;
	private Object limitHigh;
	private String parameterDescription;
	private String machineId;
	private String unit;
	private String scope;
	private String dataType;
	
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public Object getLimitLow() {
		return limitLow;
	}

	public void setLimitLow(Object limitLow) {
		this.limitLow = limitLow;
	}

	public Object getLimitHigh() {
		return limitHigh;
	}

	public void setLimitHigh(Object limitHigh) {
		this.limitHigh = limitHigh;
	}

	public String getParameterDescription() {
		return parameterDescription;
	}

	public void setParameterdescription(String parameterdescription) {
		this.parameterDescription = parameterdescription;
	}

	public String getMachineId() {
		return machineId;
	}

	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
	
}
