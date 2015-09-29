package criptografia;

import textFile.ManipuladorDeArquivos;


public class Criptografador {

	private final static String i18n = "ISO-8859-1";
	private static CryptoAES caes = new CryptoAES();
	
	public static void main(String[] args) throws Exception {
		
		String string = new Criptografador().decriptografaAcesso();
		ManipuladorDeArquivos.escreveNoAcesso(string);
		System.out.println(string);
		
	}
	
	public String criptografaAcesso(){
		try {
			byte[] bytesMsgClara = ManipuladorDeArquivos.leArquivoTodoEmBytes();
			caes.geraCifra(bytesMsgClara);
			
			byte[] bytesMsgCifrada = caes.getTextoCifrado();
			
			return new String(bytesMsgCifrada, i18n);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String decriptografaAcesso(){
		byte[] msgCifrada = ManipuladorDeArquivos.leArquivoTodoEmBytes();
		try {
			caes.geraDecifra(msgCifrada);
			byte[] decifrado = caes.getTextoDecifrado();
			return new String(decifrado, i18n);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
