package com.usjt.sce.imodelo;

import com.usjt.sce.modelo.usuario.Usuario;

public interface IUsuarioDAO {
	int adiciona(Usuario usuario);
	int exclui(String ra);
	Usuario consulta(String ra);
}
