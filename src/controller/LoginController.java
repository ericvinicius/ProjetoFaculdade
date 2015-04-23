package controller;

import java.awt.Color;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.UsuarioTentativa;
import textFile.ReadTextFile;
import view.GUICodigoDeAcesso;
import view.GUILogin;

public class LoginController {
	
	public static JFrame frameLogin;
	private static boolean jaTremeuATelaDeLogin = false;

	public static void clickLogin() {
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

			} else {
				tremeTelaLogin();
			}
		}
	}

	public static boolean loginOk() {
		if (ReadTextFile.fazLeituraDoArquivoParaLogin("ACESSO.txt")) {
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
			removeMensagemDeErro();
			return true;
		}
		return false;

	}

	private static void removeMensagemDeErro() {
		if(jaTremeuATelaDeLogin){
			frameLogin.setSize(frameLogin.getWidth(), frameLogin.getHeight() - 20);
		}
		
	}

	public static void tremeTelaLogin() {
		if (jaTremeuATelaDeLogin) {
			Utilites.tremeTelaNormal(frameLogin);
			return;
		}
		jaTremeuATelaDeLogin = true;
		int originalX = frameLogin.getLocation().x;
		int originalY = frameLogin.getLocation().y;
		int originalHeight = frameLogin.getHeight();
		int originalWidth = frameLogin.getWidth();

		long sleepTime = 30;
		int aumento = 12;
		int movimento = 5;

		JLabel lblerro = new JLabel("Dados incorretos, tente novamente!");
		lblerro.setForeground(Color.RED);

		try {
			for (int i = 0; i <= 2; i++) {
				frameLogin.setBounds(originalX + movimento, originalY,
						originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				frameLogin.setBounds(originalX + movimento, originalY + movimento,
						originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				frameLogin.setBounds(originalX, originalY + movimento,
						originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				frameLogin.setBounds(originalX, originalY, originalWidth,
						originalHeight + aumento);
				Thread.sleep(sleepTime);
				frameLogin.setBounds(originalX - movimento, originalY,
						originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				frameLogin.setBounds(originalX - movimento, originalY - movimento,
						originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				frameLogin.setBounds(originalX, originalY - movimento,
						originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
			}
			frameLogin.setLocation(originalX, originalY);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		frameLogin.add(lblerro);

	}

	public static boolean armazenaLogin() {

		try {
			UsuarioTentativa.setAgencia(GUILogin.txtagencia.getValue()
					.toString());
			UsuarioTentativa.setConta(GUILogin.txtconta.getValue().toString());
			UsuarioTentativa.setSenha(GUILogin.txtsenha.getPassword());
			return false;
		} catch (Exception e) {
			tremeTelaLogin();
			return true;
		}
	}

}
