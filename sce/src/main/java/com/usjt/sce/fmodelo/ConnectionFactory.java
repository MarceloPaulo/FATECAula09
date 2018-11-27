package com.usjt.sce.fmodelo;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

import org.apache.log4j.Logger;

public class ConnectionFactory {
	private String url = "jdbc:mysql://localhost:3306/biblioteca";
	private String driver = "com.mysql.jdbc.Driver";
	private String usuario = "root";
	private String senha = "root";
	Logger logger = Logger.getLogger(ConnectionFactory.class);

	public ConnectionFactory(ConfiguraDB configura) {
		this.url = configura.getUrl();
		this.driver = configura.getDriver();
		this.usuario = configura.getUsuario();
		this.senha = configura.getSenha();
	}

	public ConnectionFactory() {
	}

	public Connection getConnection() {
		try {
			Class.forName(driver);
			return (Connection) DriverManager.getConnection(url, usuario, senha);
		} catch (CommunicationsException e) {
			logger.info("Exceção de comunicacao com o DB causa: " + e.getMessage());
			throw new RuntimeException(e);
		} catch (SQLException e) {
			logger.info("Exceção geral causa SQLException: " + e.getMessage());
			throw new RuntimeException(e);
		} catch (Exception e) {
			logger.info("Exceção geral causa: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
}