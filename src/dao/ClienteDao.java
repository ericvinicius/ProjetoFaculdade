package dao;

import java.sql.SQLException;

import modelos.Cliente;

public class ClienteDao extends MyDao {
	
	public Cliente buscaClientePorId(Cliente cliente){
		criaConexao();
		
		try {
			stmt = connection.prepareStatement("select * from Cliente where idCliente = ? ");
			stmt.setLong(1, cliente.getId());
			rs = stmt.executeQuery();
			
			while(rs.next()){
				cliente.setNome(rs.getString("nome"));
				cliente.setSaldo(rs.getBigDecimal("saldo"));
			}
			
		} catch (SQLException se) {
			utilites.logger.logError(se, "Erro na busca de cliente por id");
		} 
		
		fechaConexao();
		return cliente;
	}
	
	public Cliente carregaClienteComMovimentacoes(Cliente cliente){
		cliente = buscaClientePorId(cliente);
		MovimentacaoDao dao = new MovimentacaoDao();
		cliente = dao.carregaMovimentacoesDoCliente(cliente);
		return cliente;
	}
	
	public void atualizaClientePorId(Cliente cliente){
		criaConexao();
		try {
			stmt = connection.prepareStatement("update Cliente set saldo = ? where idCliente = ?");
			stmt.setBigDecimal(1, cliente.getSaldo());
			stmt.setLong(2, cliente.getId());
			stmt.executeQuery();
			
		} catch (SQLException se) {
			utilites.logger.logError(se, "Erro na busca de cliente por id");
		}
		fechaConexao();
		
	}
}
