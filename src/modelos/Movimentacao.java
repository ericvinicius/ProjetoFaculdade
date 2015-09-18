package modelos;

import idioma.Idioma;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import popups.MyJOptionPane;
import utilities.Logger;
import utilities.Utilites;
import dao.ClienteDao;
import dao.MovimentacaoDao;

public class Movimentacao {

	private Long id;
	
	private BigDecimal valor;
	
	private LocalDateTime data;
	
	private BigDecimal novoSaldo;
	
	private String tipo;
	
	private Long idCliente;
	
	private Long idClienteDestino;
	
	private Utilites utilites = new Utilites();

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
		ClienteDao daoCliente = new ClienteDao();
		MovimentacaoDao dao = new MovimentacaoDao();
		
		String nome = daoCliente.loadName(idClienteDestino);
		int resp = MyJOptionPane.createConfirmDialog("Transferencia no valor de " + Idioma.getValorComMoeda(getValor()) + " para o cliente: " + nome,
														  "Transferencia", Utilites.creditCard);
		if(resp == JOptionPane.OK_OPTION){
			dao.salva(this);
			Logger.info("Movimentacao", this.toString());
		} else {
			Logger.warn("Movimentacao", "NAO SALVA " + this.toString());
		}
		
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("id( "+ getId() +" ) ");
		builder.append("data( "+ getData() +" ) ");
		builder.append("novoSaldo( "+ getNovoSaldo() +" ) ");
		builder.append("idCliente( "+ getIdCliente() +" ) ");
		builder.append("idClienteDestino( "+ getIdClienteDestino() +" ) ");
		return builder.toString();
	}

}
