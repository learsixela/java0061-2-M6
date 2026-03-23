package com.biblioteca.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//http://localhost:8082/api/libros/1
	@GetMapping("/{id}")
	public Libro obtenerLibro(@PathVariable Long id) {
		Libro libro = libroService.findById(id);
		return libro;
	}
	
	@PutMapping("/{id}")
	public String actualizarLibro(@PathVariable Long id) {
		Libro libro = libroService.findById(id);
		//llenar los datos
		libro.setTitulo("");
		libro.setAutor(null);
		libro.setIsbn(null);
		
		libroService.save(libro);
		return "";
	}
	
	@DeleteMapping("/{id}")
	public String eliminarLibro(@PathVariable Long id) {
		libroService.delete(id);
		return "Libro eliminado";
	}
}
