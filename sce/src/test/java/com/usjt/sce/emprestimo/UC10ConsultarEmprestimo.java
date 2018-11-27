package com.usjt.sce.emprestimo;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.usjt.sce.fmodelo.DAOFactory;
import com.usjt.sce.imodelo.IEmprestimoDAO;
import com.usjt.sce.modelo.emprestimo.ObtemEmprestimo;
import com.usjt.sce.modelo.emprestimo.Emprestimo;

public class UC10ConsultarEmprestimo {
	/**
	 * Objetivo: verificar o comportamento do sistema na consulta de usuario com
	 * data inválida.
	 */
	@Test
	public void CT01ConsultarUsuarioComDataInvalida() {
		// cenario
		Emprestimo emprestimo = ObtemEmprestimo.comDadosValidos();
		Emprestimo resultadoObtido = null;
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		IEmprestimoDAO iEmprestimoDAO = mySQLFactory.getEmprestimoDAO();
		// acao
		resultadoObtido = iEmprestimoDAO.consulta(emprestimo.getEmprestimoNumero());
		// verificacao
		assertFalse(resultadoObtido.equals(emprestimo));
	}
}
