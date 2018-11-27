package com.usjt.sce.usuario;

import org.junit.Test;

import com.usjt.sce.fmodelo.DAOFactory;
import com.usjt.sce.imodelo.IUsuarioDAO;
import com.usjt.sce.modelo.usuario.ObtemUsuario;
import com.usjt.sce.modelo.usuario.Usuario;

public class UC08ExcluirUsuario {
	/**
	 * Objetivo: Excluir o dado do banco de dados e averiguar o comportamento do
	 * sistema.
	 */
	@Test
	public void CT01ExcluirUsuarioDoBD() {
		// cenario
		Usuario usuario = ObtemUsuario.comDadosValidos();
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		IUsuarioDAO iUsuarioDAO = mySQLFactory.getUsuarioDAO();
		iUsuarioDAO.exclui(usuario.getRa());
		
	}
}
