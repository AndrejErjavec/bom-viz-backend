package com.kolektor.traceability_viz_backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RawMaterial {
	private String barcode;
	private int materialId;
	private String materialName;
	private String sapBatch;
	private String qualityBatch;
	private String supplierBatch;
	private String supplierId;
	
	public RawMaterial() {
		super();
	}
	
	
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public int getMaterialId() {
		return materialId;
	}
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getSapBatch() {
		return sapBatch;
	}
	public void setSapBatch(String sapBatch) {
		this.sapBatch = sapBatch;
	}
	public String getQualityBatch() {
		return qualityBatch;
	}
	public void setQualityBatch(String qualityBatch) {
		this.qualityBatch = qualityBatch;
	}
	public String getSupplierBatch() {
		return supplierBatch;
	}
	public void setSupplierBatch(String supplierBatch) {
		this.supplierBatch = supplierBatch;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	
}
