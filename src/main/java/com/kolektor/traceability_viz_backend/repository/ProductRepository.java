package com.kolektor.traceability_viz_backend.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kolektor.traceability_viz_backend.database.MongoDBClient;
import com.kolektor.traceability_viz_backend.dto.ProductFlat;
import com.kolektor.traceability_viz_backend.dto.ProductTreeRoot;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;


import org.bson.Document;

public class ProductRepository {
	private MongoClient client;
	private MongoDatabase db; 
	private final ObjectMapper mapper = new ObjectMapper();
	
	public ProductRepository() {
		client = MongoDBClient.getInstance();
		db = client.getDatabase("traceability");
	}
	
	
	public ProductTreeRoot getProductTree(long productNumber) {
		try {
			MongoCollection<Document> collection = db.getCollection("data_nested");
			Document product = collection.find(eq("productNumber", productNumber)).first();
			if (product == null) {
				System.out.println("no product found");
				return null;
			}
			ProductTreeRoot tree = mapper.readValue(product.toJson(), ProductTreeRoot.class);
			return tree;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ProductFlat getProductFlat(long productNumber) {
		try {
			MongoCollection<Document> collection = db.getCollection("data_flat");
			Document product = collection.find(eq("productNumber", productNumber)).first();
			if (product == null) {
				System.out.println("no product found");
				return null;
			}
			ProductFlat productFlat = mapper.readValue(product.toJson(), ProductFlat.class);
			return productFlat;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
