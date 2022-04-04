package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ProductEntity;

public interface ProductService {

	public ProductEntity createProduct(ProductEntity productEntity);

	public List<ProductEntity> getAllProducts();

	public ProductEntity findProductById(int productId);
	
	public ProductEntity updateProductById(int productId,ProductEntity productEntity);
	
	public void deleteProductById(int productId);

}
