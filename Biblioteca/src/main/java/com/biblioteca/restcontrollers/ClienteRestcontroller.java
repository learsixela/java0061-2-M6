package com.biblioteca.restcontrollers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.models.Cliente;
import com.biblioteca.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestcontroller {

    private final ClienteService clienteService;

    ClienteRestcontroller(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
	
	//http://localhost:8082/api/clientes?id=1
	@GetMapping
	public Cliente obtenerClienteParametro(@RequestParam Long id) {
		Cliente cliente = clienteService.findById(id);
		
		return cliente;
	}
	
	//http://localhost:8082/api/clientes/1
	@GetMapping("/{id}")
	public Cliente obtenerClienteRuta(@PathVariable Long id) {
		Cliente cliente = clienteService.findById(id);
		
		return cliente;
	}
}
