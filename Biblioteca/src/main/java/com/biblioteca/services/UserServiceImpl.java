package com.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biblioteca.dtos.UserDTO;
import com.biblioteca.models.Usuario;
import com.biblioteca.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService, UserService{

	private final PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void saveUser(UserDTO userDTO) {
		/*Usuario user = new Usuario();
		user.setEmail(userDTO.getEmail());
		user.setUsername(userDTO.getUsername());
		user.setRole(userDTO.getRole());
		// encriptar password
		String newPass= passwordEncoder.encode(userDTO.getPassword());
		user.setPassword(newPass);
		//
		userRepo.save(user);
		*/
		Usuario user = mapeoDTOaUser(userDTO);
		
		userRepo.save(user);
	}
	
	private Usuario mapeoDTOaUser(UserDTO userDTO) {
		Usuario user = new Usuario();
		user.setEmail(userDTO.getEmail());
		user.setUsername(userDTO.getUsername());
		user.setRole(userDTO.getRole());
		// encriptar password
		String newPass= passwordEncoder.encode(userDTO.getPassword());
		user.setPassword(newPass);
		return user;
	}

	@Override
	public Usuario findByEmail(String email) {
		Usuario user = userRepo.findByEmail(email);
		if(user == null) {
			return null;
		}
		return user;
	}

	@Override
	public Usuario findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public List<UserDTO> findAllUsersDTO() {
		// TODO tarea mapear User a DTO
		return null;
	}

	@Override
	public List<Usuario> findAllUsers() {
		
		return userRepo.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = userRepo.findByUsername(username);
		UserDetails user = User.builder()
				.username(usuario.getUsername())
				.password(usuario.getPassword()) 
				.roles(usuario.getRole()) 
				.build();
		return user;
	}
	

}
