package com.biblioteca.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.biblioteca.models.Cliente;
import com.biblioteca.services.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	/*
	 * GET  /clientes
	 * GET  /clientes/nuevo  (desplegar formulario de creacion)
	 * POST /clientes/guardar (persistencia de datos) 
	 * GET  /clientes/editar/{id} (desplegar formulario de edicion)
	 * POST /clientes/actualizar (persistencia de datos)
	 * GET  /clientes/eliminar/{id}
	 * */
	
	private final ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService){
		this.clienteService= clienteService;
	}
	
	@GetMapping
	public String index(Model model) {
		List<Cliente> clientes = clienteService.findAll();
		model.addAttribute("listaClientes",clientes);
		//model.addAttribute("cliente", new Cliente());
		return "clientes/mostrar";		
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("titulo","Crear Cliente");
		return "clientes/form";		
	}
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Cliente cliente) {
		clienteService.save(cliente);
		return "redirect:/clientes";
	}
	//http://localhost:8082/clientes/editar/1
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Cliente cliente = clienteService.findById(id);
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo","Editar Cliente");
		return "clientes/form";
	}
	
	@PostMapping("/actualizar")
	public String actualizar(@ModelAttribute Cliente cliente) {
		clienteService.save(cliente);
		return "redirect:/clientes";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		clienteService.deleteById(id);
		return "redirect:/clientes";
	}
	
	
	//http://localhost:8082/clientes/buscar?nombre=
	//desde un formulario
		@GetMapping("/buscar")
		public String buscar(@RequestParam String nombre, Model model) {
			List<Cliente> clientes = clienteService.buscarPorNombre(nombre);
			model.addAttribute("listaClientes",clientes);
			return "clientes/mostrar";		
		}
		

		

		
}
