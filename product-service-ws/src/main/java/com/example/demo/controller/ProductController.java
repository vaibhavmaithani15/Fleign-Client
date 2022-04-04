package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.proxy.CouponClient;
import com.example.demo.proxy.CouponProxy;
import com.example.demo.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ProductController {
	
	private final ProductService productService;
	private CouponClient couponClient;
	@PostMapping("/products")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Product createProduct(@RequestBody Product product)
	{
		CouponProxy couponProxy=couponClient.getCouponBycode(product.getCouponCode());
		product.setProdoctPrice(product.getProdoctPrice().subtract(couponProxy.getDiscount()));
		productService.createProduct(product);
		return product;
	}

}
