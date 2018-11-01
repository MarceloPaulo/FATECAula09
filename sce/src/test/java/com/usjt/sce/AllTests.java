package com.usjt.sce;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestaConexaoComDB.class, UC01CadastrarLivro.class, UC05CadastrarUsuario.class,
		UC09RegistraEmprestimoDeLivro.class })
public class AllTests {

}
