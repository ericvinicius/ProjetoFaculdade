package model;

public interface Acesso {
	public boolean validaLogin(Conta u);

	public boolean validaCodigoDeAcesso(Conta u);
}
