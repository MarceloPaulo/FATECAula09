package br.emprestimo.testeUnitario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.usjt.sce.modelo.usuario.Usuario;

public class UC05CadastrarUsuario {
	@Test
	public void CT01CadastrarUsuarioComDadosValidos() {
		try {
			// cenario
			Usuario usuario = new Usuario();
			// acao
			usuario.setNome("Marcelo");
			usuario.setRa("121212");
		} catch (RuntimeException e) {
			// verificacao
			fail("nao deve falhar");
		}
	}
	
	@Test
	public void CT02CadastrarUsuarioComNomeEmBranco() {
		// cenario
		Usuario usuario = new Usuario();
		usuario.setRa("121212");
		try {
			// acao
			usuario.setNome("");
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Nome inválido", e.getMessage());
		}
	}
	
	@Test
	public void CT03CadastrarUsuarioComNomeNulo() {
		// cenario
		Usuario usuario = new Usuario();
		usuario.setRa("121212");
		try {
			// acao
			usuario.setNome(null);
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Nome inválido", e.getMessage());
		}
	}
	
	@Test
	public void CT04CadastrarUsuarioComRaEmBranco() {
		// cenario
		Usuario usuario = new Usuario();
		usuario.setNome("Marcelo");
		try {
			// acao
			usuario.setRa("");
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("RA inválido", e.getMessage());
		}
	}
	
	@Test
	public void CT05CadastrarUsuarioComRaNulo() {
		// cenario
		Usuario usuario = new Usuario();
		usuario.setNome("Marcelo");
		try {
			// acao
			usuario.setRa(null);
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("RA inválido", e.getMessage());
		}
	}
}
