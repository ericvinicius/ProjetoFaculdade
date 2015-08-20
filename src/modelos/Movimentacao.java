package modelos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import utilities.Logger;
import dao.MovimentacaoDao;

public class Movimentacao {

	private Long id;
	
	private BigDecimal valor;
	
	private LocalDateTime data;
	
	private BigDecimal novoSaldo;
	
	private String tipo;
	
	private Long idCliente;
	
	private Long idClienteDestino;

	public Movimentacao(Long id, BigDecimal valor, LocalDateTime data, BigDecimal novoSaldo, Long idCliente, String tipo, Long idClienteDestino){
		setId(id);
		setValor(valor);
		setData(data);
		setNovoSaldo(novoSaldo);
		setTipo(tipo);
		setIdCliente(idCliente);
		setIdClienteDestino(idClienteDestino);
		//TODO: aqui deve ir para o log
	}

	public Movimentacao(BigDecimal valor, LocalDateTime data, BigDecimal novoSaldo, Long idCliente, String tipo, Long idClienteDestino) {
		setValor(valor);
		setData(data);
		setNovoSaldo(novoSaldo);
		setTipo(tipo);
		setIdCliente(idCliente);
		setIdClienteDestino(idClienteDestino);
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

	public Long getIdClienteDestino() {
		return idClienteDestino;
	}

	public void setIdClienteDestino(Long idClienteDestino) {
		this.idClienteDestino = idClienteDestino;
	}
	
	public void efetua() {
		MovimentacaoDao dao = new MovimentacaoDao();
		dao.salva(this);
		Logger.info(getTipo(), this.toString());
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("id( "+ getId() +" ) ");
		builder.append("tipo( "+ getTipo() +" ) ");
		builder.append("data( "+ getData() +" ) ");
		builder.append("novoSaldo( "+ getNovoSaldo() +" ) ");
		builder.append("idCliente( "+ getIdCliente() +" ) ");
		builder.append("idClienteDestino( "+ getIdClienteDestino() +" ) ");
		return builder.toString();
	}

}
