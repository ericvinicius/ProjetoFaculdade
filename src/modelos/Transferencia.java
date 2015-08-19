package modelos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import utilities.Logger;
import dao.MovimentacaoDao;



public class Transferencia extends Movimentacao {
	private String contaDestino;
	private String agenciaDestino;
	
	public Transferencia(BigDecimal valor, LocalDateTime data, BigDecimal novoSaldo, String contaDestino, String agenciaDestino, Long idCliente){
		super(valor, data, novoSaldo, Transferencia.class.getSimpleName(), idCliente);
		setContaDestino(contaDestino);
		setAgenciaDestino(agenciaDestino);
	}
	
	public Transferencia(Long id, BigDecimal valor, LocalDateTime data, BigDecimal novoSaldo, String contaDestino, String agenciaDestino, Long idCliente){
		super(id, valor, data, novoSaldo, Transferencia.class.getSimpleName(), idCliente);
		setContaDestino(contaDestino);
		setAgenciaDestino(agenciaDestino);
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String conta) {
		this.contaDestino = conta;
	}

	public String getAgenciaDestino() {
		return agenciaDestino;
	}

	public void setAgenciaDestino(String agencia) {
		this.agenciaDestino = agencia;
	}

	public void efetuaTransferencia() {
		MovimentacaoDao dao = new MovimentacaoDao();
		dao.salva(this);
		Logger.info("Transferencia", this.toString());
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("id( "+ getId() +" ) ");
		builder.append("agencia( "+ getAgenciaDestino() +" ) ");
		builder.append("conta( "+ getContaDestino() +" ) ");
		builder.append("tipo( "+ getTipo() +" ) ");
		builder.append("data( "+ getData() +" ) ");
		builder.append("novoSaldo( "+ getNovoSaldo() +" ) ");
		builder.append("idCliente( "+ getIdCliente() +" ) ");
		return builder.toString();
	}

}
