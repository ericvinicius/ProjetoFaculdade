package modelos;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Conta {
	// Acesso
	private String conta;
	private String agencia;
	private BigDecimal saldo = BigDecimal.ZERO;
	
	private int id;

	private ArrayList<Movimentacao> movimentacoes;
	private ArrayList<DebitoAutomatico> debitosAutomaticos;
	
	public Conta(String conta, String agencia, BigDecimal saldo, ArrayList<Movimentacao> movimentacoes, ArrayList<DebitoAutomatico> debitosAutomaticos) {
		this.conta = conta;
		this.agencia = agencia;
		this.saldo = saldo;
		this.movimentacoes = movimentacoes;
		this.debitosAutomaticos = debitosAutomaticos;
	}
	public Conta() {}
	
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
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
