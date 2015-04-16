package objects;

public class Usuario {
	private String conta;
	private String agencia;
	private String senha;
	private int[] codigoDeAcesso = new int[4];
	
	public Usuario() {
		conta="";
		agencia="";
		senha="";
		codigoDeAcesso=null;
	}
	
	public String getConta() {
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
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int[] getCodigoDeAcesso() {
		return codigoDeAcesso;
	}
	public void setCodigoDeAcesso(int[] v) {
		this.codigoDeAcesso = v;
	}
}
