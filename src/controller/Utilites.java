package controller;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;

public class Utilites {
	
	//Fonts
	public static Font fontNormal = new Font("Arial", Font.PLAIN, 12);
	public static Font fontHover = new Font("Arial", Font.BOLD, 15);
	
	//Images
	public static ImageIcon imageLock = new ImageIcon("src/images/locked.png");
	public static ImageIcon imageUnlock = new ImageIcon("src/images/unlocked.png");
	public static boolean temMensagemDeErro = false;
	
	public static void removeMensagemDeErro(JFrame frame) {
		frame.setSize(frame.getWidth(), frame.getHeight() - 20);	
	}

	public static void tremeTelaComMensagemDeErro(JFrame frame) {
		if (temMensagemDeErro) {
			Utilites.tremeTelaNormal(frame);
			return;
		}
		temMensagemDeErro = true;
		int originalX = frame.getLocation().x;
		int originalY = frame.getLocation().y;
		int originalHeight = frame.getHeight();
		int originalWidth = frame.getWidth();

		long sleepTime = 30;
		int aumento = 12;
		int movimento = 5;

		JLabel lblerro = new JLabel("Dados incorretos, tente novamente!");
		lblerro.setForeground(Color.RED);

		try {
			for (int i = 0; i <= 2; i++) {
				frame.setBounds(originalX + movimento, originalY,
						originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				frame.setBounds(originalX + movimento, originalY + movimento,
						originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				frame.setBounds(originalX, originalY + movimento,
						originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				frame.setBounds(originalX, originalY, originalWidth,
						originalHeight + aumento);
				Thread.sleep(sleepTime);
				frame.setBounds(originalX - movimento, originalY,
						originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				frame.setBounds(originalX - movimento, originalY - movimento,
						originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				frame.setBounds(originalX, originalY - movimento,
						originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
			}
			frame.setLocation(originalX, originalY);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		frame.add(lblerro);

	}

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
}
