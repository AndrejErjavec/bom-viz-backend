package com.kolektor.traceability_viz_backend.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kolektor.traceability_viz_backend.repository.ProductRepository;
import com.kolektor.traceability_viz_backend.service.ProductService;

@Path("/")
public class ProductResource {
	
	private ProductService productService;
	
	public ProductResource() {
		productService = new ProductService();
	}
	
    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Is it working!";
    }
    
    @GET
    @Path("/product")
//    @Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=UTF-8")
    public String getProduct() {
    	return "hello";
    }
}
