package builders;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import modelos.Transferencia;

public class TransferenciaBuilder {
	private BigDecimal valor;
	private LocalDateTime data;
	private BigDecimal novoSaldo;
	private String contaDestino;
	private String agenciaDestino;
	private Long idCliente;
	private Long id;
	
	public Transferencia constroi(){
		if(data == null){
			data = LocalDateTime.now();
		}
		
		if(id != null){
			return new Transferencia(id, valor, data, novoSaldo, contaDestino, agenciaDestino, idCliente);
		}
		
		return new Transferencia(valor, data, novoSaldo, contaDestino, agenciaDestino, idCliente);
	}
	
	public TransferenciaBuilder comId(Long id){
		this.id = id;
		return this;
	}
	
	public TransferenciaBuilder comValor(BigDecimal val){
		this.valor = val;
		return this;
	}
	
	public TransferenciaBuilder naData(LocalDateTime d){
		this.data = d;
		return this;
	}
	
	public TransferenciaBuilder comNovoSaldo(BigDecimal d){
		this.novoSaldo = d;
		return this;
	}
	
	public TransferenciaBuilder comContaDestino(String d){
		this.contaDestino = d;
		return this;
	}
	
	public TransferenciaBuilder comAgenciaDestino(String d){
		this.agenciaDestino = d;
		return this;
	}
	
	public TransferenciaBuilder comIdDoCliente(Long d){
		this.idCliente = d;
		return this;
	}
	
}
