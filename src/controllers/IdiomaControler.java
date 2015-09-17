package controllers;

import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;

import modelos.Cliente;
import utilities.Logger;
import utilities.Utilites;
import views.GUIIdioma;
import views.GUIPrincipal;

public class IdiomaControler extends GUIIdioma {
	
	public IdiomaControler() {
		super();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton click = (JButton) e.getSource();
		if(click == br){
			Utilites.local = new Locale("pt", "BR");
			Utilites.bn = ResourceBundle.getBundle("idioma", Utilites.local);
			Logger.info("Idioma", "Portugues");
			
			//TODO: Remover no final do projeto
			user = new Cliente();
			user.setId(2L);
			redirect(this, GUIPrincipal.class);
			
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
			redirect(this, GUIPrincipal.class);
		}
	}
}


