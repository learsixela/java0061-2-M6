package com.biblioteca.repositories;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.biblioteca.models.Usuario;

@Repository
public class MiRepository {
	private final JdbcTemplate jdbcTemplate;

	public MiRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Usuario> obtenerTodosLosUsuarios(){
		//query
		String sql = "select * from usuarios";
		
		return jdbcTemplate.query(sql, (rs,rowNum) -> {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setEmail(rs.getString("email"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setPassword(rs.getString("password"));
				
				return usuario;
				});
	}

	public void guardarUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuarios (email, nombre,password) values(?,?,?)";
		jdbcTemplate.update(sql,usuario.getEmail(),usuario.getNombre(),usuario.getPassword());
		
	}
	
}
