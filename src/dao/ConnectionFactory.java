package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utilities.Utilites;

public class ConnectionFactory {
	
	private Utilites utilites = new Utilites();
	
	public Connection getConnection() {
		try {
			//Para conexao local = jdbc:mysql://localhost:3307/projetoIntegrado", "root", ""
			return DriverManager.getConnection("jdbc:mysql://localhost:3307/projetoIntegrado", "root", "");
		} catch (SQLException se) {
			utilites.logger.logError(se, "Erro na criacao de conexao");
			throw new RuntimeException(se);
		}
	}
}
