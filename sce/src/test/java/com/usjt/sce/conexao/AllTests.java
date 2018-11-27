package com.usjt.sce.conexao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.usjt.sce.emprestimo.UC09RegistraEmprestimoDeLivro;
import com.usjt.sce.livro.UC01CadastrarLivro;
import com.usjt.sce.livro.UC02ConsultarLivro;
import com.usjt.sce.livro.UC04ExcluirLivro;
import com.usjt.sce.usuario.UC05CadastrarUsuario;

@RunWith(Suite.class)
@SuiteClasses({
	UC01CadastrarLivro.class,
	UC02ConsultarLivro.class,
	UC04ExcluirLivro.class,
	UC05CadastrarUsuario.class,
	UC09RegistraEmprestimoDeLivro.class
	})
public class AllTests {}
