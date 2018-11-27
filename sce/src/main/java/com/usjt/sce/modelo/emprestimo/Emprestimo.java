package com.usjt.sce.modelo.emprestimo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.usjt.sce.modelo.livro.Livro;
import com.usjt.sce.modelo.usuario.Usuario;

public class Emprestimo {
	private Livro livro;
	private Usuario usuario;
	private int emprestimoNumero;
	private String dataEmprestimo;
	private String dataDevolucao;

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		if (livro != null) {
			this.livro = livro;
		} else {
			throw new RuntimeException("Dados inválidos.");
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		if (usuario != null) {
			this.usuario = usuario;
		} else {
			throw new RuntimeException("Dados inválidos.");
		}
	}

	public int getEmprestimoNumero() {
		return emprestimoNumero;
	}

	public void setEmprestimoNumero(int emprestimoNumero) {
		this.emprestimoNumero = emprestimoNumero;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		if (validaData(dataEmprestimo) == true) {
			this.dataEmprestimo = dataEmprestimo;
		} else {
			throw new RuntimeException("Data inválida.");
		}
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	/**
	 * valida o formato da data
	 * 
	 * @param data no formato YYYY/MM/dd
	 * @return true se a data estiver no formato válido e false para formato
	 *         inválido.
	 */
	private boolean validaData(String data) {
		DateFormat df = new SimpleDateFormat("YYYY/MM/dd");
		df.setLenient(false); //
		try {
			df.parse(data); // data válida
			return true;
		} catch (ParseException ex) {
			return false;
		}
	}

	/**
	 * Verifica se o dia da semana é domingo
	 * 
	 * @param data no formato YYYY/MM/dd
	 * @return false se o dia da semana não for domingo e true para o domingo.
	 */
	public boolean ehDomingo(String data) {
		boolean isValida = false;
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		if (validaData(data) == true) {
			DateTime umaData = fmt.parseDateTime(data);
			if (umaData.dayOfWeek().getAsText().equals("Domingo")) {
				isValida = true;
			} 
		} 
		return isValida;
	}
}