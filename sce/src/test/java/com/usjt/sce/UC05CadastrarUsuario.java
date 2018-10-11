package com.usjt.sce;

import static org.junit.Assert.*;

import org.junit.Test;

import com.usjt.sce.model.Usuario;

public class UC05CadastrarUsuario {

	@Test
	public void CT01CadastrarUsuarioComDadosValidos() {
		try {
			// cenario
			Usuario umUsuario = new Usuario();
			// acao
			umUsuario.setRa("121212");
			umUsuario.setNome("Maria do Rosario");
		} catch (RuntimeException e) {
			// verificacao
			fail("nao deve falhar");
		}
	}
	
	@Test
	public void CT02CadastrarUsuarioComRaBranco() {
		try {
			// cenario
			Usuario umUsuario = new Usuario();
			// acao
			umUsuario.setRa("");
			umUsuario.setNome("Maria do Rosario");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("RA Inválido", e.getMessage());
		}
	}
	
	@Test
	public void CT03CadastrarUsuarioComRaNulo() {
		try {
			// cenario
			Usuario umUsuario = new Usuario();
			// acao
			umUsuario.setRa(null);
			umUsuario.setNome("Maria do Rosario");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("RA Inválido", e.getMessage());
		}
	}
	
	@Test
	public void CT04CadastrarUsuarioComNomeBranco() {
		try {
			// cenario
			Usuario umUsuario = new Usuario();
			// acao
			umUsuario.setRa("121212");
			umUsuario.setNome("");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Nome Inválido", e.getMessage());
		}
	}
	
	@Test
	public void CT04CadastrarUsuarioComNomeNulo() {
		try {
			// cenario
			Usuario umUsuario = new Usuario();
			// acao
			umUsuario.setRa("121212");
			umUsuario.setNome(null);
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Nome Inválido", e.getMessage());
		}
	}
	
	@Test
	public void CT05CadastrarUsuarioComSet() {
		Usuario umUsuario = new Usuario("121212","Maria do Rosario");
		try {
			System.out.println(umUsuario.getRa());
			System.out.println(umUsuario.getNome());
			
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Usuário Inválido", e.getMessage());
		}
	}

}
