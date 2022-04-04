package com.example.demo.controller;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ProductEntity;
import com.example.demo.exception.ListEmptyException;
import com.example.demo.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Slf4j
public class ProductRestController {

	private final Environment environment;
	private final ProductService productService;

	@GetMapping("/status")
	public ResponseEntity<String> getStatus() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("product service is up ");
		stringBuffer.append("and running on port: " + environment.getProperty("local.server.port"));

		// return ResponseEntity.status(HttpStatus.OK).body(stringBuffer.toString());

		// return ResponseEntity.ok(stringBuffer.toString());

		return new ResponseEntity<String>(stringBuffer.toString(), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity productEntity) {
		ProductEntity pEntity = productService.createProduct(productEntity);
		log.info("one product created {}", pEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(pEntity);
	}

	@GetMapping("/")
	public ResponseEntity<List<ProductEntity>> getAllProducts() {
		List<ProductEntity> list = productService.getAllProducts();
		if (list.isEmpty()) {
			throw new ListEmptyException("List is empty. No Product available");
		}
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{productId}")
	public ResponseEntity<ProductEntity> getProductById(@PathVariable("productId") int productId) {
		ProductEntity productEntity = productService.findProductById(productId);
		return new ResponseEntity<ProductEntity>(productEntity, HttpStatus.FOUND);

	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<ProductEntity> updateProduct(@RequestBody ProductEntity productEntity,@PathVariable("productId") int productId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(productService.updateProductById(productId, productEntity));
	}
	@DeleteMapping("/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable("productId") int productId)
	{
		productService.deleteProductById(productId);
		return ResponseEntity.status(HttpStatus.OK).body("product removed sucessfully");
	}
	
	
}
