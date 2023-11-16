package com.productapp.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class InvalidateCachedScheduleService {
	
	private Logger logger=LoggerFactory.getLogger(InvalidateCachedScheduleService.class);
	@Autowired
	private ProductService productService;
	@Scheduled(cron = "0/20 * * * * *")
	public void schedule() {
		System.out.println("*************************************************");
		logger.info("cahche is invalidated :"+LocalDateTime.now());
		productService.invlidateCache();
	}

}
