package com.biblioteca.services;

import java.util.List;

import com.biblioteca.dtos.UserDTO;
import com.biblioteca.models.Usuario;

public interface UserService {
	void saveUser(UserDTO userDTO);
	Usuario findByEmail(String email);
	Usuario findByUsername(String username);
	List<UserDTO> findAllUsersDTO();
	List<Usuario> findAllUsers();
}
