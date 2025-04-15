package com.kolektor.traceability_viz_backend.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductFlat {
	private int workOrderId;
	private int companyId;
	private int productNumber;
	private String productName;
	private String productSerialNumber;
	private String lastOperationDateTime;
	private List<Parameter> parameters;
	private List<RawMaterial> materials;
	private List<Operation> operations;
	
	
	public int getWorkOrderId() {
		return workOrderId;
	}

	public void setWorkOrderId(int workOrderId) {
		this.workOrderId = workOrderId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductSerialNumber() {
		return productSerialNumber;
	}

	public void setProductSerialNumber(String productSerialNumber) {
		this.productSerialNumber = productSerialNumber;
	}

	public String getLastOperationDateTime() {
		return lastOperationDateTime;
	}

	public void setLastOperationDateTime(String lastOperationDateTime) {
		this.lastOperationDateTime = lastOperationDateTime;
	}
	
	public List<Parameter> getParameters() {
		return parameters;
	}
	
	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}
	
	public List<RawMaterial> getMaterials() {
		return materials;
	}
	
	public void setMaterials(List<RawMaterial> materials) {
		this.materials = materials;
	}
	
	public List<Operation> getOperations() {
		return operations;
	}
	
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
}