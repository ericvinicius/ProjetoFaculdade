package modelos;

import java.util.Arrays;

import utilities.Logger;
import utilities.Utilites;
import interfaces.Acesso;

public class ValidadorDeClientes implements Acesso {
	
	private Utilites utilites = new Utilites();

	@Override
	public boolean possuemLoginIgual(Cliente u, Cliente u2) {
		return u.getLogin().equals(u2.getLogin());
	}

	@Override
	public boolean possuemAgenciaEContaIguais(Cliente u, Cliente u2) {
		return u.getAgenciaConta().equals(u2.getAgenciaConta());
	}
	
	@Override
	public boolean possuemCodigoDeAcessoIguais(Cliente u, Cliente u2) {
		Logger.info("Tentativa", utilites.converteCodigoDeAcessoParaString(u2.getCodigoDeAcesso()));
		Logger.info("Correto", utilites.converteCodigoDeAcessoParaString(u.getCodigoDeAcesso()));
		return Arrays.equals(u.getCodigoDeAcesso(), u2.getCodigoDeAcesso());
	}
	
	@Override
	public boolean possuiDadosDeAdmin(Cliente u) {
		return u.getLogin().equals(getDadosDoAdmin());
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
