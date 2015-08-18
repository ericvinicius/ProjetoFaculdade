package modelos;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import utilities.Logger;
import utilities.Utilites;

//TODO: Esta classe possui codigo comentado para a implementacao de observers

public class Cliente  /* anotations.Observable */{
	// Acesso
	private String conta;
	private String agencia;
	private String senha;
	private int[] codigoDeAcesso = new int[Utilites.TAMANHO_CODIGO_DE_ACESSO];

	private BigDecimal saldo = BigDecimal.ZERO;

	private boolean novoCodigoDeAcesso = false;
	private boolean admin;
	private int status;

	private Long id;
	private String nome;
	
	private ArrayList<Movimentacao> movimentacoes;
	private ArrayList<DebitoAutomatico> debitosAutomaticos;

	private Utilites utilites = new Utilites();
	
	public Cliente(String conta, String agencia, String senha, int[] codigoDeAcesso, BigDecimal saldo, boolean novoCodigoDeAcesso, boolean admin, int status, Long id,
			String nome, ArrayList<Movimentacao> movimentacoes, ArrayList<DebitoAutomatico> debitosAutomaticos) {
		this.conta = conta;
		this.agencia = agencia;
		this.senha = senha;
		this.codigoDeAcesso = codigoDeAcesso;
		this.saldo = saldo;
		this.novoCodigoDeAcesso = novoCodigoDeAcesso;
		this.admin = admin;
		this.status = status;
		this.id = id;
		this.nome = nome;
		this.movimentacoes = movimentacoes;
		this.debitosAutomaticos = debitosAutomaticos;
	}

	public Long getId() {
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

	public void toLog(String tag) {
		StringBuilder log = new StringBuilder();
		
		String id = getId() + "";
		if(id.length() == 1){
			id = "  " + id + " ";
		}
		
		log.append("id(" + id + ")");
		log.append(" agencia( " + getAgencia() + " )");
		log.append(" conta( " + getConta() + " )");
		log.append(" senha( " + getSenha().toString() + " )");
		log.append(" admin( " + isAdmin() + " )");
		Logger.logInfo(tag, log.toString());

	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setId(Long id) {
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

	public ArrayList<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(ArrayList<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public ArrayList<DebitoAutomatico> getDebitosAutomaticos() {
		return debitosAutomaticos;
	}

	public void setDebitosAutomaticos(ArrayList<DebitoAutomatico> debitosAutomaticos) {
		this.debitosAutomaticos = debitosAutomaticos;
	}
	
	public Object[][] getExtrato(){
		int size = movimentacoes.size();
		
		Movimentacao mov = movimentacoes.get(0);
		Object[][] extrato = new Object[size + 1][5];
		
		BigDecimal saldoAnterior = mov.getNovoSaldo().add(mov.getValor());
		extrato[0][0] = mov.getData().minusDays(1).format(DateTimeFormatter.ofPattern(utilites.maskDia));
		extrato[0][1] = "Saldo Anterior";
		extrato[0][2] = utilites.getValorComMoeda(Double.parseDouble(saldoAnterior + ""));
		extrato[0][3] = " - ";
		
		int i = 1;
		for (Movimentacao movimentacao : movimentacoes) {
			
			String valorMov = utilites.getValorComMoeda(Double.parseDouble(movimentacao.getValor() + ""));
			String novoSaldoMov = utilites.getValorComMoeda(Double.parseDouble(movimentacao.getNovoSaldo() + ""));
			
			extrato[i][0] = movimentacao.getData().format(DateTimeFormatter.ofPattern(utilites.maskDiaHora));
			extrato[i][1] = movimentacao.getTipo();
			extrato[i][2] = valorMov;
			extrato[i][3] = novoSaldoMov;
			i++;
		}
		return extrato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void addMovimentacao(Movimentacao mov) {
		this.movimentacoes.add(mov);
	}

	String getDadosDeLogin() {
		StringBuilder dados = new StringBuilder();
		dados.append(getAgencia());
		dados.append("|");
		dados.append(getConta());
		dados.append("|");
		dados.append(getSenha());
		return dados.toString();
	}
	
	String getDadosAgenciaConta() {
		StringBuilder dados = new StringBuilder();
		dados.append(getAgencia());
		dados.append("|");
		dados.append(getConta());
		return dados.toString();
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
