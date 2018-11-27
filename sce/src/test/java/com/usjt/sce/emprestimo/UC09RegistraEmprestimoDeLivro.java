package com.usjt.sce.emprestimo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import com.usjt.sce.fmodelo.DAOFactory;
import com.usjt.sce.imodelo.IEmprestimoDAO;
import com.usjt.sce.modelo.emprestimo.Emprestimo;
import com.usjt.sce.modelo.emprestimo.ObtemEmprestimo;
import com.usjt.sce.modelo.livro.Livro;
import com.usjt.sce.modelo.usuario.Usuario;
import com.usjt.sce.servico.ServicoEmprestimo;

public class UC09RegistraEmprestimoDeLivro {
	static private Livro livro;
	static private Usuario usuario;
	static private ServicoEmprestimo servico;

	/**
	 * Script de teste para realizar o teste integrado Empréstimo, Livro e Usuário
	 * sem o uso do DataBuilder
	 */
	@Test
	public void CT01RegistraEmprestimoDeLivro_com_sucesso() {
		// cenário
		livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		usuario = new Usuario();
		usuario.setRa("1111");
		usuario.setNome("Jose da Silva");
		servico = new ServicoEmprestimo();
		// ação
		Emprestimo resultadoEsperado = servico.empresta(livro, usuario);
		// verificação
		assertNotNull(resultadoEsperado);
	}

	/**
	 * Caso de teste para realizar o teste integrado Empréstimo, Livro e Usuário
	 * usando DataBuilder
	 */
	@Test
	public void CT02RegistraEmprestimoDeLivroComDataBuilder() {
		// cenário
		Emprestimo emprestimo = null;
		// ação
		emprestimo = ObtemEmprestimo.comDadosValidos();
		// verificação
		assertNotNull(emprestimo);
	}

	/**
	 * Script de teste para verificar a validação de data
	 */
	@Test
	public void CT03UC01FBRegistraEmprestimoComSucessoValidacaoDaData() {
		// cenário
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		String dataEsperada = new DateTime().plusDays(8).toString(fmt);
		// ação
		Emprestimo emprestimo = ObtemEmprestimo.comDadosValidos();
		String dataObtida = emprestimo.getDataDevolucao();
		// verificacao
		assertTrue(dataEsperada.equals(dataObtida));
	}

	/**
	 * Script de teste para verificar serviço com livro inválido nulo
	 */
	@Test
	public void CT04RegistraServicoEmprestimoDeLivroComLivroInvalidoNulo() {
		// cenário
		Emprestimo emprestimo = null;
		try {
			// ação
			emprestimo = ObtemEmprestimo.comServicoLivroInvalidoNulo();
		} catch (RuntimeException e) {
			assertNull(emprestimo);
		}
	}

	/**
	 * Script de teste para verificar serviço com usuario inválido nulo
	 */
	@Test
	public void CT05RegistraServicoEmprestimoDeLivroComUsuarioInvalidoNulo() {
		// cenário
		Emprestimo emprestimo = null;
		try {
			// ação
			emprestimo = ObtemEmprestimo.comServicoUsuarioInvalidoNulo();
		} catch (Exception e) {
			//verificação
			assertNull(emprestimo);
		}
	}

	/**
	 * Script de teste para verificar livro inválido nulo
	 */
	@Test
	public void CT06RegistraEmprestimoDeLivroComLivroInvalidoNulo() {
		// cenário
		Emprestimo emprestimo = null;
		try {
			// ação
			emprestimo = ObtemEmprestimo.comLivroInvalidoNulo();
		} catch (RuntimeException e) {
			//verificação
			assertNull(emprestimo);
		}
	}

	/**
	 * Script de teste para verificar usuário inválido nulo
	 */
	@Test
	public void CT07RegistraEmprestimoDeLivroComUsuarioInvalidoNulo() {
		// cenário
		Emprestimo emprestimo = null;
		try {
			// ação
			emprestimo = ObtemEmprestimo.comUsuarioInvalidoNulo();
		} catch (Exception e) {
			//verificação
			assertNull(emprestimo);
		}
	}

