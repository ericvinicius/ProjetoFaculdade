package utilities;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class Utilites extends Thread {

	// Variaveis globais
	private static final int TAMANHO_MAXIMO_DA_TAG_DE_LOG = 15;
	public static final int TAMANHO_CODIGO_DE_ACESSO = 3;
	public static final int MAXIMO_DE_TENTATIVAS_PARA_CODIGO_DE_ACESSO = 3;
	public static final String DELIMITADOR_DO_ARQUIVO_DE_TEXTO = "\\||\\n";
	public static final String CAMINHO_PARA_ACESSO_TXT = "/...ACESSO.txt";

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
			tremeTela(frame);
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
		} catch (InterruptedException ei) {
			paraLogDeErro(ei, "Utilites.tremeTelaComMessagemDeErro.ei",
					"Erro da thread que treme tela");
		}

		frame.setLocation(originalX, originalY);

		frame.add(lblerro);

	}

	public void tremeTela(JFrame janela) {
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

		} catch (InterruptedException ei) {
			paraLogDeErro(ei, "Utilites.tremeTela.ei",
					"Erro da thread que treme tela");
		}
	}

	public MaskFormatter criadorDeMascara(String mask) {
		MaskFormatter mascara = new MaskFormatter();
		mascara.setPlaceholderCharacter('_');

		try {
			mascara.setMask(mask);
		} catch (ParseException ep) {
			paraLogDeErro(ep, "Utilites.criadorDeMascara.ep",
					"Erro ao criar uma mascara");
		}
		return mascara;

	}

	public String converteVetorParaString(int[] vetor) {
		StringBuilder saida = new StringBuilder();
		saida.append("[");
		for (int i = 0; i < vetor.length; i++) {
			String numerosSeparados = getStringDaPosicaoDoVetor(vetor[i]);
			saida.append(numerosSeparados);

			if (i != vetor.length - 1) {
				saida.append(" | ");
			}
		}
		saida.append("]");
		return saida.toString();
	}

	private String getStringDaPosicaoDoVetor(int numero) {
		String saida;
		int primeiro = numero / 10;
		int segundo = numero % 10;
		saida = primeiro + " ou " + segundo;
		return saida;
	}

	public void mostrarHora(JLabel labelHora) {
		new Relogio(labelHora).start();
	}

	public int criaLogicaDoCodigoDeAcesso(int linha) {
		return (33 * linha) + 25 + linha;
	}

	public void paraLog(String tag, String texto) {
		int i = 0;
		String espaco = " ";
		while (tag.length() < Utilites.TAMANHO_MAXIMO_DA_TAG_DE_LOG) {
			if (i % 2 == 0) {
				tag = espaco + tag;
			} else {
				tag = tag + espaco;
			}
			i++;
		}
		if (tag.length() > Utilites.TAMANHO_MAXIMO_DA_TAG_DE_LOG) {
			tag.trim();
			while (tag.length() > Utilites.TAMANHO_MAXIMO_DA_TAG_DE_LOG) {
				tag = tag.substring(0, tag.length() - 1);
			}
		}
		System.out.println("[" + tag + "] " + texto);
	}

	public void paraLogDeErro(Exception e, String locate, String myMessage) {
		System.out
				.println("=========================================================ERRO============================================================================");
		System.out.println("Local=======>(" + locate + ") \nMessage=====>("
				+ e.getMessage() + ")\nMy Message==>(" + myMessage
				+ ")\nStack Trace: ");
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "Erro na Aplicação", "Erro",
				JOptionPane.ERROR_MESSAGE);
		System.out
				.println("=========================================================================================================================================");
	}
}
