package utilities;

import java.awt.Color;
import java.awt.Font;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;

public class Utilites {

	// Variaveis globais
	public static final int TAMANHO_CODIGO_DE_ACESSO = 3;
	public static final int MAXIMO_DE_TENTATIVAS_PARA_CODIGO_DE_ACESSO = 3;
	public static final String DELIMITADOR_DO_ARQUIVO_DE_TEXTO = "\\||\\n";
	public static final String CAMINHO_PARA_ACESSO_TXT = "acesso/ACESSO.txt";
	public static final String i18n = "ISO-8859-1";
	public final BigDecimal saldoInicial = new BigDecimal(2000.00);
	
	// Mascaras
	public final String maskFiltraTabela = "###";
	public final String maskAgencia = "####-#";
	public final String maskConta = "##.###-#";
	public final String maskDia = "dd/MM/yyyy";
	public final String maskHora = "HH:mm:ss";
	public final String maskDiaHora = "dd/MM/yyyy - HH:mm:ss";
	public final static SimpleDateFormat formatDiaHora = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
	public final static DateTimeFormatter formatDia = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	//Cores
	public static final Color corCinzaEscuro = new Color(212, 212, 212);
	public static final Color corBranco = new Color(255, 255, 255);
	public static final Color corAzul = new Color(148, 200, 252);

	// Fonts
	public final Font fontNormal = new Font("Arial", Font.PLAIN, 12);
	public final Font fontHover = new Font("Arial", Font.BOLD, 15);

	// Images
	public static final ImageIcon imageLock = new ImageIcon("images/locked.png");
	public static final ImageIcon imageUnlock = new ImageIcon("images/unlocked.png");
	public static final ImageIcon creditCard = new ImageIcon("images/creditcard.png");
	public static final ImageIcon br = new ImageIcon("images/Brazil-icon.png");
	public static final ImageIcon es = new ImageIcon("images/Spain-icon.png");
	public static final ImageIcon us = new ImageIcon("images/USA-icon.png");
	public static final ImageIcon brGray = new ImageIcon("images/Brazil-icon-gray.png");
	public static final ImageIcon esGray = new ImageIcon("images/Spain-icon-gray.png");
	public static final ImageIcon usGray = new ImageIcon("images/USA-icon-gray.png");
	public static final ImageIcon brgif = new ImageIcon("images/brazil_gifs");

	// boolean
	public static boolean temMensagemDeErro = false;
	
	
	public DecimalFormat getFormatacaoParaNumeros(){
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
		decimalFormat.setGroupingUsed(false);
		return decimalFormat;
	}

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
			Logger.error(ei, "Erro da thread que treme tela");
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
			Logger.error(ei, "Erro da thread que treme tela");
		}
	}

	public MaskFormatter criadorDeMascara(String mask, boolean placeHolder) {
		MaskFormatter mascara = new MaskFormatter();
		if(placeHolder){
			mascara.setPlaceholderCharacter('_');
		}

		try {
			mascara.setMask(mask);
		} catch (ParseException ep) {
			Logger.error(ep, "Erro ao criar uma mascara");
		}
		return mascara;

	}

	public String converteCodigoDeAcessoParaString(int[] vetor) {
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

	public int criaLogicaDoCodigoDeAcesso(Long l) {
		int linha = Integer.parseInt(l + "");
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

	public static Calendar hojeEmCalendar(){
		return Calendar.getInstance();
	}

	public static String removeJava(String arquivo) {
		char[] letras = arquivo.toCharArray();
		
		char letra = letras[0];
		String saida = "";
		
		for(int i = 0; i < letras.length; i++) {
			letra = letras[i];
			if(letra == '.'){
				break;
			} else {
				saida += letra;
			}
			
		}
		
		return saida;
	}
}
