package GUI;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUILogin extends GUIMyFrame implements MouseListener{

	private int conta;
	private int tentativaDeAgencia;
	private int senha;
	
	private JLabel btlogin;

	
	private ImageIcon imageLock;
	private ImageIcon imageUnlock;
	
	private JLabel lblconta;
	private JLabel lblagencia;
	private JLabel lblsenha;
	private JTextField txtconta;
	private JTextField txtagencia;
	private JPasswordField txtsenha;
	
	public GUILogin() {
		configuraJanela();
		carregaImagens();
		
		//Conta
		lblconta = new JLabel("Conta   ");
		getContentPane().add(lblconta);
		
		txtconta = new JTextField();
		txtconta.setColumns(12);
		getContentPane().add(txtconta);
		
		//Agencia
		lblagencia = new JLabel("Agencia");
		getContentPane().add(lblagencia);
		
		txtagencia = new JTextField();
		txtagencia.setColumns(12);
		getContentPane().add(txtagencia);
		
		//Senha
		lblsenha = new JLabel("Senha    ");
		getContentPane().add(lblsenha);
		
		txtsenha = new JPasswordField();
		txtsenha.setColumns(12);
		getContentPane().add(txtsenha);
		
		//botao login
		btlogin = new JLabel(imageLock);
		btlogin.addMouseListener(this);
		getContentPane().add(btlogin);
	}

	private void carregaImagens() {
		imageLock = new ImageIcon("src/images/locked.png");
		imageUnlock = new ImageIcon("src/images/unlocked.png");
	}

	private void configuraJanela() {
		getContentPane().setLayout(new FlowLayout());
		setSize(250, 200);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == btlogin){
			tentativaDeAgencia = Integer.parseInt(txtagencia.getText().toString());
		}
		
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
