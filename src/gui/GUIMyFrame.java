package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUIMyFrame extends JFrame {

	private JMenuBar barraDeMenu;
	protected JMenu opcoes;
	protected JMenuItem opcaoAdmin;

	public GUIMyFrame() {
		configuraTodasAsJanelas();
		
		barraDeMenu = new JMenuBar();
		opcoes = new JMenu("Opcoes");
		opcaoAdmin = new JMenuItem();
		opcoes.add(opcaoAdmin);
		
		barraDeMenu.add(opcoes);
		
		setJMenuBar(barraDeMenu);
	}

	private void configuraTodasAsJanelas() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// TODO: Trocar para false no fim do projeto
		setResizable(true);
	}
}
