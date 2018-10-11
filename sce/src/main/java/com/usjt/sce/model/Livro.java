package com.usjt.sce.model;

public class Livro {
	private String isbn;
	private String titulo;
	private String autor;
	
	public Livro() {
		
	}
	
	public Livro(String isbn, String titulo, String autor) {
		this.setIsbn(isbn);
		this.setTitulo(titulo);
		this.setAutor(autor);
	}

	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		if (isbn == "" | isbn == null) {
			throw new RuntimeException("ISBN invalido");
		}
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if(titulo == "" | titulo == null) {
			throw new RuntimeException("Título Inválido");
		}
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		if(autor == "" | autor == null) {
			throw new RuntimeException("Autor Inválido");
		}
		this.autor = autor;
	}
}