package com.biblioteca.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nick;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(updatable = false)
	private Date createdAt;
	
	private Date updatedAt;
	
	public Cliente() {
		super();
	}
	public Cliente(Long id, String nick, String email) {
		super();
		this.id = id;
		this.nick = nick;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
