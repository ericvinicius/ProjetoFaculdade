package modelos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
		//TODO: Neste metodo a GUI deve ser recarregada
		MovimentacaoDao dao = new MovimentacaoDao();
		dao.salva(this);
	}

}
