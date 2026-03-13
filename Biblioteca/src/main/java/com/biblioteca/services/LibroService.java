package com.biblioteca.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.models.Libro;
import com.biblioteca.repositories.LibroRepository;

@Service
public class LibroService {

	@Autowired
	private LibroRepository libroRepository;
	
	public Libro guardar(Libro libro) {
	
		return libroRepository.save(libro);
	}
	
	
}
