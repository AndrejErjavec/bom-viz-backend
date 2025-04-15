package com.kolektor.traceability_viz_backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.kolektor.traceability_viz_backend.dto.Operation;
import com.kolektor.traceability_viz_backend.dto.Parameter;
import com.kolektor.traceability_viz_backend.dto.ParameterEmbed;
import com.kolektor.traceability_viz_backend.dto.ProductTreeRoot;
import com.kolektor.traceability_viz_backend.dto.SubProduct;
import com.kolektor.traceability_viz_backend.repository.ProductRepository;

public class ProductService {

	private ProductRepository repository;
	
	public ProductService() {
		this.repository = new ProductRepository();
	}
	
	public ProductTreeRoot getProductTree(long productNumber) {
		return repository.getProductTree(productNumber);
	}
	
	public List<String> generateEmbedStrings(ProductTreeRoot product) {
		List<String> embedStrings = new ArrayList<>();
		
		for (Operation operation : product.getOperations()) {
			traverseOperation(operation, product.getProductNumber(), embedStrings);
		}
		
		return embedStrings;
	}
	
	private List<String> traverseOperation(Operation operation, int productNumber, List<String> embeds) {
		String operationName = operation.getOperationName();
		List<SubProduct> products = operation.getProducts();
		List<Parameter> parameters = operation.getParameters();
		for (Parameter parameter : parameters) {
			// productNumber | operationName | parameterName
			StringBuilder context = new StringBuilder();
			String parameterName = parameter.getParameterName();
			context.append(productNumber);
			context.append("|");
			context.append(operationName);
			context.append("|");
			context.append(parameterName);
			
			embeds.add(context.toString());
		}
		if (products == null) {
			return embeds;
		}
		for (SubProduct product : products) {
			traverseSubProduct(product, productNumber, embeds);
		}
		return embeds;
	}
	
	private List<String> traverseSubProduct(SubProduct product, int productNumber, List<String> embeds) {
		List<Operation> operations = product.getOperations();
		List<Operation> unregistereOperations = product.getUnregisteredOperations();
		if (operations != null) {
			for (Operation op : operations) {
				traverseOperation(op, productNumber, embeds);
			}
		}
		if (unregistereOperations != null) {
			for (Operation op : unregistereOperations) {
				traverseOperation(op, productNumber, embeds);
			}
		}
		return embeds;
	}	
	

	// ====================================================
	
	public List<ParameterEmbed> generateParameterEmbeds(ProductTreeRoot product) {
		List<ParameterEmbed> embedStrings = new ArrayList<>();
		
		for (Operation operation : product.getOperations()) {
			traverseOperation2(operation, product.getProductNumber(), embedStrings);
		}
		
		return embedStrings;
	}
	
	private List<ParameterEmbed> traverseOperation2(Operation operation, int productNumber, List<ParameterEmbed> embeds) {
		String operationName = operation.getOperationName();
		List<SubProduct> products = operation.getProducts();
		List<Parameter> parameters = operation.getParameters();
		for (Parameter parameter : parameters) {
			// productNumber | operationName | parameterName
			StringBuilder context = new StringBuilder();
			String parameterName = parameter.getParameterName();
			context.append(productNumber);
			context.append("|");
			context.append(operationName);
			context.append("|");
			context.append(parameterName);
			
			ParameterEmbed pe = new ParameterEmbed();
			pe.setContext(context.toString());
			pe.setOperationId(operation.getId());
			pe.setParameterName(parameterName);
			
			embeds.add(pe);
		}
		if (products == null) {
			return embeds;
		}
		for (SubProduct product : products) {
			traverseSubProduct2(product, productNumber, embeds);
		}
		return embeds;
	}
	
	private List<ParameterEmbed> traverseSubProduct2(SubProduct product, int productNumber, List<ParameterEmbed> embeds) {
		List<Operation> operations = product.getOperations();
		List<Operation> unregistereOperations = product.getUnregisteredOperations();
		if (operations != null) {
			for (Operation op : operations) {
				traverseOperation2(op, productNumber, embeds);
			}
		}
		if (unregistereOperations != null) {
			for (Operation op : unregistereOperations) {
				traverseOperation2(op, productNumber, embeds);
			}
		}
		return embeds;
	}
	
	
	// ============== PRUNE TREE ============== //
	
	public ProductTreeRoot pruneRootByParameters(ProductTreeRoot root, List<String> keepParamIds) {
        List<Operation> prunedOps = new ArrayList<>();
        for (Operation op : root.getOperations()) {
            Operation prunedOp = pruneOperation(op, keepParamIds);
            if (prunedOp != null) {
                prunedOps.add(prunedOp);
            }
        }
        if (!prunedOps.isEmpty()) {
        	ProductTreeRoot newRoot = new ProductTreeRoot(root);
            newRoot.setOperations(prunedOps);
            return newRoot;
        }
        return null;
    }

    private Operation pruneOperation(Operation op, List<String> keepParamIds) {
        // Filter parameters
        List<Parameter> filteredParams = op.getParameters().stream()
            .filter(p -> keepParamIds.contains(p.getParameterName()))
            .collect(Collectors.toList());

        // Recursively prune subproducts
        List<SubProduct> prunedProducts = new ArrayList<>();
        for (SubProduct sp : op.getProducts()) {
        	SubProduct prunedSp = pruneSubproduct(sp, keepParamIds);
            if (prunedSp != null) {
                prunedProducts.add(prunedSp);
            }
        }

        // Keep this operation if it has relevant parameters or pruned subproducts
        boolean keep = !filteredParams.isEmpty() || !prunedProducts.isEmpty();
        if (keep) {
            Operation newOp = new Operation(op);
            newOp.setParameters(filteredParams);
            newOp.setProducts(prunedProducts);
            newOp.setRawMaterials(new ArrayList<>(op.getRawMaterials()));
            return newOp;
        }
        return null;
    }

    private SubProduct pruneSubproduct(SubProduct sp, List<String> keepParamIds) {
        List<Operation> prunedOps = new ArrayList<>();
        for (Operation op : sp.getOperations()) {
            Operation prunedOp = pruneOperation(op, keepParamIds);
            if (prunedOp != null) {
                prunedOps.add(prunedOp);
            }
        }

        if (!prunedOps.isEmpty()) {
        	SubProduct newSp = new SubProduct();
            newSp.setOpearations(prunedOps);
            return newSp;
        }
        return null;
    }
	
	
}
