package modelos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
	
	public void guardaInformacoes(String agencia2, String conta2) {
		setAgencia(agencia);
		setConta(conta);
	}

	public void guardaInformacoes(String agencia, String conta, String senha) {
		setAgencia(agencia);
		setConta(conta);
		setSenha(senha);
		toLog("Tentativa");
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
		
		Object[][] extrato = new Object[size][5];
		int i = 0;
		for (Movimentacao mov : movimentacoes) {
			extrato[i][0] = mov.getValor();
			LocalDateTime data = mov.getData();
			extrato[i][1] = data.format(DateTimeFormatter.ofPattern(utilites.maskDiaHora));
			extrato[i][2] = mov.getTipo();
			extrato[i][3] = mov.getNovoSaldo();
			i++;
		}
		return extrato;
	}

	public String getNome() {
		if(nome != null){
			return nome;
		} else {
			return "Maluco Beleza";
		}
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
