package model;

import java.util.Arrays;

import javax.swing.JOptionPane;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import utilities.Utilites;

public class Usuario {
	private String conta;
	private String agencia;
	private String senha;
	private int[] codigoDeAcesso = new int[Utilites.TAMANHO_CODIGO_DE_ACESSO];
	private boolean novoCodigoDeAcesso = false;
	private boolean admin;
	private int status;
	private int id;
	
	public int getId(){
		return id;
	}

	public String getConta(){
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha2) {
		this.senha = senha2;
	}

	public int[] getCodigoDeAcesso() {
		return codigoDeAcesso;
	}

	public void setCodigoDeAcesso(int[] v) {
		codigoDeAcesso = v;
	}

	public boolean isNovoCodigoDeAcesso() {
		return novoCodigoDeAcesso;
	}

	public void setNovoCodigoDeAcesso(boolean novoCodigoDeAcesso) {
		this.novoCodigoDeAcesso = novoCodigoDeAcesso;
	}
	
	public boolean isAdmin() {
		return admin;
	}
	
	public void setAdmin(boolean isAdmin) {
		this.admin = isAdmin;
	}
	
	protected String getDados(){
		StringBuilder dados = new StringBuilder();
		dados.append(getAgencia());
		dados.append("|");
		dados.append(getConta());
		dados.append("|");
		dados.append(getSenha());
		return dados.toString();
	}
	
	public void toLog(String tag) {
		StringBuilder log = new StringBuilder();
		log.append("[" + tag + "] - {" + getId() + "}" );
		log.append(" - agencia: ( "+ getAgencia() + " )");
		log.append(" - conta: ( "+ getConta() + " )");
		log.append(" - senha: ( "+ getSenha().toString() + " )");
		log.append(" - Admin: ( " + isAdmin() + " )");
		log.append("\n");
		System.out.println(log);
	}
	
	public void guardaInformacoes(String agencia, String conta, String senha2) {
		setAgencia(agencia);
		setConta(conta);
		setSenha(senha2);
		verificaAdmin();
		toLog("Tentativa");
	}

	private void verificaAdmin() {
		//TODO: verificacao com 00.000-0
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public boolean fazComparacaoParaLogin(Usuario usuarioTentativa) {
		if(getDados().equals(usuarioTentativa.getDados())){
			if(getStatus() == 1){
				JOptionPane.showMessageDialog(null, "Usuario Bloqueado", "Block", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
			return true;
		}
		return false;
	}

	public boolean fazCompacaoDoCodigoDeAcesso(Usuario usuarioTentativa) {
		Utilites utilites = new Utilites();
		System.out.println("[Tentativa] = " + utilites.converteVetorParaString(usuarioTentativa.getCodigoDeAcesso()));
		System.out.println("[ Correto ] = " + utilites.converteVetorParaString(getCodigoDeAcesso()));
		if(Arrays.equals(getCodigoDeAcesso(), usuarioTentativa.getCodigoDeAcesso())){
			return true;
		}
		return false;
	}

	public void setId(int id) {
		if(id >= 0){
			this.id = id;
		}
	}
	
	
}
