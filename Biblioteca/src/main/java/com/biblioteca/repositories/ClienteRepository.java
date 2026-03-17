package com.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.biblioteca.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	List<Cliente> findByEmailContaining(String email);

    @Query("SELECT c FROM Cliente c WHERE c.nick LIKE :nick ESCAPE '\\' AND c.email LIKE :email ESCAPE '\\'")
    List<Cliente> findByNickContainingAndEmailContaining(String nick, String email);

	List<Cliente> findByNickContainingOrEmailContaining(String nick, String email);
}
