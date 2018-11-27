package com.usjt.sce.livro;

import org.junit.Test;

import com.usjt.sce.fmodelo.DAOFactory;
import com.usjt.sce.imodelo.ILivroDAO;
import com.usjt.sce.modelo.livro.Livro;
import com.usjt.sce.modelo.livro.ObtemLivro;

public class UC04ExcluirLivro {
	/**
	 * Objetivo: Excluir o dado do banco de dados e averiguar o comportamento do
	 * sistema.
	 */
	@Test
	public void CT01ExcluirLivroDoBD() {
		// cenario
		Livro livro = ObtemLivro.comDadosValidos();
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ILivroDAO livroDAO = mySQLFactory.getLivroDAO();
		livroDAO.exclui(livro.getIsbn());
		
	}
}
