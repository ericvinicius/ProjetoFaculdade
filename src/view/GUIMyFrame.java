package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import textFile.ManipuladorDeArquivos;
import utilities.Utilites;
import model.Usuario;

public class GUIMyFrame extends JFrame {

	private JMenuBar barraDeMenu;
	protected JMenu opcoes;
	protected JMenuItem opcaoAdmin;
	
	protected static Usuario user;
	protected ManipuladorDeArquivos fileHandler;

	public GUIMyFrame() {
		configuraJanela();
		fileHandler = new ManipuladorDeArquivos();
		
		barraDeMenu = new JMenuBar();
		opcoes = new JMenu("Opcoes");
		opcaoAdmin = new JMenuItem();
		
		barraDeMenu.add(opcoes);
		
		setJMenuBar(barraDeMenu);
	}

	public void configuraJanela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// TODO: Trocar para false no fim do projeto
		setResizable(true);
	}
	
	public void redirect(JFrame janelaAtual, String frame) {
		janelaAtual.dispose();
		Utilites.temMensagemDeErro = false;
		
		if(frame.equals("codigoDeAcesso")){
			new GUICodigoDeAcesso();
		} else if(frame.equals("principal")){
			new GUIPrincipal();
		} else if(frame.equals("login")){
			new GUILogin();
		}
	}
	
}
