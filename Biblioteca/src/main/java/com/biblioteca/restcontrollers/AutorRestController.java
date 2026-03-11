package com.biblioteca.restcontrollers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.models.Autor;
import com.biblioteca.repositories.AutorRepository;

@RestController
@RequestMapping("/api/autores")
public class AutorRestController {
	//inyeccion de dependencia directa desde Repository
	
	private final AutorRepository ar ;
	public AutorRestController(AutorRepository autorRepository) {
		this.ar = autorRepository;
	}
	
	@GetMapping
	public List<Autor> mostrarTodos() {
		List<Autor> listaAutores = ar.findAll();
		return listaAutores;
	}
}
