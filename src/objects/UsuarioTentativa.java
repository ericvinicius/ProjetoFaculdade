package objects;

public class UsuarioTentativa {
	private static String conta;
	private static String agencia;
	private static String senha;
	private static int[] codigoDeAcesso = new int[4];
	
	public static String getConta() {
		return conta;
	}
	public static void setConta(String conta) {
		UsuarioTentativa.conta = conta;
	}
	public static String getAgencia() {
		return agencia;
	}
	public static void setAgencia(String agencia) {
		UsuarioTentativa.agencia = agencia;
	}
	public static String getSenha() {
		return senha;
	}
	public static void setSenha(String senha) {
		UsuarioTentativa.senha = senha;
	}
	public static int[] getCodigoDeAcesso() {
		return codigoDeAcesso;
	}
	public static void setCodigoDeAcesso(int[] v) {
		codigoDeAcesso = v;
	}
}
