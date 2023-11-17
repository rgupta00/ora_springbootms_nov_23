package com.orderapp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orderapp.dto.Coupon;
import com.orderapp.dto.Customer;
import com.orderapp.dto.OrderRequest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CouponClientService {

	@Autowired
	private RestTemplate restTemplate;

	
	@CircuitBreaker(fallbackMethod ="getCouponFallback" , name = "couponfallback")
	public Coupon getCoupon(OrderRequest orderRequest) {
		
		System.out.println("******************************************************");
		Coupon coupon = restTemplate
				.getForObject("http://COUPON-SERVICE/couponapp/coupons/" + orderRequest.getCouponCode(), Coupon.class);
		return coupon;
	}
	
	public Coupon getCouponFallback(OrderRequest orderRequest, Exception ex) {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+ex.toString());
		return new Coupon(1, "DUMMY", 2, new Date());
	}
	
	
}
