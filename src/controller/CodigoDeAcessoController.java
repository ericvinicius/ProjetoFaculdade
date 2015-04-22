package controller;

import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.GUIPrincipal;
import model.UsuarioCadastrado;
import model.UsuarioTentativa;

public class CodigoDeAcessoController {

	public static final int TAMANHO_CODIGO_DE_ACESSO = 4;
	public static int[] codigo = new int[TAMANHO_CODIGO_DE_ACESSO];
	public static int contadorDeClicks = -1;
	public static int tentativa = 0;

	public static boolean codigoOk() {
		return Arrays.equals(UsuarioTentativa.getCodigoDeAcesso(),
				UsuarioCadastrado.getCodigoDeAcesso());
	}

	public static void criaCodigoDeAcesso() {
		System.out.println("Cria Codigo de acesso!");
		UsuarioTentativa.setNovoCodigoDeAcesso(true);
	}

	public static void verificaCodigo(JFrame janela) {

		UsuarioTentativa.setCodigoDeAcesso(CodigoDeAcessoController.codigo);

		System.out.println("[Tentativa] codigo{"
				+ UsuarioTentativa.getCodigoDeAcesso().toString() + "}\n");

		if (UsuarioTentativa.isNovoCodigoDeAcesso()) {
			// TODO:Cadastrar novo codigo de acesso

		} else if (CodigoDeAcessoController.codigoOk()) {
			janela.dispose();
			new GUIPrincipal();
			JOptionPane.showMessageDialog(janela, "Logado com sucesso!");

		} else {
			Utilites.tremeTelaNormal(janela);
			CodigoDeAcessoController.contadorDeClicks = 0;
		}

	}

	public static int[] randomizaOrdemBotoes() {
		int[] ordemDosBotoes = { 0, 1, 2, 3, 4 };

		for (int i = 0; i < ordemDosBotoes.length; i++) {
			int posicaoAleatoria = (int) (Math.random() * 4);

			int aux = ordemDosBotoes[i];
			ordemDosBotoes[i] = ordemDosBotoes[posicaoAleatoria];
			ordemDosBotoes[posicaoAleatoria] = aux;
		}
		return ordemDosBotoes;
	}
}
