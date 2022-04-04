package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Coupon;
import com.example.demo.service.CouponService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CouponController {
	
	private final CouponService couponService;
	@GetMapping("/coupons/{code}")
	@ResponseStatus(value = HttpStatus.OK)
	public Coupon getCouponByCode(@PathVariable("code") String code)
	{
		return couponService.findCouponByCode(code);
	}

}
