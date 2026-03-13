package com.edu.manager.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="estudiantes")
public class Estudiante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=3, max= 200)
	private String nombre;
	@NotNull
	@Size(min=3, max= 200)
	private String apellido;
	@NotNull
	@Size(max= 12)
	@Column(unique = true)
	private String dni;//rut
	
	//se queda con la FK
	@ManyToOne
	private Curso curso;
	
	// columnas fecha (fecha_creacion y fecha_actualizacion)
	@Column(updatable = false)
	private Date createdAt;
	
	private Date updatedAt;
	
	public Estudiante() {
		super();
	}
	public Estudiante(Long id, @NotNull @Size(min = 3, max = 200) String nombre,
			@NotNull @Size(min = 3, max = 200) String apellido, @NotNull @Size(max = 12) String dni) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	// ejecutarse antes de insertar
	@PrePersist
	protected void onCreate() {
		createdAt= new Date();
		updatedAt= new Date();
	}
	
	// ejecutar antes de actualizar
	@PreUpdate
	protected void onUpdate() {
		updatedAt= new Date();
	}
}
