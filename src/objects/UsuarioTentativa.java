package objects;

public class UsuarioTentativa {
	private static String conta;
	private static String agencia;
	private static char[] senha;
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

	public static char[] getSenha() {
		return senha;
	}

	public static void setSenha(char[] cs) {
		UsuarioTentativa.senha = cs;
	}

	public static int[] getCodigoDeAcesso() {
		return codigoDeAcesso;
	}

	public static void setCodigoDeAcesso(int[] v) {
		codigoDeAcesso = v;
	}
}
