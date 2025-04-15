package com.kolektor.traceability_viz_backend.database;

import java.util.Arrays;
import java.util.List;

import com.kolektor.traceability_viz_backend.dto.embedding.Point;

import io.qdrant.client.QdrantClient;
import io.qdrant.client.QdrantGrpcClient;
import io.qdrant.client.grpc.Collections.Distance;
import io.qdrant.client.grpc.Collections.VectorParams;
import io.qdrant.client.grpc.Points.PointStruct;
import io.qdrant.client.grpc.Points.QueryPoints;
import io.qdrant.client.grpc.Points.ScoredPoint;
import io.qdrant.client.grpc.Points.SearchParams;
import io.qdrant.client.grpc.Points.UpdateResult;

import static io.qdrant.client.PointIdFactory.id;
import static io.qdrant.client.VectorsFactory.vectors;
import static io.qdrant.client.QueryFactory.nearest;
import static io.qdrant.client.WithPayloadSelectorFactory.enable;

public class Qdrant {
	private static QdrantClient client;
	
	public static QdrantClient getInstance() {
		if (client == null) {
			client = new QdrantClient(QdrantGrpcClient.newBuilder("localhost", 6334, false).build());
		}
		
		try {
			if (!client.collectionExistsAsync("traceability").get()) {
				client.createCollectionAsync("traceability",
				        VectorParams.newBuilder()
				        .setDistance(Distance.Cosine)
				        .setSize(1024)
				        .build())
				.get();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return client;
	}
	
	// insert point defined by a dense vector	
	public static void insertPoint(Point point) {
		try {
			UpdateResult result = client
			  .upsertAsync(
			    "traceability",
			    Arrays.asList(
			      PointStruct.newBuilder()
			      .setId(id(point.getId()))
			      .putAllPayload(point.getQdrantPayload())
			      .setVectors(
			    		  vectors(point.getVector())
			    )
			      .build()))
			  .get();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<ScoredPoint> searchSimilarPoints(List<Float> vector) {
		try {
			List<ScoredPoint> points = client.queryAsync(QueryPoints.newBuilder()
			        .setCollectionName("traceability")
			        .setQuery(nearest(vector))
			        .setParams(SearchParams.newBuilder().setExact(false).setHnswEf(128).build())
			        .setWithPayload(enable(true))
			        .setLimit(3)
			        .build()).get();
			return points;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
