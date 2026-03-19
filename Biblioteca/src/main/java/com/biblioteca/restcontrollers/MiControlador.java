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

import com.biblioteca.models.Usuario1;
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
	public List<Usuario1> obtenerTodosLosUsuarios(){
		return usuarioServicio.obtenerTodosLosUsuarios();
	}
	
	@PostMapping("/crear")
	public void crear(@RequestBody Usuario1 usuario) {
		usuarioServicio.guardarUsuario(usuario);
	}
	
	@GetMapping("/{id}")
	public Usuario1 buscarPorId(@PathVariable int id) {
		Usuario1 usuario = usuarioServicio.buscarPorId(id);
		
		if(usuario == null) {
			throw new RuntimeException("Usuario no encontrado");
		}
		
		return usuario;
		
		//return usuarioServicio.buscarPorId(id);
	}
	
	@PutMapping("/{id}")
	public void actualizar(@PathVariable int id, @RequestBody Usuario1 usuario) {
		usuario.setId(id);
		usuarioServicio.actualizarUsuario(usuario);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable int id) {
		usuarioServicio.eliminarUsuario(id);
	}
}
