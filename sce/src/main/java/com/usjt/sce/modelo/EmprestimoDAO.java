package com.usjt.sce.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.usjt.sce.fmodelo.MySQLDAOFactory;
import com.usjt.sce.imodelo.IEmprestimoDAO;
import com.usjt.sce.modelo.emprestimo.Emprestimo;

public class EmprestimoDAO implements IEmprestimoDAO {
	Logger logger = Logger.getLogger(EmprestimoDAO.class);

	@Override
	public int adiciona(Emprestimo emprestimo) {
		PreparedStatement ps;
		int codigoRetorno = 0;
		try (Connection conn = MySQLDAOFactory.createConnection()) {
			ps = (PreparedStatement) conn.prepareStatement(
					"insert into Emprestimo (emprestimoNumero, dataEmprestimo, dataDevolucao, Livro_isbn, Usuario_ra) values(?,?,?,?,?)");
			ps.setInt(1, emprestimo.getEmprestimoNumero());
			ps.setString(2, emprestimo.getDataEmprestimo());
			ps.setString(3, emprestimo.getDataDevolucao());
			ps.setString(4, emprestimo.getLivro().getIsbn());
			ps.setString(5, emprestimo.getUsuario().getRa());
			codigoRetorno = ps.executeUpdate();
			logger.info("codigo de retorno do método adiciona empréstimo = " + codigoRetorno);
			ps.close();
		} catch (SQLException e) {
			logger.info("erro = " + e.getMessage());
			throw new RuntimeException(e);
		}
		return codigoRetorno;
	}

	@Override
	public int exclui(int emprestimoNumero) {
		java.sql.PreparedStatement ps;
		int codigoRetorno = 0;
		try (Connection conn = MySQLDAOFactory.createConnection()) {
			ps = conn.prepareStatement("delete from Emprestimo where emprestimoNumero = ?");
			ps.setInt(1, emprestimoNumero);
			codigoRetorno = ps.executeUpdate();
			logger.info("codigo de retorno do metodo exclui emprestimo = " + codigoRetorno);
			ps.close();
		} catch (SQLException e) {
			logger.info("erro = " + e.getMessage());
			throw new RuntimeException(e);
		}
		return codigoRetorno;
	}

	@Override
	public Emprestimo consulta(int emprestimoNumero) {
		Emprestimo emprestimo = null;
		java.sql.PreparedStatement ps;
		try (Connection conn = MySQLDAOFactory.createConnection()) {
			ps = conn.prepareStatement("select * from Emprestimo where emprestimoNumero = ?");
			ps.setInt(1, emprestimoNumero);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				emprestimo = new Emprestimo();
				emprestimo.setEmprestimoNumero(resultSet.getInt("emprestimoNumero"));
				emprestimo.setDataEmprestimo(resultSet.getString("dataEmprestimo"));
				emprestimo.setDataDevolucao(resultSet.getString("dataDevolucao"));
			}
			resultSet.close();
			ps.close();
		} catch (SQLException e) {
			logger.info("erro método consulta empréstimo = " + e.getMessage());
		} catch (Exception e) {
			logger.info("erro método consulta empréstimo = " + e.getMessage());
		}
		return emprestimo;
	}
}
