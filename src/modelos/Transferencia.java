package modelos;

public class Transferencia extends Movimentacao {
	private String contaDestino;
	private String agenciaDestino;

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

	public void realizarTransferencia() {
		// TODO: metodo para realizar transferencia. Deve chamar o metodo
		// efetuaMovimentacao.
	}

}
