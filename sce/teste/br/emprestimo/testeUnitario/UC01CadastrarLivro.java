package br.emprestimo.testeUnitario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.usjt.sce.modelo.livro.Livro;

public class UC01CadastrarLivro {
	
	@Test
	public void CT01CadastrarLivroComDadosValidos() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro.setIsbn("121212");
			umLivro.setTitulo("Engenharia de Software");
			umLivro.setAutor("Pressman"); 
		} catch (RuntimeException e) {
			// verificacao
			fail("nao deve falhar");
		}
	}

	@Test
	public void CT02cadastrarLivroComISBN_em_branco() {
		// cenario
		Livro livro = new Livro();
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		try {
			// acao
			livro.setIsbn("");
			//fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("ISBN inválido", e.getMessage());
		}
	}
	
	@Test
	public void CT03cadastrarLivroComISBN_nulo() {
		// cenario
		Livro livro = new Livro();
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		try {
			// acao
			livro.setIsbn(null);
			//fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("ISBN inválido", e.getMessage());
		}
	}
	
	@Test
	public void CT04cadastrarLivroComTitulo_em_branco() {
		// cenario
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setAutor("Pressman");
		try {
			// acao
			livro.setTitulo("");
			//fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Título inválido", e.getMessage());
		}
	}
	
	@Test
	public void CT05cadastrarLivroComTitulo_nulo() {
		// cenario
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setAutor("Pressman");
		try {
			// acao
			livro.setTitulo(null);
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Título inválido", e.getMessage());
		}
	}
	
	@Test
	public void CT06cadastrarLivroComAutor_em_branco() {
		// cenario
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Pressman");
		try {
			// acao
			livro.setAutor("");
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Autor inválido", e.getMessage());
		}
	}
	
	@Test
	public void CT07cadastrarLivroComAutor_nulo() {
		// cenario
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Pressman");
		try {
			// acao
			livro.setAutor(null);
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Autor inválido", e.getMessage());
		}
	}
	
	@Test
	public void CT08cadastrarLivroComSucesso() {
		// cenario
		Livro livro = new Livro();
		try {
			// acao
			livro.getAutor();
			livro.getIsbn();
			livro.getTitulo();
		} catch (RuntimeException e) {
			// verificacao
			fail("não deveria falhar");
		}
	}
}
