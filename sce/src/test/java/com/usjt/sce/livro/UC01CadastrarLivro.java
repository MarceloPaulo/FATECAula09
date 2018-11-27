package com.usjt.sce.livro;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.usjt.sce.fmodelo.DAOFactory;
import com.usjt.sce.imodelo.ILivroDAO;
import com.usjt.sce.modelo.livro.Livro;
import com.usjt.sce.modelo.livro.ObtemLivro;

public class UC01CadastrarLivro {

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de livro com dados
	 * válidos. Detectada uma falha: Esse código não armazena dados.
	 */
	@Ignore
	@Test
	public void CT01CadastrarLivroComDadosValidos() {
		try {
			// cenario
			@SuppressWarnings("unused")
			Livro umLivro;
			// acao
			umLivro = ObtemLivro.comDadosValidos();
		} catch (RuntimeException e) {
			// verificacao
			fail("Não deve falhar");
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de livro com ISBN
	 * em branco.
	 */
	@Test
	public void CT02CadastrarLivroComIsbnEmBranco() {
		try {
			// cenario
			@SuppressWarnings("unused")
			Livro livro;
			// acao
			livro = ObtemLivro.comISBNInvalido_branco();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("ISBN inválido", e.getMessage());
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de livro com ISBN
	 * nulo.
	 */
	@Test
	public void CT03CadastrarLivroComIsbnNulo() {
		try {
			// cenario
			@SuppressWarnings("unused")
			Livro livro;
			// acao
			livro = ObtemLivro.comISBNInvalido_nulo();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("ISBN inválido", e.getMessage());
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de livro com
	 * título em branco.
	 */
	@Test
	public void CT04CadastrarLivroComTituloEmBranco() {
		try {
			// cenario
			@SuppressWarnings("unused")
			Livro livro;
			// acao
			livro = ObtemLivro.comTituloInvalido_branco();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Título inválido", e.getMessage());
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de livro com
	 * título nulo.
	 */
	@Test
	public void CT06CadastrarLivroComTituloNulo() {
		try {
			// cenario
			@SuppressWarnings("unused")
			Livro livro;
			// acao
			livro = ObtemLivro.comTituloInvalido_nulo();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Título inválido", e.getMessage());
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de livro com autor
	 * em branco.
	 */
	@Test
	public void CT07CadastrarLivroComAutorEmBranco() {
		try {
			// cenario
			@SuppressWarnings("unused")
			Livro livro;
			// acao
			livro = ObtemLivro.comAutorInvalido_branco();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Autor inválido", e.getMessage());
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de livro com autor
	 * nulo.
	 */
	@Test
	public void CT08CadastrarLivroComAutorNulo() {
		try {
			// cenario
			@SuppressWarnings("unused")
			Livro livro;
			// acao
			livro = ObtemLivro.comAutorInvalido_nulo();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Autor inválido", e.getMessage());
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de livro com
	 * sucesso. Detectada uma falha: Esse forma de código não captura erro.
	 */

	@Ignore
	@Test
	public void CT09CadastrarLivroComExito() {
		// cenario
		Livro livro = ObtemLivro.comDadosValidos();
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ILivroDAO livroDAO = mySQLFactory.getLivroDAO();
		int codigoRetorno = 0;
		// acao
		codigoRetorno = livroDAO.adiciona(livro);
		assertEquals(1, codigoRetorno);
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de livro com
	 * conjunto de livros já cadastrados. Adiciona, caso não tenha no BD.
	 */
	@Test
	public void CT010RecadastrarLivroComException() {
		// cenario
		Livro livro = ObtemLivro.comDadosValidos();
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ILivroDAO livroDAO = mySQLFactory.getLivroDAO();
		int codigoRetorno = 0;
		try {
			// acao
			codigoRetorno = livroDAO.adiciona(livro);
			assertEquals(1, codigoRetorno);
		} catch (Exception e) {
			// verificacao
			assertEquals(e.getMessage(), "com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException:"
					+ " Duplicate entry " + "'" + livro.getIsbn() + "'" + " for key 'PRIMARY'");
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de livro com ISBN
	 * já cadastrado.
	 */
	@Test
	public void CT011CadastrarLivroComIsbnJaCadastrado() {
		// cenario
		Livro livro = new Livro();
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ILivroDAO livroDAO = mySQLFactory.getLivroDAO();
		int codigoRetorno = 0;
		try {
			// acao
			livro.setIsbn("121212");
			livro.setTitulo("Engenharia de Software");
			livro.setAutor("Pressman");
			codigoRetorno = livroDAO.adiciona(livro);
			assertEquals(1, codigoRetorno);
		} catch (Exception e) {
			// verificacao
			assertEquals(e.getMessage(), "com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException:"
					+ " Duplicate entry " + "'" + livro.getIsbn() + "'" + " for key 'PRIMARY'");
		}
	}
}
