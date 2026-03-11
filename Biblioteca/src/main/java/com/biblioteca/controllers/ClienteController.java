package com.biblioteca.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biblioteca.models.Cliente;
import com.biblioteca.services.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	private final ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService){
		this.clienteService= clienteService;
	}
	
	@GetMapping
	public String mostrar(Model model) {
		List<Cliente> clientes = clienteService.findAll();
		model.addAttribute("listaClientes",clientes);
		model.addAttribute("cliente", new Cliente());
		return "clientes/mostrar";		
	}
	
	@PostMapping("/guardar")
	public String guardarCliente(@ModelAttribute Cliente cliente) {
		clienteService.save(cliente);
		return "redirect:/clientes";
	}
}
