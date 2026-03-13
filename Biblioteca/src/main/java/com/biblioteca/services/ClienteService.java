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
		//crea o actualiza, depende si trae o no el ID
		clienteRepository.save(cliente);
	}

	public Cliente findById(Long id) {
		
		Cliente cliente2 = clienteRepository.getReferenceById(id);
		
		return cliente2;
	}

	public void deleteById(Long id) {
		if(clienteRepository.existsById(id)) {
			clienteRepository.deleteById(id);
		}
	}
	
	public void delete(Long id) {
		Cliente cliente1 = clienteRepository.findById(id).get();
		if (cliente1!= null) {
			clienteRepository.delete(cliente1);
		}
	}

	public List<Cliente> buscarPorEmail(String email) {
		//ejemplo:  gmail o gmail.com 
		return clienteRepository.findByEmailContaining(email);
	}

	public List<Cliente> buscar(String nick, String email) {
		// TODO Auto-generated method stub
		return clienteRepository.findByNickContainingAndEmailContaining(nick,email);
	}
	
}
