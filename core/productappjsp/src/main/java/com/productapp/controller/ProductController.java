package com.productapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.productapp.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(path = "showall")
	public ModelAndView showAll(ModelAndView mv) {
		mv.addObject("products", productService.findAll());
		mv.setViewName("products");
		return mv;
	}
	
}