	/**
	 * Script de teste para verificar formato de data inválida diferente
	 */
	@Test
	public void CT08RegistraEmprestimoDeLivroComDataDiferente() {
		// cenário
		@SuppressWarnings("unused")
		Emprestimo emprestimo = null;
		// ação e verificação
		emprestimo = ObtemEmprestimo.comDataDiferente();
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de empréstimo em
	 * banco de dados ainda não registrado.
	 */
	@Test
	public void CT09RegistraEmprestimoComExitoEmBD() {
		// cenário
		Emprestimo emprestimo = ObtemEmprestimo.comDadosValidos();
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		IEmprestimoDAO iEmprestimoDAO = mySQLFactory.getEmprestimoDAO();
		int codigoRetorno = 0;
		// ação
		codigoRetorno = iEmprestimoDAO.adiciona(emprestimo);
		//verificação
		assertEquals(1, codigoRetorno);
	}

	/**
	 * Objetivo - verificar o comportamento do metodo ehDomigo() para uma data com
	 * formato válido e dia inválido (domingo).
	 */
	@Test
	public void CT10SeDataDevolucaoForDomingoRetornaTrue() {
		// cenário
		String data = "2018/09/02"; // domingo
		// ação
		Emprestimo emprestimo = new Emprestimo();
		// verificação
		assertTrue(emprestimo.ehDomingo(data));
	}
	
	/**
	 * Objetivo - verificar o comportamento do metodo ehDomigo() para uma data com
	 * formato válido e dia válido (não domingo).
	 */
	@Test
	public void CT11SeDataDevolucaoNAOForDomingoRetornaFalse() {
		// cenário
		String data = "2018/09/03"; // não domingo
		// ação
		Emprestimo emprestimo = new Emprestimo();
		// verificação
		assertFalse(emprestimo.ehDomingo(data));
	}
	
	/**
	 * Objetivo - verificar o comportamento do metodo para uma data com
	 * formato válido e dia inválido (2018/02/30).
	 */
	@Test
	public void CT12SeDataDevolucaoForInvalidaRetornaFalse() {
		// cenário
		String data = "uma data"; // data inválida
		// ação
		Emprestimo emprestimo = new Emprestimo();
		// verificação
		assertFalse(emprestimo.ehDomingo(data));
	}

	/**
	 * verifica o comportamento do método devolução da classe ServiçoEmprestimo
	 * para um empréstimo com data de devolução vencida.
	 */
	@Test
	public void CT13QuandoEntregaAtrasadoQuantDiasNegativo() {
		// cenario
		Emprestimo emprestimo = ObtemEmprestimo.comDataDeDevolucaoVencida();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		// acao
		int quantDias = servico.devolucao(emprestimo);
		// verificacao
		// quantidade de dias entre a data de empréstimo e a de devolucao
		assertTrue(quantDias < 0); // Quant de dias entre a data de emprestimo e a de devolucao
	}
	
	/**
	 * verifica o comportamento do método devolução da classe ServiçoEmprestimo
	 * para um empréstimo com data de devolução para o dia seguinte.
	 */
	@Test
	public void CT14QuandoEntregaAdiantadoDiaSeguinte() {
		// cenario
		Emprestimo emprestimo = ObtemEmprestimo.comDevolucaoDiaSeguinte();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		// acao
		int quantDias = servico.devolucao(emprestimo);
		// verificacao
		// quantidade de dias entre a data de empréstimo e a de devolucao
		assertTrue(quantDias == 1); // Devolução no dia seguinte - faz o between, poderia usar o assertTrue == 1 e plusDays(2)
	}
	
	/**
	 * verifica o comportamento do método devolução da classe ServiçoEmprestimo
	 * para um empréstimo com data de devolução para o mesmo dia.
	 */
	@Test
	public void CT15QuandoEntregaNoMesmoDia() {
		// cenario
		Emprestimo emprestimo = ObtemEmprestimo.comDevolucaoMesmoDia();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		// acao
		int quantDias = servico.devolucao(emprestimo);
		// verificacao
		// quantidade de dias entre a data de empréstimo e a de devolucao
		assertTrue(quantDias == 0);
	}
}