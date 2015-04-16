package objects;

public class UsuarioCadastrado {
	private static String conta;
	private static String agencia;
	private static char[] senha;
	private static int[] codigoDeAcesso = new int[4];

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
}
