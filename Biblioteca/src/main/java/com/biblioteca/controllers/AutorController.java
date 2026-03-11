package com.biblioteca.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biblioteca.models.Autor;
import com.biblioteca.services.AutorService;

@Controller
@RequestMapping("/autores")
public class AutorController {
	//inyeccion de dependencia
	//@Autowired
	//private AutorService auService;
	
	private final AutorService autorService2;
	public AutorController(AutorService autorService) {
		this.autorService2 = autorService;
	}
	
	@GetMapping
	public String mostrarTodos(Model model) {
		List<Autor> listaAutores = autorService2.findAll();
		//enviar la informacion a una vista
		model.addAttribute("listaAutores",listaAutores);
		model.addAttribute("autor", new Autor());
		
		//llamado a la vista
		return "autores/mostrar";
	}
	
	@PostMapping("/guardar")
	public String crearAutor(@ModelAttribute Autor autor) {
		
		autorService2.save(autor);
		//redireccionamiento
		return "redirect:/autores";
	}
}
