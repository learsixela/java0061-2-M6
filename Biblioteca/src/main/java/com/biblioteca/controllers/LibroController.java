package com.biblioteca.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/libro")
public class LibroController {

	@RequestMapping("/home")
	public String home() {
		return "LibroController home";
		
	}
}
