package com.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biblioteca.models.Autor;
import com.biblioteca.services.AutorService;

@Controller
@RequestMapping("/autores")
public class AutorController {
	//inyeccion de dependencia
	@Autowired
	private AutorService auService;
	
	private final AutorService autorService2;
	public AutorController(AutorService autorService) {
		this.autorService2 = autorService;
	}
	
	@RequestMapping("")
	public String mostrarTodos() {
		List<Autor> listaAutores = auService.finAll();
		//enviar la informacion a una vista
		return "";
	}
}
