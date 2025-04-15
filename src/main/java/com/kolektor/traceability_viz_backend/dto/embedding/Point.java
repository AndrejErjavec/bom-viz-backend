package com.kolektor.traceability_viz_backend.dto.embedding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static io.qdrant.client.ValueFactory.value;
import io.qdrant.client.grpc.JsonWithInt.Value;

public class Point {
	private final UUID id;
	private List<Float> vector;
	private Map<String, Object> payload;
	
	public Point() {
		this.id = UUID.randomUUID();
	}
	
	
	public UUID getId() {
		return id;
	}

	public List<Float> getVector() {
		return vector;
	}
	public void setVector(List<Float> vector) {
		this.vector = vector;
	}
	public Map<String, Object> getPayload() {
		return payload;
	}
	public void setPayload(Map<String, Object> payload) {
		this.payload = payload;
	}
	
	public Map<String, Value> getQdrantPayload() {
		Map<String, Value> qdrantPayload = new HashMap<>();
		
		for (Map.Entry<String, Object> entry : payload.entrySet()) {
			String key = entry.getKey();
            Object value = entry.getValue();
            
            if (value instanceof String) {
                qdrantPayload.put(key, value((String) value));
            } else if (value instanceof Integer) {
                qdrantPayload.put(key, value((Integer) value));
            } else if (value instanceof Long) {
                qdrantPayload.put(key, value((Long) value));
            } else if (value instanceof Float) {
                qdrantPayload.put(key, value((Float) value));
            } else if (value instanceof Double) {
                qdrantPayload.put(key, value((Double) value));
            } else if (value instanceof Boolean) {
                qdrantPayload.put(key, value((Boolean) value));
            } else {
            	throw new IllegalArgumentException("Unsupported payload type for key: " + key);
            }
		}
		return qdrantPayload;
	}
	
}
