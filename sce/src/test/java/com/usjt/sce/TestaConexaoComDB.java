package com.usjt.sce;

import static org.junit.Assert.*;
import org.junit.Test;
import com.usjt.sce.model.ConfiguraDB;
import com.usjt.sce.model.FabricaDeConexoes;

public class TestaConexaoComDB {
	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com
	 * configuracao valida Pré-condição - a configuracao default da fabrica de
	 * conexoes é valida
	 */
	@Test
	public void quandoConectaComOBancoRetornaOK() {
		// cenario
		FabricaDeConexoes fabrica;
		// acao
		fabrica = new FabricaDeConexoes();
		// verificacao
		assertNotNull(fabrica.getConnection());
	}

	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com senha de
	 * acesso invalida Pré-condição - a senha cadastrada é "aluno"
	 */
	@Test
	public void quandoConectaComSenhaInvalida_SQLException() {
		// cenario
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "root"; // senha errada
		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);
		try {
			// acao
			fabricaDeConexoes.getConnection();
			fail("deveria falhar");
		} catch (Exception e) {
			// verificacao
			//System.out.println(e.getMessage());
			assertEquals(e.getMessage(),
					"java.sql.SQLException: Access denied for user 'root'@'localhost' (using password: YES)");
		}
	}

	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com usuario
	 * invalido Pré-condição - a senha cadastrada é "aluno"
	 */
	@Test
	public void quandoConectaComUsuarioInvalido_SQLException() {
		// cenario
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String driver = "com.mysql.jdbc.Driver1";
		String usuario = "usuarioErrado"; // usuario inválido
		String senha = "root"; // senha certa
		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);
		try {
			// acao
			fabricaDeConexoes.getConnection();
			fail("deveria falhar");
		} catch (Exception e) {
			// verificacao
			//System.out.println(e.getMessage());
			assertEquals(e.getMessage(),
					"java.lang.ClassNotFoundException: com.mysql.jdbc.Driver1");
		}
	}
	@Test
	public void quandoConectaComURLInvalido_SQLException() {
		// cenario
		String url = "jdbc:mysql://localhost:3327/biblioteca";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root"; // usuario válido
		String senha = ""; // senha certa
		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);
		try {
			// acao
			fabricaDeConexoes.getConnection();
			fail("deveria falhar");
		} catch (Exception e) {
			// verificacao
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(),
					"com.mysql.jdbc.exceptions.jdbc4.CommunicationsException: Communications link failure\n" + 
					"\n" + 
					"The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.");
		}
	}
}