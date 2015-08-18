package dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.Date;

import modelos.Transferencia;
import utilities.Logger;

public class MovimentacaoDao extends MyDao {
	
	public void salva(Transferencia transferencia){
		criaConexao();
		try{
			stmt = connection.prepareStatement("INSERT INTO Movimentacao (valor, data, novoSaldo, tipo, agenciaDestino, contaDestino, idCliente) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ? )");
			
			stmt.setBigDecimal(1, transferencia.getValor());
			stmt.setTimestamp(2, new Timestamp(Date.from(transferencia.getData().atZone(ZoneId.systemDefault()).toInstant()).getTime()));
			stmt.setBigDecimal(3, transferencia.getNovoSaldo());
			stmt.setString(4, transferencia.getTipo());
			stmt.setString(5, transferencia.getAgenciaDestino());
			stmt.setString(6, transferencia.getContaDestino());
			stmt.setLong(7, transferencia.getIdCliente());
			stmt.executeUpdate();
			
		} catch(SQLException se){
			Logger.logError(se, "Erro ao salvar a movimentacao");
		}
		fechaConexao();
	}
	
}
