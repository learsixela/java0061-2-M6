package com.edu.manager.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.edu.manager.dto.Libro;

@RestController
@RequestMapping("/libros/api")
public class LibroApiController {
	@Autowired
	RestTemplate restTemplate;
	
	public LibroApiController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}


	
	@GetMapping
	public List<Libro> verLibros() {
		String url= "http://localhost:8080/Biblioteca-0.0.1-SNAPSHOT/api/libros";
		Libro[] librosBiblioteca = restTemplate.getForObject(url, Libro[].class);
		List<Libro> libros = Arrays.asList(librosBiblioteca);
		return libros;
	}
	
}
