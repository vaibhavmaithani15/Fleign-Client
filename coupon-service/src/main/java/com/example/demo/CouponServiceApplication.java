package com.example.demo;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.demo.model.Coupon;
import com.example.demo.repo.CouponRepo;

import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableEurekaClient
@AllArgsConstructor
public class CouponServiceApplication {
private final CouponRepo couponRepo;
	public static void main(String[] args) {
		SpringApplication.run(CouponServiceApplication.class, args);
	}
	
	@PostConstruct
	public void initData()
	{
		List<Coupon> list=Stream.of(
				new Coupon(1L, "code-1", new BigDecimal(10.0), "01/05/22"),
				new Coupon(2L, "code-2", new BigDecimal(1.0), "01/05/22"),
				new Coupon(3L, "code-3", new BigDecimal(20.0), "01/05/22"),
				new Coupon(4L, "code-4", new BigDecimal(5.9), "01/05/22")
				).collect(Collectors.toList());
		couponRepo.saveAll(list);
	}

}
