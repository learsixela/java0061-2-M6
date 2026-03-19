package com.biblioteca.models;

public class Usuario1 {
	
	private int id;
	private String email;
	private String nombre;
	private String password;

	public Usuario1() {
		super();
	}
	
	public Usuario1(int id, String email, String nombre, String password) {
		super();
		this.id = id;
		this.email = email;
		this.nombre = nombre;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
