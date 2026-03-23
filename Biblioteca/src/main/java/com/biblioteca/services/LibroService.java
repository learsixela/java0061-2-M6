package com.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.models.Cliente;
import com.biblioteca.models.Libro;
import com.biblioteca.repositories.LibroRepository;

@Service
public class LibroService {

	@Autowired
	private LibroRepository libroRepository;
	
	public Libro save(Libro libro) {
	
		return libroRepository.save(libro);
	}
	
	public List<Libro> findAll(){
		return libroRepository.findAll();
	}

	public Libro findById(Long id) {
		// Utilizando el CrudRepository
		return libroRepository.findById(id).get();
		//return libroRepository.getById(id);
	}
	
	public void deleteById(Long id) {
		if(libroRepository.existsById(id)) {
			libroRepository.deleteById(id);
		}
	}
	
	public void delete(Long id) {
		Libro libro = libroRepository.findById(id).get();
		if (libro!= null) {
			libroRepository.delete(libro);
		}
	}
	
}
