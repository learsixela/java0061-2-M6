package com.edu.manager.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{id}")
	public Libro obtener(@PathVariable Long id) {
		String url= "http://localhost:8080/Biblioteca-0.0.1-SNAPSHOT/api/libros/"+id;
		Libro libroBiblioteca = restTemplate.getForObject(url, Libro.class);
		return libroBiblioteca;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Libro> obtener2(@PathVariable Long id) {
		String url= "http://localhost:8080/Biblioteca-0.0.1-SNAPSHOT/api/libros/"+id;
		Libro libroBiblioteca = restTemplate.getForObject(url, Libro.class);
		return ResponseEntity.ok(libroBiblioteca);
	}
	
	@DeleteMapping("/{id}")
	public String eliminar(@PathVariable Long id) {
		String url= "http://localhost:8080/Biblioteca-0.0.1-SNAPSHOT/api/libros/{id}";
		restTemplate.delete(url, 1);
		return "Libro eliminado";
	}
	
	@PutMapping("/{id}")
	public String actualizar(@PathVariable Long id, @RequestBody Libro libro) {
		
		String url= "http://localhost:8080/Biblioteca-0.0.1-SNAPSHOT/api/libros/"+id;
		restTemplate.put(url, libro);
		return "Libro actualizado";
		
	}
	
}
