package modelos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Movimentacao {

	private Long id;
	
	private BigDecimal valor;
	
	private LocalDateTime data;
	
	private BigDecimal novoSaldo;
	
	private String tipo;
	
	private Long idCliente;

	public Movimentacao(Long id, BigDecimal valor, LocalDateTime data, BigDecimal novoSaldo, String tipo, Long idCliente){
		setId(id);
		setValor(valor);
		setData(data);
		setNovoSaldo(novoSaldo);
		setTipo(tipo);
		setIdCliente(idCliente);
		//TODO: aqui deve ir para o log
	}

	public Movimentacao(BigDecimal valor, LocalDateTime data, BigDecimal novoSaldo, String tipo, Long idCliente) {
		setValor(valor);
		setData(data);
		setNovoSaldo(novoSaldo);
		setTipo(tipo);
		setIdCliente(idCliente);
		//TODO: aqui deve ir para o log
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

}
