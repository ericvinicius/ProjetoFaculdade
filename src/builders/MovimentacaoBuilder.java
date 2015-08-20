package builders;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import modelos.Movimentacao;

public class MovimentacaoBuilder {
	private BigDecimal valor;
	private LocalDateTime data;
	private BigDecimal novoSaldo;
	private Long idCliente;
	private Long id;
	private String tipo;
	private Long idClienteDestino;
	
	public Movimentacao constroi(){
		if(data == null){
			data = LocalDateTime.now();
		}
		
		if(id != null){
			return new Movimentacao(id, valor, data, novoSaldo, idCliente, tipo, idClienteDestino);
		}
		
		return new Movimentacao(valor, data, novoSaldo, idCliente, tipo, idClienteDestino);
	}
	
	public MovimentacaoBuilder comId(Long id){
		this.id = id;
		return this;
	}
	
	public MovimentacaoBuilder comValor(BigDecimal val){
		this.valor = val;
		return this;
	}
	
	public MovimentacaoBuilder naData(LocalDateTime d){
		this.data = d;
		return this;
	}
	
	public MovimentacaoBuilder comNovoSaldo(BigDecimal d){
		this.novoSaldo = d;
		return this;
	}
	
	public MovimentacaoBuilder comIdDoCliente(Long d){
		this.idCliente = d;
		return this;
	}

	public MovimentacaoBuilder doTipo(String tipo) {
		this.tipo = tipo;
		return this;
	}
	
	public MovimentacaoBuilder comIdClienteDestino(Long id){
		this.idClienteDestino = id;
		return this;
	}
	
}
