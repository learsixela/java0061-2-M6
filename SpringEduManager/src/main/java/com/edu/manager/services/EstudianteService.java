package com.edu.manager.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.manager.models.Estudiante;
import com.edu.manager.repositories.EstudianteRepository;

@Service
public class EstudianteService {

	@Autowired
	private EstudianteRepository er;

	public Estudiante save(Estudiante estudiante) {
		return er.save(estudiante);
	}
	
	
}
