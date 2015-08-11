package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.Movimentacao;
import utilities.Logger;
import utilities.Utilites;

public class MyDao {
	
	protected Connection connection = null;
	protected PreparedStatement stmt = null;
	protected ResultSet rs = null;

	protected ArrayList<Movimentacao> movimentacoes;
	
	protected Utilites utilites = new Utilites();
	//TODO: adicionar tudo aos log
	
	protected void criaConexao(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	protected void fechaConexao(){
		try {
			if(rs != null ){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(connection != null){
				connection.close();
			}
		} catch (SQLException se) {
			Logger.logError(se, "Erro ao fechar a conexao");
		}
	}
	
}
