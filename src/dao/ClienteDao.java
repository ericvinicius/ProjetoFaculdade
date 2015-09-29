package dao;

import idioma.Idioma;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import modelos.Cliente;
import modelos.Movimentacao;
import utilities.Logger;
import builders.MovimentacaoBuilder;

public class ClienteDao extends MyDao {
	private ArrayList<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();
	private MovimentacaoBuilder builder;
	private Cliente cliente;

	private BigDecimal saldoAnterior = utilites.saldoInicial;
	private BigDecimal novoSaldoMov = BigDecimal.ZERO;

	public Cliente carregaCliente(Cliente cliente) {
		criaConexao();
		this.cliente = cliente;
		Long idDoCliente = cliente.getId();
		try {
			stmt = connection.prepareStatement("select * from Cliente c join Movimentacao m on c.id = m.idCliente where m.idCliente = ? "
					+ "or m.idClienteDestino = ? order by m.data ASC;");
			stmt.setLong(1, idDoCliente);
			stmt.setLong(2, idDoCliente);
			rs = stmt.executeQuery();

			while (rs.next()) {
				builder = new MovimentacaoBuilder();
				//TODO: melhorar esta logica do i
				int i = 0;
				if (i == 0 && idDoCliente == rs.getLong("id")) {
					fazLoadDoCliente();
					i++;
				}

				Movimentacao movimentacao = constroiMovimentacao();
				pegaTipoDeMov(movimentacao);

				movimentacoes.add(movimentacao);
			}
			cliente.getConta().setMovimentacoes(movimentacoes);

		} catch (SQLException se) {
			Logger.error(se, "Erro na busca de cliente por id");
		}

		fechaConexao();
		atualizaSaldoCliente();
		
		return cliente;
	}

	private void atualizaSaldoCliente() {
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
	}

	public void atualizaClientePorId(Cliente cliente) {
		criaConexao();
		try {
			stmt = connection.prepareStatement("update Cliente set saldo = ? where id = ?");
			stmt.setBigDecimal(1, cliente.getConta().getSaldo());
			stmt.setLong(2, cliente.getId());
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
