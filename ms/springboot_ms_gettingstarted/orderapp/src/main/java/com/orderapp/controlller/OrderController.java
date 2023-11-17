package com.orderapp.controlller;

import java.util.Date;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.orderapp.config.RabbitMQConfig;
import com.orderapp.dto.Coupon;
import com.orderapp.dto.Customer;
import com.orderapp.dto.Order;
import com.orderapp.dto.OrderRequest;
import com.orderapp.dto.Product;
import com.orderapp.service.CouponClientService;
import com.orderapp.service.CustomerClientService;
import com.orderapp.service.ProductClientService;

@RestController
public class OrderController {

	@Autowired
	private CustomerClientService customerClientService;
	
	@Autowired
	private CouponClientService couponClientService;
	
	@Autowired
	private ProductClientService productClientService;
	

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@PostMapping(path = "orders")
	public ResponseEntity<Order> bookOrder(@RequestBody OrderRequest orderRequest) {

		Customer customer = customerClientService.getCustomer(orderRequest);

		Product product = productClientService.getProduct(orderRequest);

		Coupon coupon = couponClientService.getCoupon(orderRequest);

		double totalPrice= product.getPrice()* orderRequest.getQty();//do urself
		Order order=new Order();
		order.setId(22);
		order.setCustomer(customer);
		order.setProduct(product);
	
		order.setTotalPrice(totalPrice);
		order.setOrderDate(new Date());
		//asyn
		rabbitTemplate.convertAndSend(RabbitMQConfig.ORDER_EXCHANGE, RabbitMQConfig.ORDER_ROUTINGKEY, order);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(order);
		
	}

}







