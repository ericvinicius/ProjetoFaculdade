package modelos;

import java.util.Arrays;

import utilities.Logger;
import utilities.Utilites;
import interfaces.Acesso;

public class ValidadorDeClientes implements Acesso {
	
	private Utilites utilites = new Utilites();

	@Override
	public boolean validaLogin(Cliente u, Cliente u2) {
		return getDadosDeLogin(u).equals(getDadosDeLogin(u2));
	}

	@Override
	public boolean validaClienteExistente(Cliente u, Cliente u2) {
		return getDadosAgenciaConta(u).equals(getDadosAgenciaConta(u2));
	}
	
	@Override
	public boolean validaCodigoDeAcesso(Cliente u, Cliente u2) {
		Logger.logInfo("Tentativa", utilites.converteVetorParaString(u2.getCodigoDeAcesso()));
		Logger.logInfo("Correto", utilites.converteVetorParaString(u.getCodigoDeAcesso()));
		return Arrays.equals(u.getCodigoDeAcesso(), u2.getCodigoDeAcesso());
	}
	
	@Override
	public boolean verificaAdmin(Cliente u) {
		return getDadosDeLogin(u).equals(getDadosDoAdmin());
	}
	
	private String getDadosDeLogin(Cliente u) {
		StringBuilder dados = new StringBuilder();
		dados.append(u.getAgencia());
		dados.append("|");
		dados.append(u.getConta());
		dados.append("|");
		dados.append(u.getSenha());
		return dados.toString();
	}
	
	private String getDadosAgenciaConta(Cliente u) {
		StringBuilder dados = new StringBuilder();
		dados.append(u.getAgencia());
		dados.append("|");
		dados.append(u.getConta());
		return dados.toString();
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
