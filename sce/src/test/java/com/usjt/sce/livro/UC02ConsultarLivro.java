package com.usjt.sce.livro;

import static org.junit.Assert.*;

import org.junit.Test;

import com.usjt.sce.fmodelo.DAOFactory;
import com.usjt.sce.imodelo.ILivroDAO;
import com.usjt.sce.modelo.livro.Livro;
import com.usjt.sce.modelo.livro.ObtemLivro;

public class UC02ConsultarLivro {
	/**
	 * Objetivo: verificar o comportamento do sistema na consulta com sucesso.
	 */
	@Test
	public void CT01ConsultarLivro_com_sucesso() {
		// cenario
		Livro livro = ObtemLivro.comDadosValidos();
		Livro resultadoObtido = null;
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ILivroDAO livroDAO = mySQLFactory.getLivroDAO();
		// acao
		resultadoObtido = livroDAO.consulta(livro.getIsbn());
		// verificacao
		assertTrue(resultadoObtido.equals(livro));
	}

	/**
	 * Objetivo: verificar o comportamento do sistema na consulta com ISBN em branco
	 */
	@Test
	public void CT02ConsultarLivroComIsbnEmBranco() {
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
	 * Objetivo: verificar o comportamento do sistema na consulta com ISBN nulo
	 */
	@Test
	public void CT03ConsultarLivroComIsbnNulo() {
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
	 * Objetivo: verificar o comportamento do sistema na consulta com Título em
	 * branco
	 */
	@Test
	public void CT04ConsultarLivroComTituloEmBranco() {
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
	 * Objetivo: verificar o comportamento do sistema na consulta com título nulo
	 */
	@Test
	public void CT05ConsultarLivroComTituloNulo() {
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
	 * Objetivo: verificar o comportamento do sistema na consulta com autor em
	 * branco
	 */
	@Test
	public void CT06ConsultarLivroComAutorEmBranco() {
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
	 * Objetivo: verificar o comportamento do sistema na consulta com autor nulo
	 */
	@Test
	public void CT07ConsultarLivroComAutorNulo() {
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
	 * Objetivo: verificar o comportamento do sistema na consulta dos dados do BD
	 */
	@Test
	public void CT08ConsultarLivroPorDados() {
		// cenario
		Livro livro = ObtemLivro.comDadosValidos();
		// acao
		try {
			System.out.println(livro.getIsbn());
			System.out.println(livro.getTitulo());
			System.out.println(livro.getAutor());
		} catch (Exception e) {
			assertEquals("Dados inválidos", e.getMessage());
		}
	}

}
