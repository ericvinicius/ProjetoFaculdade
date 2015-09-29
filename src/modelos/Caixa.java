package modelos;

import java.math.BigDecimal;

public class Caixa {
	private static int maxNotas10 = 1000;
	private static int maxNotas20 = 1000;
	private static int maxNotas50 = 500;
	
	private static int notas10 = maxNotas10;
	private static int notas20 = maxNotas20;
	private static int notas50 = maxNotas50;
	
	private static final BigDecimal v50 = new BigDecimal(50);
	private static final BigDecimal v20 = new BigDecimal(20);
	private static final BigDecimal v10 = new BigDecimal(10);
	
	private static final BigDecimal zero = BigDecimal.ZERO;
	
	private static int qtdSaque = 0;
	private static int qtdDebitoAutomatico = 0;
	private static int qtdTransferencia = 0;
	private static int qtdExtrato = 0;
	private static int qtdSaldo = 0;
	
	public static boolean podeSacar(Movimentacao movimentacao) {
		return true;
	}
	
	private static double getPorcentagemDeOperacoes(int valor){
		return (valor * 100) / getOperacoesTotais();
	}
	
	public static String getDadosQtdSaque(){
		return qtdSaque + " (" + getPorcentagemDeOperacoes(qtdSaque) + "%)";
	}
	
	public static String getDadosQtdDebitoAutomatico(){
		return qtdDebitoAutomatico + " (" + getPorcentagemDeOperacoes(qtdDebitoAutomatico) + "%)";
	}
		
	public static String getDadosQtdTransferencia(){
		return qtdTransferencia + " (" + getPorcentagemDeOperacoes(qtdTransferencia) + "%)";
	}
	
	public static String getDadosQtdExtato(){
		return qtdExtrato + " (" + getPorcentagemDeOperacoes(qtdExtrato) + "%)";
	}
	
	public static String getDadosQtdSaldo(){
		return qtdSaldo + " (" + getPorcentagemDeOperacoes(qtdSaldo) + "%)";
	}
	
	private static int getOperacoesTotais() {
		int total = qtdSaque + qtdDebitoAutomatico +qtdTransferencia + qtdExtrato + qtdSaldo;
		return total == 0 ? 1 : total;
	}

	public static String getDadosNotas10() {
		return "10 - " + notas10 + " (" + getPorcentagemNotas10() + "%)";
	}
	public static String getDadosNotas20() {
		return "20 - " + notas20 + " (" + getPorcentagemNotas20() + "%)";
	}
	public static String getDadosNotas50() {
		return "50 - " + notas50 + " (" + getPorcentagemNotas50() + "%)";
	}
	
	private static double getPorcentagemNotas10(){
		return (notas10 * 100) / maxNotas10;
	}
	private static double getPorcentagemNotas20(){
		return (notas20 * 100) / maxNotas20;
	}
	private static double getPorcentagemNotas50(){
		return (notas50 * 100) / maxNotas50;
	}
}
