package com.kolektor.traceability_viz_backend.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Operation {
	private int id;
	private String workId;
	private int companyId;
	private int operationNumber;
	private String operationName;
	private int operationOrder;
	private int workorderNumber;
	private int productNumber;
	private String productName;
	private long machineId;
	private int machineNumber;
	private String machineName;
	private int workerNumber;
	private String workerName;
	private String workStart;
	private String workEnd;
	private int operationStatus;
	private String operationTimestamp;
	private String serialNumber;
	
	private List<RawMaterial> rawMaterials;
	private List<SubProduct> products;
	private List<Parameter> parameters;
	
	public Operation() {
		super();
	}
	
	// copy constructor	
	public Operation(Operation operation) {
		this.id = operation.id;
		this.workId = operation.workId;
		this.companyId = operation.companyId;
		this.operationNumber = operation.operationNumber;
		this.operationName = operation.operationName;
		this.operationOrder = operation.operationOrder;
		this.workorderNumber = operation.workorderNumber;
		this.productNumber = operation.productNumber;
		this.productName = operation.productName;
		this.machineId = operation.machineId;
		this.machineNumber = operation.machineNumber;
		this.machineName = operation.machineName;
		this.workerNumber = operation.workerNumber;
		this.workerName = operation.workerName;
		this.workStart = operation.workStart;
		this.workEnd = operation.workEnd;
		this.operationStatus = operation.operationStatus;
		this.operationTimestamp = operation.operationTimestamp;
		this.serialNumber = operation.serialNumber;
		this.rawMaterials = operation.rawMaterials;
		this.products = operation.products;
		this.parameters = operation.parameters;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWorkId() {
		return workId;
	}
	public void setWorkId(String workId) {
		this.workId = workId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getOperationNumber() {
		return operationNumber;
	}
	public void setOperationNumber(int operationNumber) {
		this.operationNumber = operationNumber;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public int getOperationOrder() {
		return operationOrder;
	}
	public void setOperationOrder(int operationOrder) {
		this.operationOrder = operationOrder;
	}
	public int getWorkorderNumber() {
		return workorderNumber;
	}
	public void setWorkorderNumber(int workorderNumber) {
		this.workorderNumber = workorderNumber;
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
	public long getMachineId() {
		return machineId;
	}
	public void setMachineId(long machineId) {
		this.machineId = machineId;
	}
	public int getMachineNumber() {
		return machineNumber;
	}
	public void setMachineNumber(int machineNumber) {
		this.machineNumber = machineNumber;
	}
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public int getWorkerNumber() {
		return workerNumber;
	}
	public void setWorkerNumber(int workerNumber) {
		this.workerNumber = workerNumber;
	}
	public String getWorkerName() {
		return workerName;
	}
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
	public String getWorkStart() {
		return workStart;
	}
	public void setWorkStart(String workStart) {
		this.workStart = workStart;
	}
	public String getWorkEnd() {
		return workEnd;
	}
	public void setWorkEnd(String wokrEnd) {
		this.workEnd = wokrEnd;
	}
	public int getOperationStatus() {
		return operationStatus;
	}
	public void setOperationStatus(int operationStatus) {
		this.operationStatus = operationStatus;
	}
	public String getOperationTimestamp() {
		return operationTimestamp;
	}
	public void setOperationTimestamp(String operationTimestamp) {
		this.operationTimestamp = operationTimestamp;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public List<RawMaterial> getRawMaterials() {
		return rawMaterials;
	}
	public void setRawMaterials(List<RawMaterial> rawMaterials) {
		this.rawMaterials = rawMaterials;
	}
	public List<Parameter> getParameters() {
		return parameters;
	}
	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}
	public List<SubProduct> getProducts() {
		return products;
	}
	public void setProducts(List<SubProduct> products) {
		this.products = products;
	}
	
		
}
