package com.edu.manager.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min=3, max= 200)
	private String nombre;
	
	@OneToMany
	private List<Estudiante> estudiantes;
	
	@Column(updatable = false)
	private Date createdAt;
	
	private Date updatedAt;
	
	public Curso() {
		super();
	}
	public Curso(Long id, @NotNull @Size(min = 3, max = 200) String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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
