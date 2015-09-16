package views;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import utilities.Utilites;

public class GUIIdioma extends GUIMyFrame {
	
	protected JLabel br, us, es;
	
	public GUIIdioma(){
		br = new JLabel(Utilites.brGray);
		add(br);
		
		us = new JLabel(Utilites.usGray);
		add(us);
		
		es = new JLabel(Utilites.esGray);
		add(es);
		
		configuraPagina();
	}
	
	@Override
	public void configuraPagina() {
		setLayout(new FlowLayout());
		setSize(450, 160);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
