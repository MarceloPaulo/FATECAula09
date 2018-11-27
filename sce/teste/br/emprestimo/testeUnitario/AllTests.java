package br.emprestimo.testeUnitario;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	UC01CadastrarLivro.class,
	UC05CadastrarUsuario.class
})
public class AllTests {

}
