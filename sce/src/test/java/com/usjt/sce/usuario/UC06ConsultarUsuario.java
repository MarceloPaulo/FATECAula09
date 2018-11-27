package com.usjt.sce.usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.usjt.sce.fmodelo.DAOFactory;
import com.usjt.sce.imodelo.IUsuarioDAO;
import com.usjt.sce.modelo.usuario.ObtemUsuario;
import com.usjt.sce.modelo.usuario.Usuario;

public class UC06ConsultarUsuario {

	/**
	 * Objetivo: verificar o comportamento do sistema na consulta de usuario com
	 * sucesso.
	 */
	@Test
	public void CT01ConsultarUsuario_com_sucesso() {
		// cenario
		Usuario usuario = ObtemUsuario.comDadosValidos();
		Usuario resultadoObtido = null;
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		IUsuarioDAO iUsuarioDAO = mySQLFactory.getUsuarioDAO();
		// acao
		resultadoObtido = iUsuarioDAO.consulta(usuario.getRa());
		// verificacao
		assertTrue(resultadoObtido.equals(usuario));
	}

	/**
	 * Objetivo: verificar o comportamento do sistema na consulta de usuario com RA
	 * em branco.
	 */
	@Test
	public void CT02ConsultarLivroComRaEmBranco() {
		try {
			// cenario
			@SuppressWarnings("unused")
			Usuario usuario;
			// acao
			usuario = ObtemUsuario.comRA_branco();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("RA inválido", e.getMessage());
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema na consulta de usuario com RA
	 * nulo.
	 */
	@Test
	public void CT03ConsultarLivroComRaNulo() {
		try {
			// cenario
			@SuppressWarnings("unused")
			Usuario usuario;
			// acao
			usuario = ObtemUsuario.comRA_nulo();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("RA inválido", e.getMessage());
		}
	}
	
	/**
	 * Objetivo: verificar o comportamento do sistema na consulta de usuario com nome
	 * em branco.
	 */
	@Test
	public void CT04ConsultarLivroComNomeEmBranco() {
		try {
			// cenario
			@SuppressWarnings("unused")
			Usuario usuario;
			// acao
			usuario = ObtemUsuario.comNome_branco();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Nome inválido", e.getMessage());
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema na consulta de usuario com nome
	 * nulo.
	 */
	@Test
	public void CT05ConsultarLivroComNomeNulo() {
		try {
			// cenario
			@SuppressWarnings("unused")
			Usuario usuario;
			// acao
			usuario = ObtemUsuario.comNome_nulo();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Nome inválido", e.getMessage());
		}
	}
	
	/**
	 * Objetivo: verificar o comportamento do sistema na consulta dos dados do BD
	 */
	@Test
	public void CT06ConsultarUsuarioPorDados() {
		// cenario
		Usuario usuario = ObtemUsuario.comDadosValidos();
		// acao
		try {
			System.out.println(usuario.getRa());
			System.out.println(usuario.getNome());
		} catch (Exception e) {
			assertEquals("Dados inválidos", e.getMessage());
		}
	}
}
