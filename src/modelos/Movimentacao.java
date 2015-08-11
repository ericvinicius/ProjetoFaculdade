package modelos;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.joda.time.DateTime;

public class Movimentacao {

	private Long id;
	
	private BigDecimal valor;
	
	private DateTime data;
	
	private BigDecimal novoSaldo;
	
	private String tipo;
	
	private Long idCliente;

	public Movimentacao(Long id, BigDecimal valor, Timestamp data, BigDecimal novoSaldo, String tipo, Long idCliente){
		setId(id);
		setValor(valor);
		setData(new DateTime(data));
		setNovoSaldo(novoSaldo);
		setTipo(tipo);
		setIdCliente(idCliente);
		//TODO: aqui deve ir para o log
	}

	public Movimentacao(BigDecimal valor, Date data, BigDecimal novoSaldo, String tipo, Long idCliente) {
		setValor(valor);
		setData(new DateTime(data));
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
