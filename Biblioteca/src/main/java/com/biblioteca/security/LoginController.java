package com.biblioteca.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "security/login";
	}
	
	@PostMapping("/login")
	public String acceso() {
		return "home";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	@GetMapping("/registro")
	public String registro() {
		return "security/registro";
	}
	
}
