package textFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import objects.Usuario;

public class ReadTextFile {

	private Scanner leitor;

	public Usuario lerArquivoParaLogin(String arquivo) {
		Usuario usurio = new Usuario();
		try {
			leitor = new Scanner(new FileReader("src/textFile/" + arquivo))
					.useDelimiter("\\||\\n");

			while (leitor.hasNext()) {
				usurio.setConta(leitor.next());
				System.out.println("conta ---> " + usurio.getConta());
				usurio.setAgencia(leitor.next());
				System.out.println("agencia ---> " + usurio.getAgencia());
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("\nArquivo nao encontrado");
			e.printStackTrace();
		} 
		fecharArquivo();
		return usurio;
	}

	public void fecharArquivo() {
		if (leitor != null)
			leitor.close();
	}
}