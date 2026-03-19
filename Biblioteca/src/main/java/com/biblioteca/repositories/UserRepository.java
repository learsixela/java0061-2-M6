package com.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.models.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByEmail(String email);
	Usuario findByUsername(String username);

}
