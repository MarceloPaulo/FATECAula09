package com.usjt.sce.fmodelo;

import com.usjt.sce.imodelo.IEmprestimoDAO;
import com.usjt.sce.imodelo.ILivroDAO;
import com.usjt.sce.imodelo.IUsuarioDAO;

//Abstract class DAO Factory
public abstract class DAOFactory {
	// List of DAO types supported by the factory
	public static final int MYSQL = 1;
	public static final int ORACLE = 2;
	public static final int SQLSERVER = 3;

	public abstract ILivroDAO getLivroDAO();
	public abstract IUsuarioDAO getUsuarioDAO();
	public abstract IEmprestimoDAO getEmprestimoDAO();

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
		case MYSQL:
			return new MySQLDAOFactory();
		// case ORACLE: return new OracleDAOFactory();
		// case SQLSERVER: return new SQLServerDAOFactory();
		default:
			return null;
		}
	}
}
