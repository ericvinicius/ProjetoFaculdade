package textFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

import objects.UsuarioCadastrado;
import objects.UsuarioTentativa;

public class ReadTextFile {
	public static boolean lerArquivoParaLogin(String arquivo) {
		Scanner leitor = null;
		try {
			leitor = new Scanner(new FileReader(arquivo))
					.useDelimiter("\\||\\n");

			while (leitor.hasNext()) {
				UsuarioCadastrado.setConta(leitor.next());
				UsuarioCadastrado.setAgencia(leitor.next());
				UsuarioCadastrado.setSenha(leitor.next().toCharArray());

				System.out.println("[Leitura atual] Conta{"
						+ UsuarioCadastrado.getConta() + "} --- Agencia{"
						+ UsuarioCadastrado.getAgencia() + "} --- Senha{"
						+ UsuarioCadastrado.getSenha() + "}\n");

				if (UsuarioCadastrado.getConta().equals(
						UsuarioTentativa.getConta())
						&& UsuarioCadastrado.getAgencia().equals(
								UsuarioTentativa.getAgencia())
						&& Arrays.equals(UsuarioCadastrado.getSenha(),
								UsuarioTentativa.getSenha())) {

					System.out.println("\n --- conta ---> "
							+ UsuarioCadastrado.getConta());
					System.out.println("\n --- agencia ---> "
							+ UsuarioCadastrado.getAgencia());
					System.out.println("\n --- senha ---> "
							+ UsuarioCadastrado.getSenha());
					
					leitor.close();
					return true;
				}

			}

		} catch (FileNotFoundException e) {
			System.out.println("\nArquivo nao encontrado");
			e.printStackTrace();
		}
		leitor.close();
		return false;

	}
}