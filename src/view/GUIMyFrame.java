package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.Utilites;

public class GUIMyFrame extends JFrame {

	private JMenuBar barraDeMenu;
	protected JMenu opcoes;
	protected JMenuItem opcaoAdmin;

	public GUIMyFrame() {
		Utilites.temMensagemDeErro=false;
		configuraJanela();
		
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
	
}