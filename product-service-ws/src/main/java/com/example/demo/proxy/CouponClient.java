package com.example.demo.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COUPON-SERVICE-WS")
public interface CouponClient {
	@GetMapping("/coupons/{code}")
	public CouponProxy getCouponBycode(@PathVariable("code") String code);

}
