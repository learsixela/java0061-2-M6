package com.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	List<Cliente> findByEmailContaining(String email);

	List<Cliente> findByNickContainingAndEmailContaining(String nick, String email);

	List<Cliente> findByNickContainingOrEmailContaining(String nick, String email);
}
