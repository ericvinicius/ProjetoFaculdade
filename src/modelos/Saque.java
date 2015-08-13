package modelos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Saque extends Movimentacao {
	
	public Saque(Long id, BigDecimal valor, LocalDateTime data, BigDecimal novoSaldo, long idCliente){
		super(id, valor, data, novoSaldo, Saque.class.getSimpleName(), idCliente);
	}
	
	public void efetuaSaque(){
		// TODO: Criar metodo de efetua saque. Deve chamar o metodo
		// efetuaMovimentacao.
	}
}
