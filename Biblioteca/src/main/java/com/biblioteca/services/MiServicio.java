package com.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.models.Usuario;
import com.biblioteca.repositories.MiRepository;

@Service
public class MiServicio {
	
	@Autowired
	private MiRepository miRepository;

	public List<Usuario> obtenerTodosLosUsuarios() {
		return miRepository.obtenerTodosLosUsuarios();
	}

	public void guardarUsuario(Usuario usuario) {
		miRepository.guardarUsuario(usuario);
	}

	public void actualizarUsuario(Usuario usuario) {
		miRepository.actualizarUsuario(usuario);
	}
	
	public void eliminarUsuario(int id) {
		miRepository.eliminarUsuario(id);
	}

}
