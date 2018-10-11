package com.usjt.sce;

import static org.junit.Assert.*;

import org.junit.Test;

import com.usjt.sce.model.Livro;

public class UC01CadastrarLivro {
	
	@Test
	public void CT01CadastrarLivroComDadosValidos() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro.setIsbn("121212");
			umLivro.setTitulo("Engenharia de Softwar");
			umLivro.setAutor("Pressman");
		} catch (RuntimeException e) {
			// verificacao
			fail("nao deve falhar");
		}
	}

	@Test
	public void CT02CadastrarLivroComIsbnBranco() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro.setIsbn("");
			umLivro.setTitulo("Engenharia de Softwar");
			umLivro.setAutor("Pressman");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("ISBN invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT03CadastrarLivroComIsbnNulo() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro.setIsbn(null);
			umLivro.setTitulo("Engenharia de Softwar");
			umLivro.setAutor("Pressman");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("ISBN invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT04CadastrarLivroComTituloBranco() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro.setIsbn("121212");
			umLivro.setTitulo("");
			umLivro.setAutor("Pressman");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Título Inválido", e.getMessage());
		}
	}
	
	@Test
	public void CT05CadastrarLivroComTituloNulo() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro.setIsbn("121212");
			umLivro.setTitulo(null);
			umLivro.setAutor("Pressman");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Título Inválido", e.getMessage());
		}
	}
	
	@Test
	public void CT06CadastrarLivroComAutorBranco() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro.setIsbn("121212");
			umLivro.setTitulo("Engenharia de Softwar");
			umLivro.setAutor("");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Autor Inválido", e.getMessage());
		}
	}
	
	@Test
	public void CT07CadastrarLivroComAutorNulo() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro.setIsbn("121212");
			umLivro.setTitulo("Engenharia de Softwar");
			umLivro.setAutor(null);
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Autor Inválido", e.getMessage());
		}
	}
	
	@Test
	public void CT08CadastrarLivroComSet() {
		Livro umLivro = new Livro("121212","Engenharia de Softwar","Pressman");
		try {
			System.out.println(umLivro.getIsbn());
			System.out.println(umLivro.getTitulo());
			System.out.println(umLivro.getAutor());
			
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Livro Inválido", e.getMessage());
		}
	}
	
}
