package com.usjt.sce;

import com.usjt.sce.model.Usuario;

public class ObtemUsuario {
	public static Usuario comDadosValidos() {
		Usuario usuario = new Usuario();
		usuario.setNome("Maria do Rosario");
		usuario.setRa("121212");
		return usuario;
	}

	public static Usuario comNome_branco() {
		Usuario usuario = new Usuario();
		usuario.setNome("");
		usuario.setRa("121212");
		return usuario;
	}

	public static Usuario comNome_nulo() {
		Usuario usuario = new Usuario();
		usuario.setNome(null);
		usuario.setRa("121212");
		return usuario;
	}
	
	public static Usuario comRA_branco() {
		Usuario usuario = new Usuario();
		usuario.setNome("Maria do Rosario");
		usuario.setRa("");
		return usuario;
	}

	public static Usuario comRA_nulo() {
		Usuario usuario = new Usuario();
		usuario.setNome("Maria do Rosario");
		usuario.setRa(null);
		return usuario;
	}
}
