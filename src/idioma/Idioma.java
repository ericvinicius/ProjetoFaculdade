package idioma;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Idioma {
	
	private String pacoteAtual;
	public static ResourceBundle bn;
	public static Locale local;

	public Idioma(Class<?> clazz){
		this.pacoteAtual = clazz.getSimpleName();
	}
	
	public String translate(String texto){
		return bn.getString(pacoteAtual + "." + texto);
	}
	
	public static String getValorComMoeda(BigDecimal valor) {
		NumberFormat usdCostFormat = NumberFormat.getCurrencyInstance(local);
		return usdCostFormat.format(valor.doubleValue());
	}

	public static String getValorComMoeda(double parseDouble) {
		BigDecimal bigDecimal = new BigDecimal(parseDouble);
		return getValorComMoeda(bigDecimal);
	}

	public String translateToPopUp(String texto) {
		return bn.getString(pacoteAtual + ".popup" + texto);
	}
}
