package com.edu.manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.manager.models.Estudiante;
import com.edu.manager.services.EstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

	private final EstudianteService es;
	
	public EstudianteController(EstudianteService estudianteService) {
		this.es= estudianteService;
	}
	
	@GetMapping("")
	public String inicio() {
		return "estudiantes/index";
	}
	
	@GetMapping("/registrar")
	public String registrar(Model model) {
		model.addAttribute("estudiante", new Estudiante());
		model.addAttribute("titulo","Registro de Estudiante");
		
		return "estudiantes/form";
	}
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Estudiante estudiante) {
		
		Estudiante respuesta = es.save(estudiante);
		// agregar el estudiante a sesion
		
		return "redirect:/estudiantes";
	}
	
}
