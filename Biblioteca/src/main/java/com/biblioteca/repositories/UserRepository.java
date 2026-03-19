package com.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
	User findByUsername(String username);

}
