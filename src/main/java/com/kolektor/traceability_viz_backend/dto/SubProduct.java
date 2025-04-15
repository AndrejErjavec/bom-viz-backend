package com.kolektor.traceability_viz_backend.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubProduct {
	private int workOrderId;
	private int companyId;
	private int productNumber;
	private String productName;
	private String productSerialNumber;
	private String lastOperationDateTime;
	
	private List<Operation> operations;
	private List<Operation> unregisteredOperations;
	
	public SubProduct() {
		super();
	}
	
	
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
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOpearations(List<Operation> opearations) {
		this.operations = opearations;
	}
	public List<Operation> getUnregisteredOperations() {
		return unregisteredOperations;
	}
	public void setUnregisteredOperations(List<Operation> unregisteredOperations) {
		this.unregisteredOperations = unregisteredOperations;
	}
	
	
	
}
