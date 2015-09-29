package idioma;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import utilities.Utilites;

public class Idioma {

	private String pacoteAtual;
	private String traducao;
	public static ResourceBundle bn;
	public static Locale local;

	public Idioma() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		this.pacoteAtual = Utilites.removeJava(stackTrace[2].getFileName());
		this.traducao = pacoteAtual + ".";
	}

	public String translate(String texto) {
		String retorno = bn.getString(traducao + texto);
		reset();
		return retorno;
	}
	
	private void reset(){
		traducao = pacoteAtual + ".";
	}

	public static String getValorComMoeda(BigDecimal valor) {
		NumberFormat usdCostFormat = NumberFormat.getCurrencyInstance(local);
		return usdCostFormat.format(valor.doubleValue());
	}

	public static String getValorComMoeda(double parseDouble) {
		BigDecimal bigDecimal = new BigDecimal(parseDouble);
		return getValorComMoeda(bigDecimal);
	}

	public String translatePopUp(String texto) {
		addPopUp();
		return translate(texto);
	}

	public String translatePopUpTitle(String titulo) {
		addPopUp();
		addDot();
		addTitle();
		return translate(titulo);
	}

	private void addPopUp() {
		traducao += "popup";
	}

	private void addTitle() {
		traducao += "title";
	}

	public String getTitle() {
		addTitle();
		return translate("");
	}

	private void addDot() {
		traducao += ".";
	}

	public String getTitle(String texto) {
		addTitle();
		addDot();
		return translate(texto);
	}

	public String[] getTitulasDaTabela() {
		String[] titulos = new String[4];
		titulos[0] = translate("data");
		titulos[1] = translate("tipo");
		titulos[2] = translate("valor");
		titulos[3] = translate("novoSaldo");
		return titulos;
	}

	public String translateSaldo() {
		traducao = "MyPanel.saldo";
		String retorno = bn.getString(traducao);
		reset();
		return retorno;
	}

	public String[] getOpcoesDeSaque() {
		String[] titulos = new String[5];
		titulos[0] = translate("valor");
		titulos[1] = translate("10");
		titulos[2] = translate("20");
		titulos[3] = translate("50");
		titulos[4] = translate("100");
		return titulos;
	}
	
	public static String getTransferencia(){
		return bn.getString("GUIPrincipal.transferencia");
	}
	public static String getEntrada(){
		return bn.getString("GUIPrincipal.entrada");
	}
	public static String getSaida(){
		return bn.getString("GUIPrincipal.saida");
	}
	public static String getSaque(){
		return bn.getString("GUIPrincipal.saque");
	}
}
