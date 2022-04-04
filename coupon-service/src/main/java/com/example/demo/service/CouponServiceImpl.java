package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Coupon;
import com.example.demo.repo.CouponRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CouponServiceImpl implements CouponService {
	
	private final CouponRepo couponRepo;
	

	@Override
	public Coupon findCouponByCode(String code) {
		// TODO Auto-generated method stub
		return couponRepo.findByCode(code);
	}

}
