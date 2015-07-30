package model;

import java.math.BigDecimal;
import java.util.Calendar;

public class Movimentacao {

	private BigDecimal valor;
	private Calendar data;

	private String tipo;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void efetuarMovimentacao(String tipo) {
		// TODO: efetuar movimentacao
	}

}
