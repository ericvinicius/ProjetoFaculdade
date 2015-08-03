package views;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JLabel;

import utilities.Utilites;

public class GUIIdioma extends GUIMyFrame implements MouseListener {
	
	private JLabel br, us, es;
	
	public GUIIdioma(){
		br = new JLabel(utilites.br);
		br.addMouseListener(this);
		add(br);
		
		us = new JLabel(utilites.us);
		us.addMouseListener(this);
		add(us);
		
		es = new JLabel(utilites.es);
		es.addMouseListener(this);
		add(es);
		
		configuraPagina();
	}
	
	private void configuraPagina() {
		setLayout(new FlowLayout());
		setSize(450, 160);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel click = (JLabel) e.getSource();
		if(click == br){
			Utilites.local = new Locale("pt", "BR");
			Utilites.bn = ResourceBundle.getBundle("idioma", Utilites.local);
			utilites.logger.logInfo("Idioma", "Portugues");
			
		} else if(click == us){
			Utilites.local = Locale.US;
			Utilites.bn = ResourceBundle.getBundle("idioma", Utilites.local);
			utilites.logger.logInfo("Idioma", "Ingles");
			
		} else if(click == es){
			Utilites.local = new Locale("es", "ES");
			Utilites.bn = ResourceBundle.getBundle("idioma", Utilites.local);
			utilites.logger.logInfo("Idioma", "Espanhol");
		}
		this.dispose();
		new GUILogin();
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
