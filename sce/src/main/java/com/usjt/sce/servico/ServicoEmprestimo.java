package com.usjt.sce.servico;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.usjt.sce.modelo.emprestimo.Emprestimo;
import com.usjt.sce.modelo.livro.Livro;
import com.usjt.sce.modelo.usuario.Usuario;

public class ServicoEmprestimo {
	public Emprestimo empresta(Livro livro, Usuario usuario) {
		if (livro == null | usuario == null) {
			throw new RuntimeException("Dados inválidos.");
		} else {
			Emprestimo emprestimo = new Emprestimo();
			emprestimo.setEmprestimoNumero(123);
			emprestimo.setLivro(livro);
			emprestimo.setUsuario(usuario);

			// data do emprestimo - data atual do sistema
			DateTime dataAtual = new DateTime();
			DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
			emprestimo.setDataEmprestimo(dataAtual.toString(fmt));

			// prazo de devolucao 8 dias
			DateTime dataDevolucao = fmt.parseDateTime(emprestimo.getDataEmprestimo());
			emprestimo.setDataDevolucao(dataDevolucao.plusDays(8).toString(fmt));
			return emprestimo;
		}
	}

	/**
	 * Objetivo - verifica se a devolução esta atrasada
	 *
	 * @param emprestimo
	 * @return int < 0 se estiver atrasado e > 0 se estive no prazo
	 */
	public int devolucao(Emprestimo emprestimo) {
		DateTime dataAtual = new DateTime();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		DateTime dataDevolucao = fmt.parseDateTime(emprestimo.getDataDevolucao());
		int dias = Days.daysBetween(dataAtual, dataDevolucao).getDays();
		return dias;
	}
}
