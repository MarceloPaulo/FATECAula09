package com.usjt.sce.modelo.usuario;

public class ObtemUsuario {
	public static Usuario comDadosValidos() {
		Usuario aluno = new Usuario();
		aluno.setRa("121212");
		aluno.setNome("Jose Carlos");
		return aluno;
		}

	public static Usuario comNome_branco() {
		Usuario usuario = new Usuario();
		usuario.setRa("121212");
		usuario.setNome("");
		return usuario;
	}

	public static Usuario comNome_nulo() {
		Usuario usuario = new Usuario();
		usuario.setRa("121212");
		usuario.setNome(null);
		return usuario;
	}
	
	public static Usuario comRA_branco() {
		Usuario usuario = new Usuario();
		usuario.setNome("Jose Carlos");
		usuario.setRa("");
		return usuario;
	}

	public static Usuario comRA_nulo() {
		Usuario usuario = new Usuario();
		usuario.setNome("Jose Carlos");
		usuario.setRa(null);
		return usuario;
	}
}
