package model;

public class UsuarioCadastrado {
	private static int id;
	private static String conta;
	private static String agencia;
	private static char[] senha;
	private static int[] codigoDeAcesso = new int[4];
	private static boolean acesso;

	public static String getConta() {
		return conta;
	}

	public static void setConta(String conta) {
		UsuarioCadastrado.conta = conta;
	}

	public static String getAgencia() {
		return agencia;
	}

	public static void setAgencia(String agencia) {
		UsuarioCadastrado.agencia = agencia;
	}

	public static char[] getSenha() {
		return senha;
	}

	public static void setSenha(char[] senha) {
		UsuarioCadastrado.senha = senha;
	}

	public static int[] getCodigoDeAcesso() {
		return codigoDeAcesso;
	}

	public static void setCodigoDeAcesso(int[] v) {
		codigoDeAcesso = v;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		UsuarioCadastrado.id = id;
	}

	public static boolean getAcesso() {
		return acesso;
	}

	public static void setAcesso(boolean acesso) {
		UsuarioCadastrado.acesso = acesso;
	}

		
}
