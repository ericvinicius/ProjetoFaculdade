package dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.Date;

import modelos.Movimentacao;
import utilities.Logger;

public class MovimentacaoDao extends MyDao {
	
	public void salva(Movimentacao mov){
		criaConexao();
		try{
			stmt = connection.prepareStatement("INSERT INTO Movimentacao (valor, data, idCliente, idClienteDestino) "
					+ "VALUES (?, ?, ?, ?)");
			
			stmt.setBigDecimal(1, mov.getValor());
			stmt.setTimestamp(2, new Timestamp(Date.from(mov.getData().atZone(ZoneId.systemDefault()).toInstant()).getTime()));
			stmt.setLong(3, mov.getIdCliente());
			stmt.setLong(4, mov.getIdClienteDestino());
			stmt.executeUpdate();
			
		} catch(SQLException se){
			Logger.error(se, "Erro ao salvar a movimentacao");
		}
		fechaConexao();
	}
	
}
