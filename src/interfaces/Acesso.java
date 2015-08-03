package interfaces;

import modelos.Cliente;

public interface Acesso {
	public boolean validaLogin(Cliente u);

	public boolean validaCodigoDeAcesso(Cliente u);
}
