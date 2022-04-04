package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepo;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepo productRepo;
	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

}
