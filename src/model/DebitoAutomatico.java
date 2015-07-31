package model;

import java.util.Calendar;

public class DebitoAutomatico {
	private int codOperacao;
	private int codConsumidor;
	private String tipoDeConta;
	private Calendar dataDoDebito;
	
	public int getCodOperacao() {
		return codOperacao;
	}
	public void setCodOperacao(int codOperacao) {
		this.codOperacao = codOperacao;
	}
	public int getCodConsumidor() {
		return codConsumidor;
	}
	public void setCodConsumidor(int codConsumidor) {
		this.codConsumidor = codConsumidor;
	}
	public String getTipoDeConta() {
		return tipoDeConta;
	}
	public void setTipoDeConta(String tipoDeConta) {
		this.tipoDeConta = tipoDeConta;
	}
	public Calendar getDataDoDebito() {
		return dataDoDebito;
	}
	public void setDataDoDebito(Calendar dataDoDebito) {
		this.dataDoDebito = dataDoDebito;
	}
	
}
