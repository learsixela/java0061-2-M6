package com.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.models.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

}
