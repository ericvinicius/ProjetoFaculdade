package dao;

import java.sql.SQLException;
import java.sql.Timestamp;

import modelos.Transferencia;

public class MovimentacaoDao extends MyDao {
	
	public void salva(Transferencia transferencia){
		criaConexao();
		try{
			stmt = connection.prepareStatement("INSERT INTO Movimentacao (`valor`, `data`, `novoSaldo`, `tipo`, `agenciaDestino`, `contaDestino`, `idCliente`) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?");
			
			Timestamp data = new Timestamp(transferencia.getData().getMillis());
			stmt.setBigDecimal(1, transferencia.getNovoSaldo());
			stmt.setTimestamp(2, data);
			stmt.setBigDecimal(3, transferencia.getNovoSaldo());
			stmt.setString(4, transferencia.getTipo());
			stmt.setString(5, transferencia.getAgenciaDestino());
			stmt.setString(6, transferencia.getContaDestino());
			stmt.setLong(7, transferencia.getIdCliente());
			stmt.executeQuery();
			
			
		} catch(SQLException se){
			utilites.logger.logError(se, "Erro ao salvar a movimentacao");
		}
		fechaConexao();
	}
	
}
