package utilities;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;

public class Utilites extends Thread {

	// Variaveis globais
	public static final int TAMANHO_CODIGO_DE_ACESSO = 3;
	public static final int MAXIMO_DE_TENTATIVAS_PARA_CODIGO_DE_ACESSO = 3;
	public static final String DELIMITADOR_DO_ARQUIVO_DE_TEXTO = "\\||\\n";
	public static final String CAMINHO_PARA_ACESSO_TXT = "ACESSO.txt";

	// Mascaras
	public final String maskAgencia = "####-#";
	public final String maskConta = "##.###-#";
	public final String maskDia = "dd/MM/yyyy";
	public final String maskHora = "HH:mm:ss";

	// Fonts
	public final Font fontNormal = new Font("Arial", Font.PLAIN, 12);
	public final Font fontHover = new Font("Arial", Font.BOLD, 15);

	// Images
	public final ImageIcon imageLock = new ImageIcon("src/images/locked.png");
	public final ImageIcon imageUnlock = new ImageIcon(
			"src/images/unlocked.png");

	// boolean
	public static boolean temMensagemDeErro = false;

	public void tremeTelaComMensagemDeErro(JFrame frame) {
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

	public static MaskFormatter criadorDeMascara(String mask) {
		MaskFormatter mascara = new MaskFormatter();
		mascara.setPlaceholderCharacter('_');

		try {
			mascara.setMask(mask);
		} catch (Exception e) {
			System.out.println("Erro na criacao de mascara!");
			e.printStackTrace();
		}
		return mascara;

	}

	
	public static String converteVetorParaString(int[] vetor){
		StringBuilder saida = new StringBuilder();  
		saida.append("[");
		for (int i = 0; i < vetor.length; i++) {
			String numerosSeparados = getStringDaPosicaoDoVetor(vetor[i]);
			saida.append(numerosSeparados);
			
			if(i != vetor.length - 1){
				saida.append(" | ");
			}
		}
		saida.append("]");
		return saida.toString();
	}

	private static String getStringDaPosicaoDoVetor(int numero) {
		String saida;
		int primeiro = numero / 10;
		int segundo = numero % 10;
		saida = primeiro + " ou " + segundo;
		return saida;
	}
	
	public static void mostrarHora(JLabel labelHora) {
		new Relogio(labelHora).start();
	}
}
