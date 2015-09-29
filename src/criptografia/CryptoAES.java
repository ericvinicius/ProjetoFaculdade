package criptografia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptoAES {
	private byte[] textoCifrado;
	private byte[] textoDecifrado;
	private File fSim = new File("chave.simetrica");

	public CryptoAES() {
		textoCifrado = null;
		textoDecifrado = null;
	}

	public void geraChave() throws Exception {

		KeyGenerator kg = KeyGenerator.getInstance("AES");
		kg.init(128);
		SecretKey sk = kg.generateKey();

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fSim));
		oos.writeObject(sk);
		oos.close();
	}

	public void geraCifra(byte[] texto) throws Exception {

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fSim));
		SecretKey iSim = (SecretKey) ois.readObject();
		byte[] chave = iSim.getEncoded();
		ois.close();
		Cipher aescf = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec ivspec = new IvParameterSpec(new byte[16]);
		aescf.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(chave, "AES"), ivspec);
		textoCifrado = aescf.doFinal(texto);
	}

	public byte[] getTextoCifrado() throws Exception {
		return textoCifrado;
	}

	public void geraDecifra(byte[] texto) throws Exception {

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fSim));
		SecretKeySpec iSim = (SecretKeySpec) ois.readObject();
		ois.close();
		Cipher aescf = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec ivspec = new IvParameterSpec(new byte[16]);
		aescf.init(Cipher.DECRYPT_MODE, iSim, ivspec);
		textoDecifrado = aescf.doFinal(texto);
	}

	public byte[] getTextoDecifrado() throws Exception {
		return textoDecifrado;
	}
}
