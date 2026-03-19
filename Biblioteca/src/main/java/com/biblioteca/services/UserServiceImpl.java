package com.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biblioteca.dtos.UserDTO;
import com.biblioteca.models.User;
import com.biblioteca.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	private final PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void saveUser(UserDTO userDTO) {
		/*User user = new User();
		user.setEmail(userDTO.getEmail());
		user.setUsername(userDTO.getUsername());
		user.setRole(userDTO.getRole());
		// encriptar password
		String newPass= passwordEncoder.encode(userDTO.getPassword());
		user.setPassword(newPass);
		//
		userRepo.save(user);
		*/
		User user = mapeoDTOaUser(userDTO);
		
		userRepo.save(user);
	}
	
	private User mapeoDTOaUser(UserDTO userDTO) {
		User user = new User();
		user.setEmail(userDTO.getEmail());
		user.setUsername(userDTO.getUsername());
		user.setRole(userDTO.getRole());
		// encriptar password
		String newPass= passwordEncoder.encode(userDTO.getPassword());
		user.setPassword(newPass);
		return user;
	}

	@Override
	public User findByEmail(String email) {
		User user = userRepo.findByEmail(email);
		if(user == null) {
			return null;
		}
		return user;
	}

	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public List<UserDTO> findAllUsersDTO() {
		// TODO tarea mapear User a DTO
		return null;
	}

	@Override
	public List<User> findAllUsers() {
		
		return userRepo.findAll();
	}
	

}
