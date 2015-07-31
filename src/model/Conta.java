package model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import utilities.Utilites;

//TODO: Esta classe possui codigo comentado para a implementacao de observers

public class Conta extends Cliente implements Acesso /* anotations.Observable */{
	// Acesso
	private String conta;
	private String agencia;
	private String senha;
	private int[] codigoDeAcesso = new int[Utilites.TAMANHO_CODIGO_DE_ACESSO];

	private BigDecimal saldo = BigDecimal.ZERO;

	private boolean novoCodigoDeAcesso = false;
	private boolean admin;
	private int status;

	private int id;
	private Cliente cliente;

	private List<Movimentacao> movimentacoes;
	private List<DebitoAutomatico> debitosAutomaticos;

	private Utilites utilites = new Utilites();

	public Conta() {
		cliente = new Cliente();
	}

	public int getId() {
		return id;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha2) {
		this.senha = senha2;
	}

	public int[] getCodigoDeAcesso() {
		return codigoDeAcesso;
	}

	public void setCodigoDeAcesso(int[] v) {
		codigoDeAcesso = v;
	}

	public boolean isNovoCodigoDeAcesso() {
		return novoCodigoDeAcesso;
	}

	public void setNovoCodigoDeAcesso(boolean novoCodigoDeAcesso) {
		this.novoCodigoDeAcesso = novoCodigoDeAcesso;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean isAdmin) {
		this.admin = isAdmin;
	}

	protected String getDados() {
		StringBuilder dados = new StringBuilder();
		dados.append(getAgencia());
		dados.append("|");
		dados.append(getConta());
		dados.append("|");
		dados.append(getSenha());
		return dados.toString();
	}

	public void toLog(String tag) {
		StringBuilder log = new StringBuilder();
		log.append("id(" + getId() + ")");
		log.append(" agencia( " + getAgencia() + " )");
		log.append(" conta( " + getConta() + " )");
		log.append(" senha( " + getSenha().toString() + " )");
		log.append(" admin( " + isAdmin() + " )");
		utilites.logger.logInfo(tag, log.toString());

	}

	public void guardaInformacoes(String agencia, String conta, String senha2) {
		setAgencia(agencia);
		setConta(conta);
		setSenha(senha2);
		verificaAdmin();
		toLog("Tentativa");
	}

	private void verificaAdmin() {
		if (getDados().equals(getDadosDoAdmin())) {
			setAdmin(true);
		}
	}

	private String getDadosDoAdmin() {
		StringBuilder dados = new StringBuilder();
		dados.append("0000-0");
		dados.append("|");
		dados.append("00.000-0");
		dados.append("|");
		dados.append("0000");
		return dados.toString();

	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public boolean validaLogin(Conta usuarioTentativa) {
		if (getDados().equals(usuarioTentativa.getDados())) {
			if (getStatus() == 1) {
				JOptionPane.showMessageDialog(null, "Usuario Bloqueado", "Block", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean validaCodigoDeAcesso(Conta usuarioTentativa) {
		utilites.logger.logInfo("Tentativa", utilites.converteVetorParaString(usuarioTentativa.getCodigoDeAcesso()));
		utilites.logger.logInfo("Correto", utilites.converteVetorParaString(getCodigoDeAcesso()));
		if (Arrays.equals(getCodigoDeAcesso(), usuarioTentativa.getCodigoDeAcesso())) {
			return true;
		}
		return false;
	}

	public void setId(int id) {
		if (id >= 0) {
			this.id = id;
		}
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public BigDecimal getSaldo() {
		// anotations.Observer observer = new anotations.Observer();
		// this.registerObserver(observer);
		// this.notifyObservers();
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public List<DebitoAutomatico> getDebitosAutomaticos() {
		return debitosAutomaticos;
	}

	public void setDebitosAutomaticos(List<DebitoAutomatico> debitosAutomaticos) {
		this.debitosAutomaticos = debitosAutomaticos;
	}

	// private List<Observer> observers = new ArrayList();
	//
	// @Override
	// public void registerObserver(Observer observer) {
	// observers.add(observer);
	// }
	//
	// @Override
	// public void removeObserver(Observer observer) {
	// observers.remove(observer);
	// }
	//
	// @Override
	// public void notifyObservers() {
	// for (Observer ob : observers) {
	// System.out.println("Notificando observers!");
	// ob.update(null, this);
	// }
	// }
}
