package com.usjt.sce.usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.usjt.sce.fmodelo.DAOFactory;
import com.usjt.sce.imodelo.IUsuarioDAO;
import com.usjt.sce.modelo.usuario.ObtemUsuario;
import com.usjt.sce.modelo.usuario.Usuario;

public class UC05CadastrarUsuario {

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de usuarios com
	 * dados válidos.
	 */
	@Test
	public void CT01CadastrarUsuarioComDadosValidos() {
		try {
			// cenario
			@SuppressWarnings("unused")
			Usuario usuario = new Usuario();
			// acao
			usuario = ObtemUsuario.comDadosValidos();
		} catch (RuntimeException e) {
			// verificacao
			fail("nao deve falhar");
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de uuarios com RA
	 * em branco.
	 */
	@Test
	public void CT02CadastrarUsuarioComRaBranco() {
		try {
			// cenario
			@SuppressWarnings("unused")
			Usuario usuario = new Usuario();
			// acao
			usuario = ObtemUsuario.comRA_branco();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("RA inválido", e.getMessage());
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de usuarios com RA
	 * nulo.
	 */
	@Test
	public void CT03CadastrarUsuarioComRaNulo() {
		try {
			// cenario
			@SuppressWarnings("unused")
			Usuario usuario = new Usuario();
			// acao
			usuario = ObtemUsuario.comRA_nulo();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("RA inválido", e.getMessage());
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de uuarios com nome
	 * em branco.
	 */
	@Test
	public void CT04CadastrarUsuarioComNomeBranco() {
		try {
			// cenario
			@SuppressWarnings("unused")
			Usuario usuario = new Usuario();
			// acao
			usuario = ObtemUsuario.comNome_branco();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Nome inválido", e.getMessage());
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de usuarios com nome
	 * nulo.
	 */
	@Test
	public void CT05CadastrarUsuarioComNomeNulo() {
		try {
			// cenario
			@SuppressWarnings("unused")
			Usuario usuario = new Usuario();
			// acao
			usuario = ObtemUsuario.comNome_nulo();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Nome inválido", e.getMessage());
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de usuário
	 * ainda não registrado.
	 */
	@Test
	public void CT06CadastrarUsuarioComExito() {
		// cenario
		Usuario usuario = ObtemUsuario.comDadosValidos();
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		IUsuarioDAO usuarioDAO = mySQLFactory.getUsuarioDAO();
		int codigoRetorno = 0;
		// acao
		codigoRetorno = usuarioDAO.adiciona(usuario);
		assertEquals(1, codigoRetorno);
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de usuario com
	 * conjunto de usuarios com RA já cadastrado.
	 */
	@Test
	public void CT07RecadastrarUsuarioComException() {
		// cenario
		Usuario usuario = ObtemUsuario.comDadosValidos();
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		IUsuarioDAO usuarioDAO = mySQLFactory.getUsuarioDAO();
		int codigoRetorno = 0;
		try {
			// acao
			codigoRetorno = usuarioDAO.adiciona(usuario);
			assertEquals(1, codigoRetorno);
		} catch (Exception e) {
			// verificacao
			assertEquals(e.getMessage(), "com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException:"
					+ " Duplicate entry " + "'" + usuario.getRa() + "'" + " for key 'PRIMARY'");
		}
	}
}
