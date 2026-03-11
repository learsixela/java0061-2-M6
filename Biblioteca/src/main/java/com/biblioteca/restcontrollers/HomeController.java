package com.biblioteca.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {
	
	@RequestMapping("")//http://localhost:8082/api
	public String api() {
		return "Hola Api";
	}
	
	//http://localhost:8082/api/home
	@RequestMapping("/home")
	public String home() {
		return "RestController home";
		
	}
	//http://localhost:8082/api/casa
	@RequestMapping(value = "/casa",method = RequestMethod.GET)
	public String casa() {
		return "RestController casa";
	}
	//http://localhost:8082/api/hola
	@GetMapping("/hola")
	public String hola() {
		return "Api Hola mundo !!";
	}

}
