package br.com.eric.caixaEletronico.textFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

import br.com.eric.caixaEletronico.controller.Utilites;
import br.com.eric.caixaEletronico.model.UsuarioCadastrado;
import br.com.eric.caixaEletronico.model.UsuarioTentativa;

public class ReadTextFile {

	static Scanner leitor = null;

	public static boolean lerArquivoParaLogin(String arquivo) {

		try {
			leitor = new Scanner(new FileReader(arquivo))
					.useDelimiter("\\||\\n");

			while (leitor.hasNext()) {
				UsuarioCadastrado.setId(Integer.parseInt(leitor.next()));
				UsuarioCadastrado.setConta(leitor.next());
				UsuarioCadastrado.setAgencia(leitor.next());
				UsuarioCadastrado.setSenha(leitor.next().toCharArray());
				try{
					UsuarioCadastrado.setCodigoDeAcesso(leituraDoCodigoDeAcesso());
				} catch(Exception e){	
					Utilites.criaCodigoDeAcesso();
				}
				

				System.out.println("[Leitura atual] Id{"
						+ UsuarioCadastrado.getId() + "} --- Conta{"
						+ UsuarioCadastrado.getConta() + "} --- Agencia{"
						+ UsuarioCadastrado.getAgencia() + "} --- Senha{"
						+ UsuarioCadastrado.getSenha().toString()
						+ "} --- Codigo{"
						+ UsuarioCadastrado.getCodigoDeAcesso().toString() + "}\n");

				if (UsuarioCadastrado.getConta().equals(
						UsuarioTentativa.getConta())
						&& UsuarioCadastrado.getAgencia().equals(
								UsuarioTentativa.getAgencia())
						&& Arrays.equals(UsuarioCadastrado.getSenha(),
								UsuarioTentativa.getSenha())) {

					System.out.println("\n --- id ---> "
							+ UsuarioCadastrado.getId());
					System.out.println("\n --- conta ---> "
							+ UsuarioCadastrado.getConta());
					System.out.println("\n --- agencia ---> "
							+ UsuarioCadastrado.getAgencia());
					System.out.println("\n --- senha ---> "
							+ UsuarioCadastrado.getSenha().toString());
					System.out.println("\n --- codigo ---> "
							+ UsuarioCadastrado.getCodigoDeAcesso().toString());
					System.out.println("\n --- acesso ---> "
							+ UsuarioCadastrado.getAcesso() + "\n");

					leitor.close();
					return true;
				}
				leitor.nextLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("\nArquivo nao encontrado");
			e.printStackTrace();
		} finally {
			leitor.close();
		}
		return false;

	}

	private static int[] leituraDoCodigoDeAcesso() {
		int[] v = new int[Utilites.TAMANHO_CODIGO_DE_ACESSO];

		for (int i = 0; i < v.length; i++) {
			v[i] = Integer.parseInt(leitor.next());
		}
		return v;
	}
}