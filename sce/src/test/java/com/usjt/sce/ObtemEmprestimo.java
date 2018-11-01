package com.usjt.sce;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.usjt.sce.model.Emprestimo;
import com.usjt.sce.model.Livro;
import com.usjt.sce.model.Usuario;
import com.usjt.sce.servico.ServicoEmprestimo;

public class ObtemEmprestimo {
	public static Emprestimo comDadosValidos() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(livro, aluno);
	}
	
	public static Emprestimo comAutorInvalido_branco() {
		Livro livro = ObtemLivro.comAutorInvalido_branco();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(livro, aluno);
	}
	
	public static Emprestimo comAutorInvalido_nulo() {
		Livro livro = ObtemLivro.comAutorInvalido_nulo();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(livro, aluno);
	}
	
	public static Emprestimo comIsbnInvalido_branco() {
		Livro livro = ObtemLivro.comISBNInvalido_branco();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(livro, aluno);
	}
	
	public static Emprestimo comIsbnInvalido_nulo() {
		Livro livro = ObtemLivro.comISBNInvalido_nulo();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(livro, aluno);
	}
	
	public static Emprestimo comTituloInvalido_branco() {
		Livro livro = ObtemLivro.comTituloInvalido_branco();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(livro, aluno);
	}
	
	public static Emprestimo comTituloInvalido_nulo() {
		Livro livro = ObtemLivro.comTituloInvalido_nulo();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(livro, aluno);
	}
	
	public static Emprestimo comUsuarioInvalido_comNome_branco() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comNome_branco();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(livro, aluno);
	}
	
	public static Emprestimo comUsuarioInvalido_comNome_nulo() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comNome_nulo();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(livro, aluno);
	}
	
	public static Emprestimo comUsuarioInvalido_comRA_branco() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comRA_branco();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(livro, aluno);
	}
	
	public static Emprestimo comUsuarioInvalido_comRA_nulo() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comRA_nulo();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(livro, aluno);
	}
	
	@Test
	public void CT01RegistraEmprestimoDeLivro_com_sucesso() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comRA_nulo();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		Emprestimo resultadoEsperado = servico.empresta(null, aluno);
		// verificação
		assertNotNull(resultadoEsperado);
	}
}
