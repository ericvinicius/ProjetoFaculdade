package textFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import builders.ClienteBuilder;
import modelos.Cliente;
import modelos.ValidadorDeClientes;
import utilities.Logger;
import utilities.Utilites;

public class ManipuladorDeArquivos {

	private ValidadorDeClientes validador = new ValidadorDeClientes();
	private Utilites utilites = new Utilites();
	private Cliente usuarioCadastrado;
	private Scanner leitor = null;
	private ClienteBuilder clienteBuilder = new ClienteBuilder();

	public Cliente fazLeituraDoArquivoParaLogin(Cliente usuarioTentativa) {
		usuarioTentativa.toLog("Tentata Login");
		try {
			leitor = new Scanner(new FileReader(Utilites.CAMINHO_PARA_ACESSO_TXT));
			leitor.useDelimiter(Utilites.DELIMITADOR_DO_ARQUIVO_DE_TEXTO);

			while (leitor.hasNext()) {
				usuarioCadastrado = clienteBuilder.comId(Long.parseLong(leitor.next())).comStatus(Integer.parseInt(leitor.next())).comConta(leitor.next())
						.comAgencia(leitor.next()).comSenha(leitor.next()).comCodigoDeAcesso(leituraDoCodigoDeAcesso()).constroi();

				usuarioCadastrado.toLog("Leitura Atual");

				if (validador.validaLogin(usuarioCadastrado, usuarioTentativa)) {
					usuarioCadastrado.toLog("Usuario");
					leitor.close();
					return usuarioCadastrado;
				}
			}

		} catch (FileNotFoundException ef) {
			Logger.error(ef, "Arquivo ACESSO.txt nao encontrado");
		} catch (NumberFormatException en) {
			// Se cair nesta exception quer dizer que o leitor chegou na linha
			// do meu texto no arquivo de ACESSO
			Logger.warn("Sem Cadastro", "Usuario não encontrado no arquivo ACESSO.txt");
		} finally {
			if (leitor != null) {
				leitor.close();
			}
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

	public boolean usuarioExiste(Cliente usuarioTentativa) {
		usuarioTentativa.toLog("Tentat Transf");
		try {
			leitor = new Scanner(new FileReader(Utilites.CAMINHO_PARA_ACESSO_TXT));
			leitor.useDelimiter(Utilites.DELIMITADOR_DO_ARQUIVO_DE_TEXTO);

			while (leitor.hasNext()) {
				usuarioCadastrado = clienteBuilder.comId(Long.parseLong(leitor.next())).comStatus(Integer.parseInt(leitor.next())).comConta(leitor.next())
						.comAgencia(leitor.next()).comSenha(leitor.next()).comCodigoDeAcesso(leituraDoCodigoDeAcesso()).constroi();

				usuarioCadastrado.toLog("Leitura Transf");

				if (validador.validaClienteExistente(usuarioCadastrado, usuarioTentativa)) {
					usuarioCadastrado.toLog("Usuario Transf");
					leitor.close();
					return true;
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
		return false;
	}
}