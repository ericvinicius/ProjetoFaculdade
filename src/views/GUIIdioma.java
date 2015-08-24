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
		br = new JLabel(Utilites.brGray);
		br.addMouseListener(this);
		add(br);
		
		us = new JLabel(Utilites.usGray);
		us.addMouseListener(this);
		add(us);
		
		es = new JLabel(Utilites.esGray);
		es.addMouseListener(this);
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
			redirect(this, GUIPrincipal.class);
			
			
		} else if(click == us){
			Utilites.local = Locale.US;
			Utilites.bn = ResourceBundle.getBundle("idioma", Utilites.local);
			Logger.info("Idioma", "Ingles");
			//TODO: Mover isto para o final do metodo no fim do projeto
			redirect(this, GUILogin.class);
			
		} else if(click == es){
			Utilites.local = new Locale("es", "ES");
			Utilites.bn = ResourceBundle.getBundle("idioma", Utilites.local);
			Logger.info("Idioma", "Espanhol");
			user = new Cliente();
			user.setId(1L);
			redirect(this, GUIPrincipal.class);
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
}
