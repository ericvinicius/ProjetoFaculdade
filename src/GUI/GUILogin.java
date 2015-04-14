package GUI;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GUILogin extends GUIMyFrame{

	private int conta;
	private int agencia;
	private int senha;
	
	private JLabel btlogin;
	
	private ImageIcon imageLock;
	
	public GUILogin() {
		configuraJanela();
		carregaImagens();
	}

	private void carregaImagens() {
		imageLock = new ImageIcon("images/locked.png");
	}

	private void configuraJanela() {
		setLayout(new FlowLayout());
	}
}
