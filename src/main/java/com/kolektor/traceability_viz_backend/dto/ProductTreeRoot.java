package com.kolektor.traceability_viz_backend.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductTreeRoot {
	private int workOrderId;
	private int companyId;
	private int productNumber;
	private String productName;
	private String productSerialNumber;
	private String lastOperationDateTime;
	private String productTag;
	private long lastOperationTimeStamp;
	private boolean productStatus;
	
	private List<Operation> operations;
	private List<Operation> unregisteredOperations;
	private ProcessingInfo processingInfo;
	
	public ProductTreeRoot() {
		super();
	}
	
	public ProductTreeRoot(ProductTreeRoot root) {
		super();
		this.workOrderId = root.workOrderId;
		this.companyId = root.companyId;
		this.productNumber = root.productNumber;
		this.productName = root.productName;
		this.productSerialNumber = root.productSerialNumber;
		this.lastOperationDateTime = root.lastOperationDateTime;
		this.productTag = root.productTag;
		this.lastOperationTimeStamp = root.lastOperationTimeStamp;
		this.productStatus = root.productStatus;
		this.operations = root.operations;
		this.unregisteredOperations = root.unregisteredOperations;
		this.processingInfo = root.processingInfo;
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
	public String getProductTag() {
		return productTag;
	}
	public void setProductTag(String productTag) {
		this.productTag = productTag;
	}
	public long getLastOperationTimeStamp() {
		return lastOperationTimeStamp;
	}
	public void setLastOperationTimeStamp(long lastOperationTimeStamp) {
		this.lastOperationTimeStamp = lastOperationTimeStamp;
	}
	public boolean isProductStatus() {
		return productStatus;
	}
	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public List<Operation> getUnregisteredOperations() {
		return unregisteredOperations;
	}
	public void setUnregisteredOperations(List<Operation> unregisteredOperations) {
		this.unregisteredOperations = unregisteredOperations;
	}
	public ProcessingInfo getProcessingInfo() {
		return processingInfo;
	}
	public void setProcessingInfo(ProcessingInfo processingInfo) {
		this.processingInfo = processingInfo;
	}
	
	
}
