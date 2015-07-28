package textFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import model.Usuario;
import utilities.Utilites;

public class ManipuladorDeArquivos {

	static Scanner leitor = null;
	private Usuario usuarioCadastrado;

	public Usuario fazLeituraDoArquivoParaLogin(Usuario usuarioTentativa) {

		try {
			leitor = new Scanner(new FileReader(Utilites.CAMINHO_PARA_ACESSO_TXT));
			leitor.useDelimiter(Utilites.DELIMITADOR_DO_ARQUIVO_DE_TEXTO);
			
			while (leitor.hasNext()) {
				usuarioCadastrado = new Usuario();
				usuarioCadastrado.setId(Integer.parseInt(leitor.next()));
				usuarioCadastrado.setStatus(Integer.parseInt(leitor.next()));
				usuarioCadastrado.setConta(leitor.next());
				usuarioCadastrado.setAgencia(leitor.next());
				usuarioCadastrado.setSenha(leitor.next());
				usuarioCadastrado.setCodigoDeAcesso(leituraDoCodigoDeAcesso());
				
				usuarioCadastrado.toLog("Leitura Atual");

				if(usuarioCadastrado.fazComparacaoParaLogin(usuarioTentativa)){
					System.out.println("=======================================================================================");
					usuarioCadastrado.toLog("Usuario");
					leitor.close();
					return usuarioCadastrado;
				}
			}
			
		} catch (FileNotFoundException ef) {
			//TODO: Erro de Arquivo nao Encontrado
		} catch (NumberFormatException en){
			//TODO: Erro de Conversao
		} finally {
			leitor.close();
		}
		return null;

	}

	private int[] leituraDoCodigoDeAcesso() throws NumberFormatException {
		int[] v = new int[Utilites.TAMANHO_CODIGO_DE_ACESSO];
		int i;
		for (i = 0; i < v.length; i++) {
			v[i] = Integer.parseInt(leitor.next());
			
		}
		usuarioCadastrado.setNovoCodigoDeAcesso(v[--i] != 0 ? false : true);
		return v;
	}
	
	public void cadastraNovoCodigoDeAcessoParaUsuario(Usuario user){
		Utilites utilites = new Utilites();
		int posDoCodigo = utilites.criaLogicaDoCodigoDeAcesso(user.getId());
		try {
			String codigo_0 = String.valueOf(user.getCodigoDeAcesso()[0]);
			String codigo_1 = String.valueOf(user.getCodigoDeAcesso()[1]);
			String codigo_2 = String.valueOf(user.getCodigoDeAcesso()[2]);
			System.out.println("1: " + codigo_0 + " - 2: " + codigo_1 + " - 3: " + codigo_2);
			RandomAccessFile handler = new RandomAccessFile(Utilites.CAMINHO_PARA_ACESSO_TXT, "rws");
			handler.seek(posDoCodigo);
			handler.write(codigo_0.getBytes());
			handler.skipBytes(1);
			handler.write(codigo_1.getBytes());
			handler.skipBytes(1);
			handler.write(codigo_2.getBytes());
			handler.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}