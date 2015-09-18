package controllers;

import idioma.Idioma;

import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;

import utilities.Logger;
import views.GUIIdioma;

public class IdiomaControler extends GUIIdioma {
	
	public IdiomaControler() {
		super();
		br.addMouseListener(this);
		es.addMouseListener(this);
		us.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton click = (JButton) e.getSource();
		if(click == br){
			Idioma.local = new Locale("pt", "BR");
			Idioma.bn = ResourceBundle.getBundle("idioma", Idioma.local);
			
		} else if(click == us){
			Idioma.local = Locale.US;
			Idioma.bn = ResourceBundle.getBundle("idioma", Idioma.local);
			
		} else if(click == es){
			Idioma.local = new Locale("es", "ES");
			Idioma.bn = ResourceBundle.getBundle("idioma", Idioma.local);
		}
		Logger.info("Idioma", Idioma.local.getLanguage());
		redirect(this, LoginController.class);
	}
}


