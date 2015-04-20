package br.com.eric.caixaEletronico.controller;

import java.awt.Color;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;

import br.com.eric.caixaEletronico.model.UsuarioCadastrado;
import br.com.eric.caixaEletronico.model.UsuarioTentativa;
import br.com.eric.caixaEletronico.textFile.ReadTextFile;

public class Utilites {

	public static final int TAMANHO_CODIGO_DE_ACESSO = 4;

	public static void tremeTelaNormal(JFrame janela) {
		try {
			int originalX = janela.getLocation().x;
			int originalY = janela.getLocation().y;
			long sleepTime = 30;

			for (int i = 0; i <= 2; i++) {
				janela.setLocation(originalX + 5, originalY);
				Thread.sleep(sleepTime);
				janela.setLocation(originalX + 5, originalY + 5);
				Thread.sleep(sleepTime);
				janela.setLocation(originalX, originalY + 5);
				Thread.sleep(sleepTime);
				janela.setLocation(originalX, originalY);
				Thread.sleep(sleepTime);
				janela.setLocation(originalX - 5, originalY);
				Thread.sleep(sleepTime);
				janela.setLocation(originalX - 5, originalY - 5);
				Thread.sleep(sleepTime);
				janela.setLocation(originalX, originalY - 5);
				Thread.sleep(sleepTime);
			}

			janela.setLocation(originalX, originalY);

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	public static MaskFormatter criadorDeMascara(String paraOnde) {
		MaskFormatter mascara = new MaskFormatter();
		mascara.setPlaceholderCharacter('_');

		try {
			if (paraOnde.equals("conta")) {
				mascara.setMask("##.###-#");

			} else if (paraOnde.equals("agencia")) {
				mascara.setMask("####-#");
			}
		} catch (Exception e) {
			System.out.println("Erro no Formatador - Classe GUIMyFrame");
		}
		return mascara;

	}

	public static boolean codigoDeAcessoOk() {
		return Arrays.equals(UsuarioTentativa.getCodigoDeAcesso(), UsuarioCadastrado.getCodigoDeAcesso());
	}

	public static void criaCodigoDeAcesso() {
		System.out.println("Cria Codigo de acesso!");
		UsuarioTentativa.setNovoCodigoDeAcesso(true);
	}
}
