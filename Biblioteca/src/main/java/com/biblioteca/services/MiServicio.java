package com.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.models.Usuario1;
import com.biblioteca.repositories.MiRepository;

@Service
public class MiServicio {
	
	@Autowired
	private MiRepository miRepository;

	public List<Usuario1> obtenerTodosLosUsuarios() {
		return miRepository.obtenerTodosLosUsuarios();
	}

	public void guardarUsuario(Usuario1 usuario) {
		miRepository.guardarUsuario(usuario);
	}

	public void actualizarUsuario(Usuario1 usuario) {
		miRepository.actualizarUsuario(usuario);
	}
	
	public void eliminarUsuario(int id) {
		miRepository.eliminarUsuario(id);
	}

	public Usuario1 buscarPorId(int id) {
		return miRepository.buscarPorId(id);
	}

}
