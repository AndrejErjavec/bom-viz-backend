package com.kolektor.traceability_viz_backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessingInfo {
	private String appProductCode;
	private String defaultProductName;
	private int defaultProductId;
	private int defaultCompany;
	private boolean processing;
	private boolean processedOnSecondary;
	private int lastProcessedGoodId;
	private int lastProcessedBadId;
	private long mesid;
	private int processDuration;
	private long procesTimestamp;
	private String procesDateTime;
	
	
	public String getAppProductCode() {
		return appProductCode;
	}
	public void setAppProductCode(String appProductCode) {
		this.appProductCode = appProductCode;
	}
	public String getDefaultProductName() {
		return defaultProductName;
	}
	public void setDefaultProductName(String defaultProductName) {
		this.defaultProductName = defaultProductName;
	}
	public int getDefaultProductId() {
		return defaultProductId;
	}
	public void setDefaultProductId(int defaultProductId) {
		this.defaultProductId = defaultProductId;
	}
	public int getDefaultCompany() {
		return defaultCompany;
	}
	public void setDefaultCompany(int defaultCompany) {
		this.defaultCompany = defaultCompany;
	}
	public boolean isProcessing() {
		return processing;
	}
	public void setProcessing(boolean processing) {
		this.processing = processing;
	}
	public boolean isProcessedOnSecondary() {
		return processedOnSecondary;
	}
	public void setProcessedOnSecondary(boolean processedOnSecondary) {
		this.processedOnSecondary = processedOnSecondary;
	}
	public int getLastProcessedGoodId() {
		return lastProcessedGoodId;
	}
	public void setLastProcessedGoodId(int lastProcessedGoodId) {
		this.lastProcessedGoodId = lastProcessedGoodId;
	}
	public int getLastProcessedBadId() {
		return lastProcessedBadId;
	}
	public void setLastProcessedBadId(int lastProcessedBadId) {
		this.lastProcessedBadId = lastProcessedBadId;
	}
	public long getMesid() {
		return mesid;
	}
	public void setMesid(long mesid) {
		this.mesid = mesid;
	}
	public int getProcessDuration() {
		return processDuration;
	}
	public void setProcessDuration(int processDuration) {
		this.processDuration = processDuration;
	}
	public long getProcesTimestamp() {
		return procesTimestamp;
	}
	public void setProcesTimestamp(long procesTimestamp) {
		this.procesTimestamp = procesTimestamp;
	}
	public String getProcesDateTime() {
		return procesDateTime;
	}
	public void setProcesDateTime(String procesDateTime) {
		this.procesDateTime = procesDateTime;
	}
	
	
}
