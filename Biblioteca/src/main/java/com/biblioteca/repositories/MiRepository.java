package com.biblioteca.repositories;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.biblioteca.models.Usuario1;

@Repository
public class MiRepository {
	private final JdbcTemplate jdbcTemplate;

	public MiRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Usuario1> obtenerTodosLosUsuarios(){
		//query
		String sql = "select * from usuarios";
		
		return jdbcTemplate.query(sql, (rs,rowNum) -> {
				Usuario1 usuario = new Usuario1();
				usuario.setId(rs.getInt("id"));
				usuario.setEmail(rs.getString("email"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setPassword(rs.getString("password"));
				
				return usuario;
				});
	}

	public void guardarUsuario(Usuario1 usuario) {
		String sql = "INSERT INTO usuarios (email, nombre,password) values(?,?,?)";
		jdbcTemplate.update(sql,usuario.getEmail(),usuario.getNombre(),usuario.getPassword());
		
	}
	
	public void actualizarUsuario(Usuario1 usuario) {
		String sql = "UPDATE usuarios SET email=?, nombre=?, password=? WHERE id=?";
		jdbcTemplate.update(sql,usuario.getEmail(),usuario.getNombre(),usuario.getPassword(),usuario.getId());
	}
	
	public void eliminarUsuario(int id) {
		String sql = "DELETE FROM usuarios WHERE id = ?";
		jdbcTemplate.update(sql,id);
	}

	public Usuario1 buscarPorId(int id) {
		String sql = "select * from usuarios WHERE id = ?";
		
		try {
			return jdbcTemplate.queryForObject(sql, (rs,rowNum) -> 				
			new Usuario1(rs.getInt("id"),rs.getString("email"),rs.getString("nombre"),rs.getString("password")) 
			,id);
		}catch (Exception e) {
			System.out.println("Error:" + e.toString());
			return null;
		}
	}
	
}
