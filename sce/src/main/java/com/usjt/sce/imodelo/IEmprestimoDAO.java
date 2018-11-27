package com.usjt.sce.imodelo;

import com.usjt.sce.modelo.emprestimo.Emprestimo;

public interface IEmprestimoDAO {
	int adiciona(Emprestimo emprestimo);
	int exclui(int emprestimoNumero);
	Emprestimo consulta(int emprestimoNumero);
}
