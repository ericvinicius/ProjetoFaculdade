package dao;

import idioma.Idioma;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import modelos.Cliente;
import modelos.Conta;
import modelos.Movimentacao;
import utilities.Logger;
import builders.MovimentacaoBuilder;

public class ClienteDao extends MyDao {
	private ArrayList<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();
	private MovimentacaoBuilder builder;
	private Cliente cliente;

	private BigDecimal saldoAnterior = utilites.saldoInicial;
	private BigDecimal novoSaldoMov = BigDecimal.ZERO;

	public Cliente carregaClienteComMovimentacoes(Cliente cliente) {
		criaConexao();
		this.cliente = cliente;
		Long idDoCliente = cliente.getId();
		try {
			stmt = connection.prepareStatement("select * from Cliente c "
					+ "join Movimentacao m on c.id = m.idCliente "
					+ "join Conta co on co.idCliente = c.id "
					+ "where m.idCliente = ? or m.idClienteDestino = ? "
					+ "order by m.data ASC;");
			
			stmt.setLong(1, idDoCliente);
			stmt.setLong(2, idDoCliente);
			rs = stmt.executeQuery();

			boolean precisaCarregarCliente = true;
			while (rs.next()) {
				if (precisaCarregarCliente && idDoCliente == rs.getLong("id")) {
					fazLoadDoCliente();
					precisaCarregarCliente = false;
				}

				builder = new MovimentacaoBuilder();
				Movimentacao movimentacao = constroiMovimentacao();
				pegaTipoDeMov(movimentacao);

				movimentacoes.add(movimentacao);
			}
			cliente.getConta().setMovimentacoes(movimentacoes);

		} catch (SQLException se) {
			Logger.error(se, "Erro na busca de cliente por id");
		}

		fechaConexao();
		atualizaCliente();
		
		return cliente;
	}

	private void atualizaCliente() {
		cliente.getConta().setSaldo(novoSaldoMov);
		atualizaClientePorId(cliente);
	}

	private void pegaTipoDeMov(Movimentacao mov) {
		BigDecimal valorDaMov = mov.getValor();
		Long idClienteDaMov = mov.getIdCliente();
		Long idClienteDestinoDaMov = mov.getIdClienteDestino();
		String tipoDaMov = "";
		
		if (idClienteDaMov != idClienteDestinoDaMov) {
			tipoDaMov = Idioma.getTransferencia();

			if (idClienteDaMov == cliente.getId()) {
				tipoDaMov += " - " + Idioma.getSaida();
				novoSaldoMov = saldoAnterior.subtract(valorDaMov);
			} else {
				tipoDaMov += " - " + Idioma.getEntrada();
				novoSaldoMov = saldoAnterior.add(valorDaMov);
			}
		} else {
			tipoDaMov = "Saque";
			novoSaldoMov = saldoAnterior.subtract(valorDaMov);
		}
		mov.setTipo(tipoDaMov);
		mov.setNovoSaldo(novoSaldoMov);
		saldoAnterior = novoSaldoMov;
	}

	private Movimentacao constroiMovimentacao() throws SQLException {
		Long idDaMov = rs.getLong("idMovimentacao");
		Long idClienteDaMov = rs.getLong("idCliente");
		Long idClienteDestinoDaMov = rs.getLong("idClienteDestino");
		BigDecimal valorDaMov = rs.getBigDecimal("valor");
		LocalDateTime dataDaMov = rs.getTimestamp("data").toLocalDateTime();
		
		builder = new MovimentacaoBuilder();
		Movimentacao mov = builder.comId(idDaMov).comValor(valorDaMov).naData(dataDaMov).comNovoSaldo(novoSaldoMov)
				.comIdDoCliente(idClienteDaMov).comIdClienteDestino(idClienteDestinoDaMov).constroi();
		
		return mov;
	}

	private void fazLoadDoCliente() throws SQLException {
		cliente.setNome(rs.getString("nome"));
		cliente.getConta().setSaldo(rs.getBigDecimal("saldo"));
		
		Conta conta = new Conta();
		conta.setId(rs.getInt("idConta"));
		cliente.setConta(conta);
	}

	public void atualizaClientePorId(Cliente cliente) {
		criaConexao();
		try {
			stmt = connection.prepareStatement("update Conta set saldo = ? where idConta = ?");
			stmt.setBigDecimal(1, cliente.getConta().getSaldo());
			stmt.setLong(2, cliente.getConta().getId());
			stmt.executeUpdate();

		} catch (SQLException se) {
			Logger.error(se, "Erro na busca de cliente por id");
		}
		fechaConexao();
	}
	
	public String loadName(Long idCliente) {
		criaConexao();
		String nome = "";
		try{
			stmt = connection.prepareStatement("select nome from Cliente where id = ?");
			stmt.setLong(1, idCliente);
			rs = stmt.executeQuery();
			rs.next();
			
			nome = rs.getString("nome");
		} catch (SQLException se) {
			Logger.error(se, "Erro na busca de cliente por id");
		}
		fechaConexao();
		return nome;
	}
}
