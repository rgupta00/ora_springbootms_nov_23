package com.orderapp.controlller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.orderapp.dto.Coupon;
import com.orderapp.dto.Customer;
import com.orderapp.dto.Order;
import com.orderapp.dto.OrderRequest;
import com.orderapp.dto.Product;

@RestController
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;

	
	@PostMapping(path = "orders")
	public ResponseEntity<Order> bookOrder(@RequestBody OrderRequest orderRequest) {

		Customer customer = restTemplate.getForObject(
				"http://localhost:8081/customerapp/customers/" + orderRequest.getCustomerId(), Customer.class);

		Product product = restTemplate.getForObject(
				"http://localhost:8082/productapp/products/" + orderRequest.getProductId(), Product.class);

		Coupon coupon = restTemplate
				.getForObject("http://localhost:8085/couponapp/coupons/" + orderRequest.getCouponCode(), Coupon.class);

		double totalPrice= product.getPrice()* orderRequest.getQty();//do urself
		Order order=new Order();
		order.setId(22);
		order.setCustomer(customer);
		order.setProduct(product);
	
		order.setTotalPrice(totalPrice);
		order.setOrderDate(new Date());
		return ResponseEntity.status(HttpStatus.CREATED).body(order);
		
	}

}







