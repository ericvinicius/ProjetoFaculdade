package builders;

import java.math.BigDecimal;
import java.util.ArrayList;

import modelos.Cliente;
import modelos.Conta;
import modelos.DebitoAutomatico;
import modelos.Movimentacao;
import utilities.Utilites;

public class ClienteBuilder {
	private String conta;
	private String agencia;
	private String senha;
	private int[] codigoDeAcesso = new int[Utilites.TAMANHO_CODIGO_DE_ACESSO];

	private BigDecimal saldo = BigDecimal.ZERO;

	private boolean novoCodigoDeAcesso = false;
	private boolean admin;
	private int status;

	private Long id;
	private String nome;
	
	private ArrayList<Movimentacao> movimentacoes;
	private ArrayList<DebitoAutomatico> debitosAutomaticos;

	public ClienteBuilder comStatus(int status){
		this.status = status;
		return this;
	}
	public ClienteBuilder comId(Long id){
		this.id = id;
		return this;
	}
	public ClienteBuilder comNome(String nome){
		this.nome = nome;
		return this;
	}
	public ClienteBuilder comMovimentacoes(ArrayList<Movimentacao> movimentacoes){
		this.movimentacoes = movimentacoes;
		return this;
	}
	public ClienteBuilder comDebitosAutomaticos(ArrayList<DebitoAutomatico> debitosAutomaticos){
		this.debitosAutomaticos = debitosAutomaticos;
		return this;
	}
	public ClienteBuilder comConta(String conta){
		this.conta = conta;
		return this;
	}
	public ClienteBuilder comAgencia(String agencia){
		this.agencia = agencia;
		return this;
	}
	public ClienteBuilder comSenha(String senha){
		this.senha = senha;
		return this;
	}
	public ClienteBuilder comCodigoDeAcesso(int[] codigo){
		this.codigoDeAcesso = codigo;
		return this;
	}
	public ClienteBuilder comSaldo(BigDecimal saldo){
		this.saldo = saldo;
		return this;
	}
	public ClienteBuilder comNovoCodigo(Boolean isNovo){
		this.novoCodigoDeAcesso = isNovo;
		return this;
	}
	public ClienteBuilder sendoAdmin(Boolean isAdmin){
		this.admin = isAdmin;
		return this;
	}
	
	public Cliente constroi() {
		Conta contaDoCliente = new Conta(conta, agencia, saldo, movimentacoes, debitosAutomaticos);
		Cliente cliente = new Cliente(senha, codigoDeAcesso, novoCodigoDeAcesso, admin, status, id, nome, contaDoCliente);
		return cliente;
	}
}
