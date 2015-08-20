package interfaces;

import modelos.Cliente;

public interface Acesso {
	public boolean possuemLoginIgual(Cliente u, Cliente u2);

	public boolean possuemCodigoDeAcessoIguais(Cliente u, Cliente u2);
	
	public boolean possuemAgenciaEContaIguais(Cliente u, Cliente u2);
	
	public boolean possuiDadosDeAdmin(Cliente u);
}
