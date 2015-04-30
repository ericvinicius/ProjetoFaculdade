package controller;

import java.util.Arrays;

import javax.swing.JFrame;

import model.UsuarioTentativa;
import textFile.ReadTextFile;
import view.GUICodigoDeAcesso;
import view.GUILogin;

public class LoginController {
	
	private static JFrame frameLogin;
	
	public static void setFrameLogin(JFrame frameLogin) {
		LoginController.frameLogin = frameLogin;
	}

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
				Utilites.tremeTelaComMensagemDeErro(frameLogin);
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
			if(Utilites.temMensagemDeErro){
				Utilites.removeMensagemDeErro(frameLogin);
			}
			return true;
		}
		return false;

	}

	public static boolean armazenaLogin() {
		try {
			UsuarioTentativa.setAgencia(GUILogin.txtagencia.getValue()
					.toString());
			UsuarioTentativa.setConta(GUILogin.txtconta.getValue().toString());
			UsuarioTentativa.setSenha(GUILogin.txtsenha.getPassword());
			return false;
		} catch (Exception e) {
			Utilites.tremeTelaComMensagemDeErro(frameLogin);
			return true;
		}
	}

}
