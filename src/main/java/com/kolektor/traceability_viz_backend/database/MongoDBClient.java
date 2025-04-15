package com.kolektor.traceability_viz_backend.database;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoDBClient {
	
	private static final String MONGO_URI = "mongodb://localhost:27017";
	private static MongoClient instance;
	
//	private static ConnectionString connectionString = new ConnectionString(MONGO_URI);
//	private static CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
//	private static CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),pojoCodecRegistry);
//	private static MongoClientSettings clientSettings = MongoClientSettings.builder()
//            .applyConnectionString(connectionString)
//            .codecRegistry(codecRegistry)
//            .build();
	
	public static MongoClient getInstance() {
		if (instance == null) {
			try {
				instance = MongoClients.create(MONGO_URI);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
}
