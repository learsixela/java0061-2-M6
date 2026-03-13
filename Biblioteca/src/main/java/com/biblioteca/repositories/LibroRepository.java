package com.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.models.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{

}
