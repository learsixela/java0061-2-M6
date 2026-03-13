package com.edu.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.manager.models.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}
