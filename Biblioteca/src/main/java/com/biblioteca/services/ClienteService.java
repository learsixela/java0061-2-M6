package com.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.models.Cliente;
import com.biblioteca.repositories.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	public Cliente findById(Long id) {
		Cliente cliente1 = clienteRepository.findById(id).get();
		Cliente cliente2 = clienteRepository.getReferenceById(id);
		
		return cliente2;
	}
	
}
