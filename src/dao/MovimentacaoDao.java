package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import org.joda.time.DateTime;

import modelos.Cliente;
import modelos.Movimentacao;
import modelos.Saque;
import modelos.Transferencia;

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
			utilites.logger.logError(se, "Erro na busca de movimentacao por id");
		}
		
		fechaConexao();
		return cliente;
	}

	private <T extends Movimentacao> void getValorPadrao(T mov) {
		try {
			mov.setTipo(mov.getClass().getSimpleName());
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(rs.getTimestamp("data", cal));
			DateTime data = new DateTime(cal.getTime());
			mov.setData(data);
			
			mov.setValor(rs.getBigDecimal("valor"));
			
			mov.setNovoSaldo(rs.getBigDecimal("novoSaldo"));
			movimentacoes.add(mov);
		} catch (SQLException e) {
			utilites.logger.logError(e, "Erro de generics");
		}
	}

}
