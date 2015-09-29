package textFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import modelos.Cliente;
import modelos.ValidadorDeClientes;
import utilities.Logger;
import utilities.Utilites;
import builders.ClienteBuilder;
import criptografia.Criptografador;

public class ManipuladorDeArquivos {

	private ValidadorDeClientes validador = new ValidadorDeClientes();
	private Utilites utilites = new Utilites();
	private Cliente usuarioCadastrado;
	private Scanner leitor = null;
	private ClienteBuilder clienteBuilder = new ClienteBuilder();
	private ArrayList<Cliente> listaDeUsuarios;
	private static Criptografador criptografador = new Criptografador();

	public Cliente fazLeituraDoArquivoParaLogin(Cliente usuarioTentativa) {
		usuarioTentativa.toLog("Tentativa Login");
		
		String arquivoTodo = criptografador.decriptografaAcesso();
		System.out.println(arquivoTodo);
		
		try {
			leitor = new Scanner(arquivoTodo);
			leitor.useDelimiter(Utilites.DELIMITADOR_DO_ARQUIVO_DE_TEXTO);

			listaDeUsuarios = new ArrayList<Cliente>();

			while (leitor.hasNext()) {
				long id = Long.parseLong(leitor.next());

				int status = Integer.parseInt(leitor.next());
				String conta = leitor.next();
				String agencia = leitor.next();
				String senha = leitor.next();
				int[] codigoDeAcesso = leituraDoCodigoDeAcesso();

				usuarioCadastrado = clienteBuilder.comId(id).comStatus(status).comConta(conta).comAgencia(agencia).comSenha(senha).comCodigoDeAcesso(codigoDeAcesso)
						.constroi();

				usuarioCadastrado.toLog("Leitura Atual");
				listaDeUsuarios.add(usuarioCadastrado);
			}

		} catch (NumberFormatException en) {
			Logger.info("Leitura Completa", "Leitura do arquivo ACESSO.txt completa");
		} finally {
			if (leitor != null) {
				leitor.close();
			}
			Logger.info("Logger", "Leitor Fechado");
		}
		
		int inicio = 0;
		int fim = listaDeUsuarios.size() - 1;
		System.out.println("Fim = " + fim);

		while (inicio <= fim) {
			int meio = (inicio + fim) / 2;
			System.out.println(meio);
			usuarioCadastrado = listaDeUsuarios.get(meio);

			if (validador.possuemLoginIgual(usuarioCadastrado, usuarioTentativa)) {
				usuarioCadastrado.toLog("Usuario");
				leitor.close();
				return usuarioCadastrado;
				
			} else {
				int valor = usuarioTentativa.contaEmInt();
				
				if(valor > usuarioCadastrado.contaEmInt()){
					inicio = meio + 1;
				} else {
					fim = meio - 1;
				}
			}
		}

		return null;
	}

	public static String leArquivoTodo() {
		byte[] encoded = null;
		String saida = "";
		try {
			encoded = Files.readAllBytes(Paths.get(Utilites.CAMINHO_PARA_ACESSO_TXT));
			saida = new String(encoded, Utilites.i18n);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return saida;
	}

	public static byte[] leArquivoTodoEmBytes() {
		try {
			return Files.readAllBytes(Paths.get(Utilites.CAMINHO_PARA_ACESSO_TXT));
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private int[] leituraDoCodigoDeAcesso() {
		int[] v = new int[Utilites.TAMANHO_CODIGO_DE_ACESSO];
		int i;
		for (i = 0; i < v.length; i++) {
			v[i] = Integer.parseInt(leitor.next());

		}
		clienteBuilder.comNovoCodigo(v[--i] != 0 ? false : true);
		return v;
	}

	public static void escreveNoAcesso(String texto) {
		try {
			RandomAccessFile handler = new RandomAccessFile(Utilites.CAMINHO_PARA_ACESSO_TXT, "rws");
			handler.writeBytes(texto);
			handler.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void cadastraNovoCodigoDeAcessoParaUsuario(Cliente user) {
		int posDoCodigo = utilites.criaLogicaDoCodigoDeAcesso(user.getId());
		try {
			String codigo_0 = String.valueOf(user.getCodigoDeAcesso()[0]);
			String codigo_1 = String.valueOf(user.getCodigoDeAcesso()[1]);
			String codigo_2 = String.valueOf(user.getCodigoDeAcesso()[2]);
			RandomAccessFile handler = new RandomAccessFile(Utilites.CAMINHO_PARA_ACESSO_TXT, "rws");
			handler.seek(posDoCodigo);
			handler.write(codigo_0.getBytes());
			handler.skipBytes(1);
			handler.write(codigo_1.getBytes());
			handler.skipBytes(1);
			handler.write(codigo_2.getBytes());
			handler.close();

		} catch (FileNotFoundException ef) {
			Logger.error(ef, "Arquivo ACESSO.txt nao encontrado");
		} catch (IOException eio) {
			Logger.error(eio, "Nao conseguiu gravar no arquivo, erro de permissao");
		}
	}

	public Cliente usuarioExiste(Cliente usuarioTentativa) {
		usuarioTentativa.toLog("Tentat Transf");
		try {
			leitor = new Scanner(new FileReader(Utilites.CAMINHO_PARA_ACESSO_TXT));
			leitor.useDelimiter(Utilites.DELIMITADOR_DO_ARQUIVO_DE_TEXTO);

			while (leitor.hasNext()) {
				long id = Long.parseLong(leitor.next());
				int status = Integer.parseInt(leitor.next());
				String conta = leitor.next();
				String agencia = leitor.next();
				String senha = leitor.next();
				int[] codigoDeAcesso = leituraDoCodigoDeAcesso();

				usuarioCadastrado = clienteBuilder.comId(id).comStatus(status).comConta(conta).comAgencia(agencia).comSenha(senha).comCodigoDeAcesso(codigoDeAcesso)
						.constroi();

				usuarioCadastrado.toLog("Leitura Transf");

				if (validador.possuemAgenciaEContaIguais(usuarioCadastrado, usuarioTentativa)) {
					usuarioCadastrado.toLog("Usuario Transf");
					leitor.close();
					return usuarioCadastrado;
				}
			}

		} catch (FileNotFoundException ef) {
			Logger.error(ef, "Arquivo ACESSO.txt nao encontrado");
		} catch (NumberFormatException en) {
			Logger.warn("Sem Cadastro", "Usuario da transferencia não foi encontrado no arquivo ACESSO.txt");
		} finally {
			if (leitor != null) {
				leitor.close();
			}
		}
		return null;
	}
	
//	public static void main(String[] args) throws Exception {
//		String string = criptografador.criptografaAcesso();
//		ManipuladorDeArquivos.escreveNoAcesso(string);
//		System.out.println(string);
//		
//	}
	
}