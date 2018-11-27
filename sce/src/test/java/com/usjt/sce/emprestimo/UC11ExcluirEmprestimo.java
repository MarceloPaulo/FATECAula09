package com.usjt.sce.emprestimo;

import org.junit.Test;

import com.usjt.sce.fmodelo.DAOFactory;
import com.usjt.sce.imodelo.IEmprestimoDAO;
import com.usjt.sce.modelo.emprestimo.Emprestimo;
import com.usjt.sce.modelo.emprestimo.ObtemEmprestimo;

public class UC11ExcluirEmprestimo {
	/**
	 * Objetivo: Excluir o dado do banco de dados e averiguar o comportamento do
	 * sistema.
	 */
	@Test
	public void CT01ExcluirEmprestimoDoBD() {
		// cenario
		Emprestimo emprestimo = ObtemEmprestimo.comDadosValidos();
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		IEmprestimoDAO iEmprestimoDAO = mySQLFactory.getEmprestimoDAO();
		iEmprestimoDAO.exclui(emprestimo.getEmprestimoNumero());
	}
}
