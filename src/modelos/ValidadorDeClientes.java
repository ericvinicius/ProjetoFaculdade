package modelos;

import java.util.Arrays;

import utilities.Logger;
import utilities.Utilites;
import interfaces.Acesso;

public class ValidadorDeClientes implements Acesso {
	
	private Utilites utilites = new Utilites();

	@Override
	public boolean validaLogin(Cliente u, Cliente u2) {
		return u.getDadosDeLogin().equals(u2.getDadosDeLogin());
	}

	@Override
	public boolean validaClienteExistente(Cliente u, Cliente u2) {
		return u.getDadosAgenciaConta().equals(u2.getDadosAgenciaConta());
	}
	
	@Override
	public boolean validaCodigoDeAcesso(Cliente u, Cliente u2) {
		Logger.logInfo("Tentativa", utilites.converteCodigoDeAcessoParaString(u2.getCodigoDeAcesso()));
		Logger.logInfo("Correto", utilites.converteCodigoDeAcessoParaString(u.getCodigoDeAcesso()));
		return Arrays.equals(u.getCodigoDeAcesso(), u2.getCodigoDeAcesso());
	}
	
	@Override
	public boolean verificaAdmin(Cliente u) {
		return u.getDadosDeLogin().equals(getDadosDoAdmin());
	}
	
	private String getDadosDoAdmin() {
		StringBuilder dados = new StringBuilder();
		dados.append("0000-0");
		dados.append("|");
		dados.append("00.000-0");
		dados.append("|");
		dados.append("0000");
		return dados.toString();
	}

}
