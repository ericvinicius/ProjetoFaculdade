package modelos;

import java.math.BigDecimal;

import org.joda.time.DateTime;

public class Movimentacao {

	private BigDecimal valor;
	private DateTime data;
	private BigDecimal novoSaldo;
	private Long id;

	private String tipo;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public DateTime getData() {
		return data;
	}

	public void setData(DateTime data) {
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

	public BigDecimal getNovoSaldo() {
		return novoSaldo;
	}

	public void setNovoSaldo(BigDecimal novoSaldo) {
		this.novoSaldo = novoSaldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
