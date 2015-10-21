package dao;

import java.math.BigDecimal;
import java.sql.SQLException;

import modelos.Conta;
import utilities.Logger;

public class ContaDao extends MyDao {
	
	public BigDecimal loadSaldo(Conta c){
		criaConexao();
		BigDecimal saldo = BigDecimal.ZERO;
		try{
			stmt = connection.prepareStatement("select saldo from Conta where id = ?");
			stmt.setLong(1, c.getId());
			rs = stmt.executeQuery();
			rs.next();
			
			saldo = rs.getBigDecimal("saldo");
		} catch (SQLException se) {
			Logger.error(se, "Erro na busca de cliente por id");
		}
		fechaConexao();
		return saldo;
	}
}
