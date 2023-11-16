package com.bankapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	//@RequestParam vs @PathVariable
	
	//@RequestParam
	//http://localhost:8080/hello2?name=kapil&address=delhi
	@GetMapping(path = "hello2")
	public String hello2(@RequestParam String name,@RequestParam String address) {
		return "hello champ "+ name+" : "+address;
	}
	
	//@Pathvaraible
	//http://localhost:8080/hello/kapil/delhi
	@GetMapping(path = "hello/{name}/{address}")
	public String hello(@PathVariable String name,@PathVariable String address) {
		return "hello champ "+ name+" : "+address;
	}
}
