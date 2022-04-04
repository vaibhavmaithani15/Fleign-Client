package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.ProductType;
import com.example.demo.repo.ProductRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class MyProductServiceApplication implements CommandLineRunner {

	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		productRepository.save(new ProductEntity(1, "Book", 2.0, ProductType.DAILY_NEEDS, true));
		productRepository.save(new ProductEntity(2, "Book1", 3.0, ProductType.DAILY_NEEDS, true));
		productRepository.save(new ProductEntity(3, "Book2", 4.0, ProductType.DAILY_NEEDS, true));
		productRepository.save(new ProductEntity(4, "Book4", 5.0, ProductType.DAILY_NEEDS, true));

	}

}
