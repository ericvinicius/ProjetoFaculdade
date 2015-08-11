package modelos;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Saque extends Movimentacao {
	
	public Saque(Long id, BigDecimal valor, Timestamp data, BigDecimal novoSaldo, long idCliente){
		super(id, valor, data, novoSaldo, Saque.class.getSimpleName(), idCliente);
	}
	
	public void efetuaSaque(){
		// TODO: Criar metodo de efetua saque. Deve chamar o metodo
		// efetuaMovimentacao.
	}
}
