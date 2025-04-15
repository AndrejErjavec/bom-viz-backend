package com.kolektor.traceability_viz_backend.dto;

import java.util.List;

public class EmbedderResponse {
	private String model;
	private List<List<Float>> embeddings;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public List<List<Float>> getEmbeddings() {
		return embeddings;
	}
	public void setEmbeddings(List<List<Float>> embeddings) {
		this.embeddings = embeddings;
	}
	
}
