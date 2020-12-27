package com.company.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	
	/*only For application.properties(app.name = Manish) 
	@Value("${app.name}")
	private String appName ;*/
	
	
	@RequestMapping("/hello")
	public String hello() {
		
		return "We are in HelloController " ;   //+ appName;
	}

}
