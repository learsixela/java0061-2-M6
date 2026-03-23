package com.biblioteca.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.models.Libro;
import com.biblioteca.services.LibroService;

@RestController
@RequestMapping("/api/libros")
public class LibroRestController {

	@Autowired
	private LibroService libroService;
	
	@GetMapping()
	public List<Libro> obtenerTodos(){
		
		return libroService.findAll();
	}
	
}
