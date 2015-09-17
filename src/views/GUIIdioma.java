package views;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import utilities.Utilites;

public class GUIIdioma extends GUIMyFrame implements MouseListener {
	
	protected JButton br, us, es;
	
	public GUIIdioma(){
		br = new JButton(Utilites.brGray);
		br.setOpaque(false);
		br.setContentAreaFilled(false);
		br.setBorderPainted(false);
		br.addMouseListener(this);
		add(br);
		
		us = new JButton(Utilites.usGray);
		us.setOpaque(false);
		us.setContentAreaFilled(false);
		us.setBorderPainted(false);
		us.addMouseListener(this);
		add(us);
		
		es = new JButton(Utilites.esGray);
		es.setOpaque(false);
		es.setContentAreaFilled(false);
		es.setBorderPainted(false);
		es.addMouseListener(this);
		add(es);
		
		configuraPagina();
	}
	
	@Override
	public void configuraPagina() {
		setLayout(new FlowLayout());
		setSize(450, 170);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		JButton bandeira = (JButton) e.getSource();
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
		JButton bandeira = (JButton) e.getSource();
		if(bandeira == br){
			br.setIcon(Utilites.brGray);
		} else if (bandeira == us){
			us.setIcon(Utilites.usGray);
		} else if(bandeira == es){
			es.setIcon(Utilites.esGray);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {}
	
	@Override
	public void mousePressed(MouseEvent e) {}
	
	@Override
	public void mouseReleased(MouseEvent e) {}
}
