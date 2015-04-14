package GUI;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GUILogin extends GUIMyFrame implements MouseListener{

	private int conta;
	private int agencia;
	private int senha;
	
	private JLabel btlogin;
	
	private ImageIcon imageLock;
	private ImageIcon imageUnlock;
	
	public GUILogin() {
		configuraJanela();
		carregaImagens();
		
		btlogin = new JLabel(imageLock);
		btlogin.addMouseListener(this);
		
		add(btlogin);
	}

	private void carregaImagens() {
		imageLock = new ImageIcon("src/images/locked.png");
		imageUnlock = new ImageIcon("src/images/unlocked.png");
	}

	private void configuraJanela() {
		setLayout(new FlowLayout());
		setSize(200, 200);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btlogin){
			btlogin.setIcon(imageUnlock);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == btlogin){
			btlogin.setIcon(imageLock);
		}
	}
}
