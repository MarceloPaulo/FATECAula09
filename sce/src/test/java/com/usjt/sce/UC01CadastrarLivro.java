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
			 umLivro = ObtemLivro.comDadosValidos();
		} catch (RuntimeException e) {
			// verificacao
			fail("Não deve falhar");
		}
	}
/**
 * Objetivo: verificar o comportamento do sistema no cadastro de livro com dados válidos.
 */
	@Test
	public void CT02CadastrarLivroComISBN_em_branco() {
		try {
			// cenario
			 Livro umLivro = new Livro();
			 // acao
			 umLivro = ObtemLivro.comISBNInvalido_branco();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("ISBN inválido", e.getMessage());
		}
	}
/**
 * Objetivo: verificar o comportamento do sistema no cadastro de livro com ISBN branco.
 */
	@Test
	public void CT03CadastrarLivroComISBN_nulo() {
		try {
			// cenario
			 Livro umLivro = new Livro();
			 // acao
			 umLivro = ObtemLivro.comISBNInvalido_nulo();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("ISBN inválido", e.getMessage());
		}
	}

	@Test
	public void CT04CadastrarLivroComTitulo_em_branco() {
		// cenario
		Livro livro = new Livro();
		
		try {
			// acao
			livro = ObtemLivro.comTituloInvalido_branco();
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Titulo inválido", e.getMessage());
		}
	}

	@Test
	public void CT05CadastrarLivroComTitulo_nulo() {
		// cenario
		Livro livro = new Livro();
		try {
			// acao
			livro = ObtemLivro.comTituloInvalido_nulo();
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Titulo inválido", e.getMessage());
		}
	}

	@Test
	public void CT06CadastrarLivroComAutor_em_branco() {
		// cenario
		Livro livro = new Livro();
		try {
			// acao
			livro = ObtemLivro.comAutorInvalido_branco();
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Autor inválido", e.getMessage());
		}
	}

	@Test
	public void CT07CadastrarLivroComAutor_nulo() {
		// cenario
		Livro livro = new Livro();
		try {
			// acao
			livro = ObtemLivro.comAutorInvalido_nulo();
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Autor inválido", e.getMessage());
		}
	}

	@Test
	public void CT08CadastrarLivro_com_sucesso_Titulo() {
		// cenario
		Livro livro = new Livro();
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		assertEquals("Engenharia de Software", livro.getTitulo());
	}

	@Test
	public void CT09CadastrarLivro_com_sucesso_ISBN() {
		// cenario
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setAutor("Pressman");
		assertEquals("121212", livro.getIsbn());
	}

	@Test
	public void CT10CadastrarLivro_com_sucesso_Autor() {
		// cenario
		Livro livro = new Livro();
		livro.setAutor("Pressman");
		livro.setTitulo("Engenharia de Software");
		assertEquals("Pressman", livro.getAutor());
	}
}
	
	