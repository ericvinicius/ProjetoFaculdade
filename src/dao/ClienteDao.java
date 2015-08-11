package dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import utilities.Logger;
import modelos.Cliente;
import modelos.Movimentacao;
import modelos.Saque;
import modelos.Transferencia;

public class ClienteDao extends MyDao {

	public Cliente carregaCliente(Cliente cliente) {
		criaConexao();

		try {
			stmt = connection.prepareStatement("select * from Cliente c join Movimentacao m on c.idCliente = m.idCliente where c.idCliente = ?");
			stmt.setLong(1, cliente.getId());
			rs = stmt.executeQuery();
			
			if(rs.next()){
				cliente.setNome(rs.getString("nome"));
				cliente.setSaldo(rs.getBigDecimal("saldo"));
			}

			movimentacoes = new ArrayList<Movimentacao>();
			while (rs.next()) {
				long id = rs.getLong("idMovimentacao");
				BigDecimal valor = rs.getBigDecimal("valor");
				Timestamp data = rs.getTimestamp("data");
				BigDecimal novoSaldo = rs.getBigDecimal("novoSaldo");
				String tipo = rs.getString("tipo");
				long idCliente = cliente.getId();
				
				if(tipo.equals("transferencia")){
					String agenciaDestino = rs.getString("agenciaDestino");
					String contaDestino = rs.getString("contaDestino");
					Transferencia transferencia = new Transferencia(id, valor, data, novoSaldo, contaDestino, agenciaDestino, idCliente);
					movimentacoes.add(transferencia);
					
				} else {
					Saque saque = new Saque(id, valor, data, novoSaldo, idCliente);
					movimentacoes.add(saque);
					
				}	
			}
			cliente.setMovimentacoes(movimentacoes);

		} catch (SQLException se) {
			Logger.logError(se, "Erro na busca de cliente por id");
		}

		fechaConexao();
		return cliente;
	}

	public void atualizaClientePorId(Cliente cliente) {
		criaConexao();
		try {
			stmt = connection.prepareStatement("update Cliente set saldo = ? where idCliente = ?");
			stmt.setBigDecimal(1, cliente.getSaldo());
			stmt.setLong(2, cliente.getId());
			stmt.executeQuery();

		} catch (SQLException se) {
			Logger.logError(se, "Erro na busca de cliente por id");
		}
		fechaConexao();

	}
}
