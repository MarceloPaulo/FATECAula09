package com.usjt.sce.modelo.livro;

public class ObtemLivro {
	public static Livro comDadosValidos() {
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		return livro;
	}

	public static Livro comISBNInvalido_branco() {
		Livro livro = new Livro();
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		livro.setIsbn("");
		return livro;
	}

	public static Livro comISBNInvalido_nulo() {
		Livro livro = new Livro();
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		livro.setIsbn(null);
		return livro;
	}
	
	public static Livro comTituloInvalido_branco() {
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setAutor("Pressman");
		livro.setTitulo("");
		return livro;
	}

	public static Livro comTituloInvalido_nulo() {
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setAutor("Pressman");
		livro.setTitulo(null);
		return livro;
	}
	
	public static Livro comAutorInvalido_branco() {
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("");
		return livro;
	}

	public static Livro comAutorInvalido_nulo() {
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor(null);
		return livro;
	}
	
}