package com.kolektor.traceability_viz_backend.service;

import org.json.JSONObject;
import org.json.*;
import com.kolektor.traceability_viz_backend.database.Qdrant;
import com.kolektor.traceability_viz_backend.dto.EmbedderResponse;
import com.kolektor.traceability_viz_backend.dto.ParameterEmbed;

import io.qdrant.client.QdrantClient;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class EmbedderService {
	private QdrantClient qdrant;
	private Client httpClient;
	
	private final String EMBEDDER_API_URL = "http://hivecore.famnit.upr.si:6666/api/embed";
	
	public EmbedderService() {
		qdrant = Qdrant.getInstance();
		httpClient = ClientBuilder.newClient();
	}
	
	public List<Float> embedString(String context) {
		JSONObject body = new JSONObject();
		body.put("model", "bge-m3");
		body.put("input", context);
		body.put("stream", false);
		
		Response response = httpClient.target(EMBEDDER_API_URL)
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(body.toString(), MediaType.APPLICATION_JSON));
		
		if (response != null && response.getStatus() == 200) {
			EmbedderResponse rs = response.readEntity(EmbedderResponse.class);
			response.close();
			return rs.getEmbeddings().get(0);
			
		} else {
			System.out.println("Response failed");
			return null;
		}
	}
	
}
