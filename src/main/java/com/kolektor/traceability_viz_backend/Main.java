package com.kolektor.traceability_viz_backend;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kolektor.traceability_viz_backend.database.Qdrant;
import com.kolektor.traceability_viz_backend.dto.ParameterEmbed;
import com.kolektor.traceability_viz_backend.dto.ProductTreeRoot;
import com.kolektor.traceability_viz_backend.dto.embedding.Point;
import com.kolektor.traceability_viz_backend.repository.ProductRepository;
import com.kolektor.traceability_viz_backend.service.EmbedderService;
import com.kolektor.traceability_viz_backend.service.ProductService;

import io.qdrant.client.QdrantClient;
import io.qdrant.client.grpc.Points.ScoredPoint;

public class Main {
	public static void main(String[] args) throws IOException {
		EmbedderService es = new EmbedderService();
		ProductService ps = new ProductService();
		ProductRepository productRepository = new ProductRepository();
		QdrantClient qdrant = new Qdrant().getInstance();
		
		String queryString = "števec ciklusov pri obrizgavanju statorja";
		
		long productNumber = 1120799;
//		
		ProductTreeRoot product = productRepository.getProductTree(productNumber);
//		
//		List<ParameterEmbed> embeds = ps.generateParameterEmbeds(product);
//		
//		long i = 1;
//		for (ParameterEmbed embed : embeds) {
//			List<Float> embedding = es.embedString(embed.getContext());
//			
//			Point point = new Point();
//			Map<String, Object> payload = new HashMap<>();
//			payload.put("embed", embed.getContext());
//			payload.put("operationId", embed.getOperationId());
//			payload.put("parameterName", embed.getParameterName());
//			point.setPayload(payload);
//			point.setVector(embedding);
//			
//			Qdrant.insertPoint(point);
//		}
		
		
		List<Float> vector = es.embedString(queryString);
		List<ScoredPoint> result = Qdrant.searchSimilarPoints(vector);
		List<String> parameterNames = result.stream().map(point -> {
			return point.getPayloadMap().get("parameterName").getStringValue();
		}).collect(Collectors.toList());
		
//		System.out.println(parameterNames);
		
		ProductTreeRoot filteredTree = ps.pruneRootByParameters(product, parameterNames);
		writeJson(filteredTree, "filtered.json");
	}
	
	public static void writeJson(Object object, String path) throws IOException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(object);
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
	    writer.write(json);
	    writer.close();
	}
}
