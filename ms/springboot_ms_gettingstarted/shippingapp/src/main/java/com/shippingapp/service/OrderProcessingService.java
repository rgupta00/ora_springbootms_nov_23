package com.shippingapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.shippingapp.config.RabbitMQConfig;
import com.shippingapp.dto.Order;

@Service
public class OrderProcessingService {

	private Logger logger=LoggerFactory.getLogger(OrderProcessingService.class);
	
	@RabbitListener(queues = RabbitMQConfig.ORDER_QUEUE)
	public void processOrder(Order order ) {
		System.out.println("-----------------------");
		logger.info("data:"+order);
	}
}
