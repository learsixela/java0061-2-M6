package com.biblioteca.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.biblioteca.dtos.UserDTO;
import com.biblioteca.models.Usuario;
import com.biblioteca.services.UserServiceImpl;

@Controller
public class LoginController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
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
	
	@GetMapping("/registrar")
	public String registro(Model model) {
		model.addAttribute("userDTO",new UserDTO());
		model.addAttribute("titulo","Registro de Usuario");
		
		return "security/registro";
	}
	
	@PostMapping("/registrar")
	public String registrar(@ModelAttribute UserDTO userDTO) {
		//validar los datos
		if(userDTO.getEmail()!= null) {
			//validar la existencia del usuario
			Usuario user= userServiceImpl.findByEmail(userDTO.getEmail());
			if (user!= null ) {
				//mensaje de regreso al front, al usuario ya existe (@Valid)
			}else {
				//comparar los password
				if(userDTO.getPassword().equals(userDTO.getPasswordConfirmation())) {
					//almacena la informacion en la tabla
					userServiceImpl.saveUser(userDTO);
				}else {
					//retornar con mensaje de error
				}
				
			}
		}

		
		return "redirect:/login";
	}
	
}
