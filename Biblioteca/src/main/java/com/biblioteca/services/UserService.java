package com.biblioteca.services;

import java.util.List;

import com.biblioteca.dtos.UserDTO;
import com.biblioteca.models.User;

public interface UserService {
	void saveUser(UserDTO userDTO);
	User findByEmail(String email);
	User findByUsername(String username);
	List<UserDTO> findAllUsersDTO();
	List<User> findAllUsers();
}
