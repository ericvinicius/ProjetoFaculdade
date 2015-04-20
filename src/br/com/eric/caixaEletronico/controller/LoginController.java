package br.com.eric.caixaEletronico.controller;

import java.awt.Color;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;

import br.com.eric.caixaEletronico.model.UsuarioTentativa;
import br.com.eric.caixaEletronico.textFile.ReadTextFile;
import br.com.eric.caixaEletronico.view.GUICodigoDeAcesso;

public class LoginController {

	private static boolean jaTremeuATelaDeLogin = false;

	public static void clickLogin(JFrame frameLogin) {
		try {

			System.out.println("[Tentativa] conta{"
					+ UsuarioTentativa.getConta() + "} --- agencia{"
					+ UsuarioTentativa.getAgencia() + "} --- senha{"
					+ UsuarioTentativa.getSenha().toString() + "}\n");

		} catch (Exception e1) {
			System.out
					.println("Usuario deixou os campos em branco na tela de login!\n");

		} finally {
			if (loginOk()) {
				frameLogin.dispose();
				new GUICodigoDeAcesso();

			} else if (jaTremeuATelaDeLogin) {
				Utilites.tremeTelaNormal(frameLogin);

			} else {
				jaTremeuATelaDeLogin = true;
				tremeTelaLogin(frameLogin);
			}
		}
	}

	public static boolean loginOk() {
		if (ReadTextFile.lerArquivoParaLogin("ACESSO.txt")) {
			return true;
		}
		return false;
	}

	public static boolean verificaAdmin() {
		String zero = "0000";
		if (UsuarioTentativa.getConta().equals("00.000-0")
				&& UsuarioTentativa.getAgencia().equals("0000-0")
				&& Arrays.equals(UsuarioTentativa.getSenha(),
						zero.toCharArray())) {
			return true;
		}
		return false;
	}

	public static void tremeTelaLogin(JFrame janela) {
		int originalX = janela.getLocation().x;
		int originalY = janela.getLocation().y;
		int originalHeight = janela.getHeight();
		int originalWidth = janela.getWidth();

		long sleepTime = 30;
		int aumento = 12;
		int movimento = 5;

		JLabel lblerro = new JLabel("Dados incorretos, tente novamente!");
		lblerro.setForeground(Color.RED);

		try {
			for (int i = 0; i <= 2; i++) {
				janela.setBounds(originalX + movimento, originalY,
						originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				janela.setBounds(originalX + movimento, originalY + movimento,
						originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				janela.setBounds(originalX, originalY + movimento,
						originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				janela.setBounds(originalX, originalY, originalWidth,
						originalHeight + aumento);
				Thread.sleep(sleepTime);
				janela.setBounds(originalX - movimento, originalY,
						originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				janela.setBounds(originalX - movimento, originalY - movimento,
						originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				janela.setBounds(originalX, originalY - movimento,
						originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
			}
			janela.setLocation(originalX, originalY);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		janela.add(lblerro);

	}

}
