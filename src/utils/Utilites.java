package utils;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;

public class Utilites {
	
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



	public static void tremeTelaLogin(JFrame janela) {
		int originalX = janela.getLocation().x;
		int originalY = janela.getLocation().y;
		int originalHeight = janela.getHeight();
		int originalWidth = janela.getWidth();
		
		long sleepTime = 30;
		int aumento = 12;
		
		JLabel lblerro = new JLabel("Dados incorretos, tente novamente!");
		lblerro.setForeground(Color.RED);
		
		try {
			for (int i = 0; i <= 2; i++) {
				janela.setBounds(originalX + 5, originalY, originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				janela.setBounds(originalX + 5, originalY + 5, originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				janela.setBounds(originalX, originalY + 5, originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				janela.setBounds(originalX, originalY, originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				janela.setBounds(originalX - 5, originalY, originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				janela.setBounds(originalX - 5, originalY - 5, originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				janela.setBounds(originalX, originalY - 5, originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
			}
			janela.setLocation(originalX, originalY);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		
		janela.add(lblerro);
		
	}
}