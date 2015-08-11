package interfaces;

import modelos.Cliente;

public interface Acesso {
	public boolean validaLogin(Cliente u, Cliente u2);

	public boolean validaCodigoDeAcesso(Cliente u, Cliente u2);
	
	public boolean validaClienteExistente(Cliente u, Cliente u2);
	
	public boolean verificaAdmin(Cliente u);
}
