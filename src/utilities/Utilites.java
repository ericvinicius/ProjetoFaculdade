package utilities;

import java.awt.Color;
import java.awt.Font;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;

import anotations.Log;

@Log
public class Utilites {

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
	public final String maskDiaHora = "dd/MM/yyyy - HH:mm:ss";
	public static final SimpleDateFormat formatDiaHora = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
	
	//Cores
	public static final Color corCinzaEscuro = new Color(212, 212, 212);

	// Fonts
	public final Font fontNormal = new Font("Arial", Font.PLAIN, 12);
	public final Font fontHover = new Font("Arial", Font.BOLD, 15);

	// Images
	public final ImageIcon imageLock = new ImageIcon("src/images/locked.png");
	public final ImageIcon imageUnlock = new ImageIcon("src/images/unlocked.png");
	public final ImageIcon br = new ImageIcon("src/images/Brazil-icon.png");
	public final ImageIcon es = new ImageIcon("src/images/Spain-icon.png");
	public final ImageIcon us = new ImageIcon("src/images/USA-icon.png");

	// boolean
	public static boolean temMensagemDeErro = false;

	// Idioma
	public static ResourceBundle bn;
	public static Locale local;
	
	//Log
	public Logger logger = new Logger();

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
				frame.setBounds(originalX + movimento, originalY, originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				frame.setBounds(originalX + movimento, originalY + movimento, originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				frame.setBounds(originalX, originalY + movimento, originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				frame.setBounds(originalX, originalY, originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				frame.setBounds(originalX - movimento, originalY, originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				frame.setBounds(originalX - movimento, originalY - movimento, originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);
				frame.setBounds(originalX, originalY - movimento, originalWidth, originalHeight + aumento);
				Thread.sleep(sleepTime);

			}
		} catch (InterruptedException ei) {
			logger.logError(ei, "Erro da thread que treme tela");
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
			logger.logError(ei, "Erro da thread que treme tela");
		}
	}

	public MaskFormatter criadorDeMascara(String mask) {
		MaskFormatter mascara = new MaskFormatter();
		mascara.setPlaceholderCharacter('_');

		try {
			mascara.setMask(mask);
		} catch (ParseException ep) {
			logger.logError(ep, "Erro ao criar uma mascara");
		}
		return mascara;

	}

	public String converteVetorParaString(int[] vetor) {
		StringBuilder saida = new StringBuilder();
		for (int i = 0; i < vetor.length; i++) {
			String numerosSeparados = getStringDaPosicaoDoVetor(vetor[i]);
			saida.append(numerosSeparados);

			if (i != vetor.length - 1) {
				saida.append(" | ");
			}
		}
		return saida.toString();
	}

	private String getStringDaPosicaoDoVetor(int numero) {
		String saida;
		int primeiro = numero / 10;
		int segundo = numero % 10;
		saida = primeiro + " ou " + segundo;
		return saida;
	}

	public void mostrarHoraNoLabel(JLabel labelHora) {
		new Relogio(labelHora).start();
	}

	public int criaLogicaDoCodigoDeAcesso(int linha) {
		return (33 * linha) + 25 + linha;
	}

	public int[] criaVetorComOrdemAleatoriaComQuatroPosicoes() {
		int[] ordemDosBotoes = { 0, 1, 2, 3, 4 };

		for (int i = 0; i < ordemDosBotoes.length; i++) {
			int posicaoAleatoria = (int) (Math.random() * 4);

			int aux = ordemDosBotoes[i];
			ordemDosBotoes[i] = ordemDosBotoes[posicaoAleatoria];
			ordemDosBotoes[posicaoAleatoria] = aux;
		}
		return ordemDosBotoes;
	}

	public String getValorComMoeda(BigDecimal valor) {
		NumberFormat moedaFormat = NumberFormat.getCurrencyInstance(local);
		return moedaFormat.format(valor);
	}
}
