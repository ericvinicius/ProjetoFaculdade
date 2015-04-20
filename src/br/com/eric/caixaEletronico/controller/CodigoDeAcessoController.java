package br.com.eric.caixaEletronico.controller;

import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.eric.caixaEletronico.model.UsuarioCadastrado;
import br.com.eric.caixaEletronico.model.UsuarioTentativa;

public class CodigoDeAcessoController {
	
	public static final int TAMANHO_CODIGO_DE_ACESSO = 4;
	public static int[] codigo = new int[TAMANHO_CODIGO_DE_ACESSO];
	public static int contadorDeClicks = -1;
	public static int tentativa = 0;
	
	public static boolean codigoOk() {
		return Arrays.equals(UsuarioTentativa.getCodigoDeAcesso(), UsuarioCadastrado.getCodigoDeAcesso());
	}

	public static void criaCodigoDeAcesso() {
		System.out.println("Cria Codigo de acesso!");
		UsuarioTentativa.setNovoCodigoDeAcesso(true);
	}

	public static void verificaCodigo(JFrame janela) {
		if (CodigoDeAcessoController.contadorDeClicks == TAMANHO_CODIGO_DE_ACESSO) {
			UsuarioTentativa.setCodigoDeAcesso(CodigoDeAcessoController.codigo);

			System.out.println("[Tentativa] codigo{"
					+ UsuarioTentativa.getCodigoDeAcesso().toString() + "}\n");

			if (UsuarioTentativa.isNovoCodigoDeAcesso()) {
				//TODO:Cadastrar novo codigo de acesso
				
			} else if (CodigoDeAcessoController.codigoOk()) {
				janela.dispose();
				JOptionPane.showMessageDialog(janela, "Logado com sucesso!");
				// TODO:Falta criar a tela principal do sistema

			} else {
				Utilites.tremeTelaNormal(janela);
				CodigoDeAcessoController.contadorDeClicks = 0;
			}

		}
	}
}
