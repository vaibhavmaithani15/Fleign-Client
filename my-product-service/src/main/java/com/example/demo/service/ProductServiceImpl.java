package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductEntity;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repo.ProductRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Override
	public ProductEntity createProduct(ProductEntity productEntity) {
		// TODO Auto-generated method stub
		return productRepository.save(productEntity);
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public ProductEntity findProductById(int productId) {
		// TODO Auto-generated method stub
		Optional<ProductEntity> productEntity = productRepository.findById(productId);
		if (!productEntity.isPresent()) {
			throw new ProductNotFoundException("product with the product id: " + productId + " not found");
		}
		return productEntity.get();
	}

	@Override
	public ProductEntity updateProductById(int productId, ProductEntity productEntity) {
		// TODO Auto-generated method stub
		Optional<ProductEntity> pEntity = productRepository.findById(productId);
		if (!pEntity.isPresent()) {
			throw new ProductNotFoundException("product with the product id: " + productId + " not found");
		}

		pEntity.get().setProductName(productEntity.getProductName());
		pEntity.get().setIsAvailable(productEntity.getIsAvailable());
		pEntity.get().setProductPrice(productEntity.getProductPrice());
		pEntity.get().setProductType(productEntity.getProductType());

		return productRepository.save(pEntity.get());
	}

	@Override
	public void deleteProductById(int productId) {

		Optional<ProductEntity> pEntity = productRepository.findById(productId);
		if (!pEntity.isPresent()) {
			throw new ProductNotFoundException("product with the product id: " + productId + " not found");
		}
		productRepository.delete(pEntity.get());
		log.info("deleted");
	}

}
