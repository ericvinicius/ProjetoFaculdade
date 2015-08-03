package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import model.Cliente;
import model.Movimentacao;
import model.Saque;
import model.Transferencia;

public class MovimentacaoDao extends MyDao {

	private ArrayList<Movimentacao> movimentacoes;

	public Cliente carregaMovimentacoesDoCliente(Cliente cliente) {
		criaConexao();

		try {
			stmt = connection.prepareStatement("select * from Movimentacao where idCliente = ? ");
			stmt.setLong(1, cliente.getId());
			rs = stmt.executeQuery();

			
			movimentacoes = new ArrayList<Movimentacao>();
			while (rs.next()) {
				String tipo = rs.getString("tipo");
				if(tipo.equals("transferencia")){
					Transferencia transferencia = new Transferencia();
					rs.getString("agenciaDestino");
					getValorPadrao(transferencia);
					
				} else if(tipo.equals("saque")){
					Saque saque = new Saque();
					getValorPadrao(saque);
					
				} else {
					Movimentacao movimentacao = new Movimentacao();
					getValorPadrao(movimentacao);
					
				}
				
			}
			cliente.setMovimentacoes(movimentacoes);
		} catch (SQLException se) {
			utilites.logger.logError(se, "Erro na busca de cliente por id");
		}
		
		fechaConexao();
		return cliente;
	}

	private <T extends Movimentacao> void getValorPadrao(T mov) {
		try {
			mov.setTipo(mov.getClass().getTypeName().substring(6));
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(rs.getDate("data", cal));
			mov.setData(cal);
			
			mov.setValor(rs.getBigDecimal("valor"));
			
			mov.setNovoSaldo(rs.getBigDecimal("novoSaldo"));
			System.out.println(mov.getNovoSaldo());
			
			movimentacoes.add(mov);
		} catch (SQLException e) {
			utilites.logger.logError(e, "Erro de generics");
		}
	}

}
