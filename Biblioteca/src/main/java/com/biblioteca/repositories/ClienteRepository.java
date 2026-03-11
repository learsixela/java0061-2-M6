package com.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
