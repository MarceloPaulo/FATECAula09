package com.usjt.sce.fmodelo;

import com.mysql.jdbc.Connection;
import com.usjt.sce.imodelo.IEmprestimoDAO;
import com.usjt.sce.imodelo.IUsuarioDAO;
import com.usjt.sce.modelo.EmprestimoDAO;
import com.usjt.sce.modelo.LivroDAO;
import com.usjt.sce.modelo.UsuarioDAO;

public class MySQLDAOFactory extends DAOFactory {
	
	public static Connection createConnection() {
		return (Connection) new ConnectionFactory().getConnection();
	}

	@Override
	public LivroDAO getLivroDAO() {
		return new LivroDAO();
	}

	@Override
	public IUsuarioDAO getUsuarioDAO() {
		return new UsuarioDAO();
	}

	@Override
	public IEmprestimoDAO getEmprestimoDAO() {
		return new EmprestimoDAO();
	}
}