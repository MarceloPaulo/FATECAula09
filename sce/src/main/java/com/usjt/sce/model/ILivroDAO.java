package com.usjt.sce.model;

public interface ILivroDAO {
	int adiciona(Livro livro);

	int exclui(String isbn);

	Livro consulta(String isbn);
}
