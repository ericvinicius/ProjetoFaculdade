package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JLabel;

import modelos.Cliente;
import utilities.Logger;
import utilities.Utilites;
import views.GUIIdioma;

public class IdiomaControler extends GUIIdioma implements MouseListener {
	
	public IdiomaControler() {
		super();
		br.addMouseListener(this);
		es.addMouseListener(this);
		us.addMouseListener(this);
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
			redirect(this, LoginController.class);
			
			
		} else if(click == us){
			Utilites.local = Locale.US;
			Utilites.bn = ResourceBundle.getBundle("idioma", Utilites.local);
			Logger.info("Idioma", "Ingles");
			
			//TODO: Mover isto para o final do metodo no fim do projeto
			redirect(this, LoginController.class);
			
		} else if(click == es){
			Utilites.local = new Locale("es", "ES");
			Utilites.bn = ResourceBundle.getBundle("idioma", Utilites.local);
			Logger.info("Idioma", "Espanhol");
			
			//TODO: Remover no final do projeto
			user = new Cliente();
			user.setId(1L);
			redirect(this, LoginController.class);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JLabel bandeira = (JLabel) e.getSource();
		if(bandeira == br){
			br.setIcon(Utilites.br);
		} else if (bandeira == us){
			us.setIcon(Utilites.us);
		} else if(bandeira == es){
			es.setIcon(Utilites.es);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JLabel bandeira = (JLabel) e.getSource();
		if(bandeira == br){
			br.setIcon(Utilites.brGray);
		} else if (bandeira == us){
			us.setIcon(Utilites.usGray);
		} else if(bandeira == es){
			es.setIcon(Utilites.esGray);
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}


