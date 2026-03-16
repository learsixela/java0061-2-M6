package com.biblioteca.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@MappedSuperclass
public abstract class BaseEntity {

	@Column(updatable = false)
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
	
	// ejecutarse antes de insertar
	@PrePersist
	protected void onCreate() {
		this.createdAt= LocalDateTime.now();
	
	}
	
	// ejecutar antes de actualizar
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt= LocalDateTime.now();
	}
}
