package com.edu.manager.dto;

public class Autor {

	private Long id;
	private String nombre;
	private String nacionalidad;
	
	public Autor() {
		super();
	}
	public Autor(Long id,String nombre, String nacionalidad) {
		super();
		this.id = id;
		this.nombre= nombre;
		this.nacionalidad = nacionalidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + "]";
	}

	
}
