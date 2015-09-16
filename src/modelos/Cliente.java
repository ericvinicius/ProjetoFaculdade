package modelos;

import java.math.BigDecimal;
import java.util.ArrayList;

import dao.ClienteDao;
import utilities.Logger;
import utilities.Utilites;

public class Cliente{

	private boolean admin;
	private int status;

	private Long id;
	private String nome;
	private String senha;
	private int[] codigoDeAcesso = new int[Utilites.TAMANHO_CODIGO_DE_ACESSO];
	private boolean novoCodigoDeAcesso = false;

	private Conta conta;
	private Utilites utilites = new Utilites();

	public Cliente(String conta, String agencia, String senha, int[] codigoDeAcesso, BigDecimal saldo, boolean novoCodigoDeAcesso, boolean admin, int status, Long id,
			String nome, ArrayList<Movimentacao> movimentacoes, ArrayList<DebitoAutomatico> debitosAutomaticos) {
		this.setConta(new Conta(conta, agencia, saldo, movimentacoes, debitosAutomaticos));
		
		this.setNovoCodigoDeAcesso(novoCodigoDeAcesso);
		this.setSenha(senha);
		this.setCodigoDeAcesso(codigoDeAcesso);
		this.setAdmin(admin);
		this.setStatus(status);
		this.setId(id);
		this.setNome(nome);
	}

	@Deprecated
	public Cliente() {
		setConta(new Conta());
		// TODO: Este metodo deve ser removido no fim do projeto
	}

	public Cliente(String senha2, int[] codigoDeAcesso2, boolean novoCodigoDeAcesso2, boolean admin2, int status2, Long id2, String nome2, Conta contaDoCliente) {
		setConta(contaDoCliente);
		setSenha(senha2);
		setNome(nome2);
		setCodigoDeAcesso(codigoDeAcesso2);
		setAdmin(admin2);
		setStatus(status2);
		setId(id2);
	}

	public Long getId() {
		return id;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean isAdmin) {
		this.admin = isAdmin;
	}

	public void toLog(String tag) {
		StringBuilder log = new StringBuilder();

		String id = getId() + "";
		if (id.length() == 1) {
			id = "  " + id + " ";
		}

		log.append("id(" + id + ")");
		log.append(" agencia( " + getConta().getAgencia() + " )");
		log.append(" conta( " + getConta().getConta() + " )");

		if (getSenha() == null) {
			log.append(" senha( null )");
		} else {
			log.append(" senha( " + getSenha().toString() + " )");
		}

		log.append(" admin( " + isAdmin() + " )");
		Logger.info(tag, log.toString());

	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setId(Long id) {
		if (id != null && id >= 0) {
			this.id = id;
		}
	}

	public Object[][] getExtrato() {

		Object[][] extrato = criaExtratoPadraoComOSaldoAnterior();

		int i = 1;
		for (Movimentacao movimentacao : getConta().getMovimentacoes()) {

			String valorMov = utilites.getValorComMoeda(Double.parseDouble(movimentacao.getValor() + ""));
			String novoSaldoMov;
			if (movimentacao.getNovoSaldo() == null) {
				novoSaldoMov = " - ";
			} else {
				novoSaldoMov = utilites.getValorComMoeda(Double.parseDouble(movimentacao.getNovoSaldo() + ""));
			}

			extrato[i][0] = movimentacao.getData().format(Utilites.formatDia);
			extrato[i][1] = movimentacao.getTipo();
			extrato[i][2] = valorMov;
			extrato[i][3] = novoSaldoMov;

			i++;
		}
		return extrato;
	}

	private Object[][] criaExtratoPadraoComOSaldoAnterior() {
		int size = getConta().getMovimentacoes().size();
		Object[][] extrato = new Object[size + 1][5];
		BigDecimal saldoAnterior = utilites.saldoInicial;
		Movimentacao mov = getConta().getMovimentacoes().get(0);

		extrato[0][0] = mov.getData().minusDays(1).format(Utilites.formatDia);
		extrato[0][1] = "Saldo Anterior";
		extrato[0][2] = utilites.getValorComMoeda(saldoAnterior);
		extrato[0][3] = " - ";

		return extrato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void addMovimentacao(Movimentacao mov) {
		this.getConta().getMovimentacoes().add(mov);
	}

	String getLogin() {
		StringBuilder dados = new StringBuilder();
		dados.append(getConta().getAgencia());
		dados.append("|");
		dados.append(getConta().getConta());
		dados.append("|");
		dados.append(getSenha());
		return dados.toString();
	}

	String getAgenciaConta() {
		StringBuilder dados = new StringBuilder();
		dados.append(getConta().getAgencia());
		dados.append("|");
		dados.append(getConta().getConta());
		return dados.toString();
	}

	public int[] getCodigoDeAcesso() {
		return codigoDeAcesso;
	}

	public void setCodigoDeAcesso(int[] codigoDeAcesso) {
		this.codigoDeAcesso = codigoDeAcesso;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public boolean isNovoCodigoDeAcesso() {
		return novoCodigoDeAcesso;
	}

	public void setNovoCodigoDeAcesso(boolean novoCodigoDeAcesso) {
		this.novoCodigoDeAcesso = novoCodigoDeAcesso;
	}

	public Cliente carregaCliente() {
		return new ClienteDao().carregaCliente(this);
	}
	
}
