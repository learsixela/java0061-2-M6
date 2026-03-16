package com.biblioteca.restcontrollers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.models.Usuario;
import com.biblioteca.services.MiServicio;

@RestController
@RequestMapping("/api/usuarios")
public class MiControlador {

	//inyeccion de dependencia
	private final MiServicio usuarioServicio;

	public MiControlador(MiServicio usuarioServicio) {
		this.usuarioServicio = usuarioServicio;
	}
	
	@GetMapping
	public List<Usuario> obtenerTodosLosUsuarios(){
		return usuarioServicio.obtenerTodosLosUsuarios();
	}
	
	@PostMapping("/crear")
	public void crear(@RequestBody Usuario usuario) {
		usuarioServicio.guardarUsuario(usuario);
	}
	
	@PutMapping("/{id}")
	public void actualizar(@PathVariable int id, @RequestBody Usuario usuario) {
		usuario.setId(id);
		usuarioServicio.actualizarUsuario(usuario);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable int id) {
		usuarioServicio.eliminarUsuario(id);
	}
}
