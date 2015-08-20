package views;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JLabel;

import modelos.Cliente;
import utilities.Logger;
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
			Logger.info("Idioma", "Portugues");
			//TODO: Remover no final do projeto
			user = new Cliente();
			user.setId(2L);
			redirect(this, "principal");
			
			
		} else if(click == us){
			Utilites.local = Locale.US;
			Utilites.bn = ResourceBundle.getBundle("idioma", Utilites.local);
			Logger.info("Idioma", "Ingles");
			//TODO: Mover isto para o final do metodo no fim do projeto
			redirect(this, "login");
			
		} else if(click == es){
			Utilites.local = new Locale("es", "ES");
			Utilites.bn = ResourceBundle.getBundle("idioma", Utilites.local);
			Logger.info("Idioma", "Espanhol");
			user = new Cliente();
			user.setId(1L);
			redirect(this, "principal");
		}
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
