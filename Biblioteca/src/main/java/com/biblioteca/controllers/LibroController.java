package com.biblioteca.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/libro")
public class LibroController {
	@RequestMapping("")
	public String inicio() {
		return "index";
	}
	
	@RequestMapping("/editar")//http://localhost:8082/libro/editar?id=1
	public String editarLibro(@RequestParam(value="isbn", required = true) String id ) {
		System.out.println("El valor del id es "+ id);
		return "index";
	} 
	
	
	
	@GetMapping("/libro/home")
	public String home() {
		return "LibroController home";
		
	}
	
	@RequestMapping("/saludo")
	public String saludo() {
		return "index";
	}
}
