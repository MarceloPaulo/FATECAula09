package com.usjt.sce;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import com.usjt.sce.model.Emprestimo;
import com.usjt.sce.model.Livro;
import com.usjt.sce.model.Usuario;
import com.usjt.sce.servico.ServicoEmprestimo;

public class UC09RegistraEmprestimoDeLivro {
	static private Livro livro;
	static private Usuario usuario;
	static private ServicoEmprestimo servico;

	@Test
	public void CT01RegistraEmprestimoDeLivro_com_sucesso() {
		// cenario
		livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		usuario = new Usuario();
		usuario.setRa("1111");
		usuario.setNome("Jose da Silva");
		servico = new ServicoEmprestimo();
		// acao
		Emprestimo resultadoEsperado = servico.empresta(livro, usuario);
		// verificação
		assertNotNull(resultadoEsperado);
	}

	@Test
	public void CT02RegistraEmprestimoDeLivro_com_sucesso() {
		// cenario
		Emprestimo emprestimo = null;
		// acao
		emprestimo = ObtemEmprestimo.comDadosValidos();
		// verificação
		assertNotNull(emprestimo);
	}

	@Test
	public void CT02UC01FB_registra_emprestimo_com_sucesso_validacao_da_data() {
		// cenario
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy/MM/dd");
		String dataEsperada = new DateTime().plusDays(8).toString(fmt);
		@SuppressWarnings("unused")
		ServicoEmprestimo servico = null;
		// acao
		Emprestimo emprestimo = ObtemEmprestimo.comDadosValidos();
		String dataObtida = emprestimo.getDataDevolucao();
		// verificacao
		assertTrue(dataEsperada.equals(dataObtida));
	}

	/**
	 * Objetivo - verificar o comportamento do metodo ehDomigo() para uma data com
	 * formato valido dia invalido (domingo).
	 */
	@Test
	public void CT06se_data_devolucao_for_domingo_retorna_true() {
		// cenario
		String data = "2018/09/02"; // domingo
		// acao
		Emprestimo umEmprestimo = new Emprestimo();
		// verificacao
		assertTrue(umEmprestimo.ehDomingo(data));
	}

	@Test
	public void CT07_quando_entrega_eh_maior_que_data_de_devolucao() {
		// cenario
		Emprestimo umEmprestimo = ObtemEmprestimo.comDataDeDevolucaoVencida();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		// acao
		int quantDias = servico.devolucao(umEmprestimo);
		// verificacao
		assertTrue(quantDias < 0); // quant de dias entre a data de emprestimo e a de devolucao
	}
	
	@Test
	public void CT08_quando_entrega_eh_igual_data_de_devolucao() {
		// cenario
		Emprestimo umEmprestimo = ObtemEmprestimo.comDataDeDevolucaoIgualAoEmprestimo();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		// acao
		int quantDias = servico.devolucao(umEmprestimo);
		// verificacao
		assertTrue(quantDias == 0); // quant de dias entre a data de emprestimo e a de devolucao
	}
	
	@Test
	public void CT09_quando_entrega_eh_dia_seguinte_data_de_devolucao() {
		// cenario
		Emprestimo umEmprestimo = ObtemEmprestimo.comDataDeDevolucaoIgualAoEmprestimoMaisUm();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		// acao
		int quantDias = servico.devolucao(umEmprestimo);
		// verificacao
		assertTrue(quantDias > 0); // quant de dias entre a data de emprestimo e a de devolucao
	}
}