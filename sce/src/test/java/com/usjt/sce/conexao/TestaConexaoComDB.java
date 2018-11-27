package com.usjt.sce.conexao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.usjt.sce.fmodelo.ConfiguraDB;
import com.usjt.sce.fmodelo.ConnectionFactory;

public class TestaConexaoComDB {
	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com
	 * configuracao valida Pré-condição - a configuracao default da fabrica de
	 * conexoes é valida
	 */
	@Test
	public void quandoConectaComOBancoRetornaOK() {
		// cenario
		Connection c = null;
		try {
			// acao
			c = new ConnectionFactory().getConnection();
			// verificacao
			assertNotNull(c);
		} catch (Exception e) {
			fail("nao deveria falhar");
		}
	}

	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com senha de
	 * acesso invalida Pré-condição - a senha cadastrada é "root"
	 */
	
	@Test
	public void quandoConectaComSenhaInvalida_SQLException() {
		// cenario
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "11112"; // senha errada
		ConnectionFactory fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new ConnectionFactory(configuraDB);
		try {
			// acao
			fabricaDeConexoes.getConnection();
			fail("deveria falhar");
		} catch (Exception e) {
			// verificacao
			// System.out.println(e.getMessage());
			assertEquals(e.getMessage(),
					"java.sql.SQLException: Access denied for user 'root'@'localhost' (using password: YES)");
		}
	}

	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com usuario
	 * invalido Pré-condição - o usuário cadastrado é "root"
	 */
	
	@Test
	public void quandoConectaComUsuarioInvalido_SQLException() {
		// cenario
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "123456"; // usuario inválido
		String senha = "root"; // senha certa
		ConnectionFactory fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new ConnectionFactory(configuraDB);
		try {
			// acao
			fabricaDeConexoes.getConnection();
			fail("deveria falhar");
		} catch (Exception e) {
			// verificacao
			// System.out.println(e.getMessage());
			assertEquals(e.getMessage(),
					"java.sql.SQLException: Access denied for user '123456'@'localhost' (using password: YES)");
		}
	}

	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com url
	 * invalido Pré-condição - o url válido é localhost:3306. Usaremos, para
	 * fins de teste, a condição localhost:8080
	 */
	
	@Test
	public void quandoConectaComURLInvalido_SQLException() {
		// cenario
		String url = "jdbc:mysql://localhost:8080/biblioteca"; //url inválido
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root"; // usuario válido
		String senha = "root"; // senha certa
		ConnectionFactory fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new ConnectionFactory(configuraDB);
		try {
			// acao
			fabricaDeConexoes.getConnection();
			fail("deveria falhar");
		} catch (Exception e) {
			// verificacao
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(), "com.mysql.jdbc.exceptions.jdbc4.CommunicationsException: Communications link failure\n" + "\n"
							+ "The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.");
		}
	}
	
	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com driver
	 * invalido Pré-condição - o driver correto é Driver, mas usaremos Driver1.
	 */
	
	@Test
	public void quandoConectaComDriverInvalido_SQLException() {
		// cenario
		String url = "jdbc:mysql://localhost:3306/biblioteca"; //url válido
		String driver = "com.mysql.jdbc.Driver1"; // driver inválido
		String usuario = "root"; // usuario válido
		String senha = "root"; // senha certa
		ConnectionFactory fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new ConnectionFactory(configuraDB);
		try {
			// acao
			fabricaDeConexoes.getConnection();
			fail("deveria falhar");
		} catch (Exception e) {
			// verificacao
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(), "java.lang.ClassNotFoundException: com.mysql.jdbc.Driver1");
		}
	}
}