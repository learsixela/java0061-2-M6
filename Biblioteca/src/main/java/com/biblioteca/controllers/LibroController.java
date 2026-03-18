package com.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.biblioteca.models.Autor;
import com.biblioteca.models.Libro;
import com.biblioteca.services.AutorService;
import com.biblioteca.services.LibroService;

@Controller
@RequestMapping("/user/libros")
public class LibroController {
	
	@Autowired
	private AutorService autorService;
	
	@Autowired
	private LibroService libroService;
	
	@RequestMapping("")
	public String inicio(Model model) {
		model.addAttribute("listaLibros",libroService.findAll());
		return "libros/index";
	}
	
	@RequestMapping("/editar")//http://localhost:8082/libro/editar?id=1
	public String editarLibro(@RequestParam(value="isbn", required = true) String id ) {
		System.out.println("El valor del id es "+ id);
		return "index";
	} 
	
	
	
	@GetMapping("/crear")
	public String crear(Model model) {
		List<Autor> autores = autorService.findAll();
		
		model.addAttribute("autores",autores );
		model.addAttribute("libro", new Libro());
		model.addAttribute("titulo", "Crear Libro");
		return "libros/form";
		
	}
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Libro libro) {
		libroService.guardar(libro);
		return "redirect:/libros";
	}
}
