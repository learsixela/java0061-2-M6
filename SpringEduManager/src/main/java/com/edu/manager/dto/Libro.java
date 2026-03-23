package com.edu.manager.dto;

public class Libro {
	private Long id;
	private String isbn;
	private String titulo;
	private Autor autor;
	
	public Libro(Long id, String isbn, String titulo, Autor autor) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
	}
	public Libro() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	@Override
	public String toString() {
		return "Libro [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + "]";
	}
	
	
}
