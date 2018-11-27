package com.usjt.sce.imodelo;

import com.usjt.sce.modelo.livro.Livro;

public interface ILivroDAO {
	int adiciona(Livro livro);
	int exclui(String isbn);
	Livro consulta(String isbn);
}
