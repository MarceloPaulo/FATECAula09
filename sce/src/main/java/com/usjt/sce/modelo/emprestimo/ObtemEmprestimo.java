package com.usjt.sce.modelo.emprestimo;

import static org.junit.Assert.assertNotEquals;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.usjt.sce.modelo.livro.Livro;
import com.usjt.sce.modelo.livro.ObtemLivro;
import com.usjt.sce.modelo.usuario.ObtemUsuario;
import com.usjt.sce.modelo.usuario.Usuario;
import com.usjt.sce.servico.ServicoEmprestimo;

public class ObtemEmprestimo {
	public static Emprestimo comDadosValidos() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(livro, aluno);
	}

	public static Emprestimo comServicoLivroInvalidoNulo() {
		Usuario aluno = ObtemUsuario.comDadosValidos();
		Livro livro = null;
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(livro, aluno);
	}

	public static Emprestimo comServicoUsuarioInvalidoNulo() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = null;
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(livro, aluno);
	}

	public static Emprestimo comLivroInvalidoNulo() {
		Livro livro = null;
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setLivro(livro);
		return emprestimo;
	}

	public static Emprestimo comUsuarioInvalidoNulo() {
		Usuario usuario = null;
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setUsuario(usuario);
		return emprestimo;
	}

	public static Emprestimo comDataDiferente() {
		Emprestimo emprestimo = new Emprestimo();
		try {
			emprestimo.setDataEmprestimo("30-10-2018");
		} catch (RuntimeException e) {
			assertNotEquals("Values should be different.", e.getMessage());
		}
		return emprestimo;
	}
	
	public static Emprestimo comDataDeDevolucaoVencida() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		Emprestimo umEmprestimo = servico.empresta(livro, aluno);
		DateTime dataAtual = new DateTime();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		umEmprestimo.setDataEmprestimo(dataAtual.minusDays(12).toString(fmt));
		umEmprestimo.setDataDevolucao(dataAtual.minusDays(4).toString(fmt));
		return umEmprestimo;
	}
	
	public static Emprestimo comDevolucaoDiaSeguinte() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		Emprestimo emprestimo = servico.empresta(livro, aluno);
		DateTime dataAtual = new DateTime();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		emprestimo.setDataEmprestimo(dataAtual.plusDays(1).toString(fmt));
		emprestimo.setDataDevolucao(dataAtual.plusDays(2).toString(fmt));
		return emprestimo;
	}
	
	public static Emprestimo comDevolucaoMesmoDia() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		Emprestimo emprestimo = servico.empresta(livro, aluno);
		DateTime dataAtual = new DateTime();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		emprestimo.setDataEmprestimo(dataAtual.toString(fmt));
		emprestimo.setDataDevolucao(dataAtual.toString(fmt));
		return emprestimo;
	}
}
