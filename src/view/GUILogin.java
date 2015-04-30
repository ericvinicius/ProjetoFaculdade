package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import controller.LoginController;
import controller.Utilites;

public class GUILogin extends GUIMyFrame implements MouseListener, KeyListener,
		ActionListener {

	private JLabel btlogin;
	private JLabel lblconta;
	private JLabel lblagencia;
	private JLabel lblsenha;

	public static JFormattedTextField txtconta;
	public static JFormattedTextField txtagencia;
	public static JPasswordField txtsenha;

	public GUILogin() {
		
		// Conta
		lblconta = new JLabel("Conta   ");
		add(lblconta);

		txtconta = new JFormattedTextField(Utilites.criadorDeMascara("conta"));
		txtconta.setSelectionStart(0);
		txtconta.setColumns(12);
		txtconta.addKeyListener(this);
		add(txtconta);

		// Agencia
		lblagencia = new JLabel("Agencia");
		add(lblagencia);

		txtagencia = new JFormattedTextField(
				Utilites.criadorDeMascara("agencia"));
		txtagencia.setSelectionStart(0);
		txtagencia.setColumns(12);
		txtagencia.addKeyListener(this);
		add(txtagencia);

		// Senha
		lblsenha = new JLabel("Senha    ");
		add(lblsenha);

		txtsenha = new JPasswordField();
		txtsenha.setColumns(12);
		add(txtsenha);

		// botao login
		btlogin = new JLabel(Utilites.imageLock);
		btlogin.addMouseListener(this);
		add(btlogin);

		opcaoAdmin.addActionListener(this);

		configuraPagina();
	}

	private void configuraPagina() {
		LoginController.setFrameLogin(this);
		setLayout(new FlowLayout());
		setSize(250, 200);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == btlogin) {

			boolean emBranco = LoginController.armazenaLogin();
			
			if (!emBranco) {
				if (LoginController.verificaAdmin()) {
					System.out.println("Admin tentando entrar no sistema");
					opcaoAdmin.setText("Quero ir para Braavos!");
					opcoes.add(opcaoAdmin);
				} else {
					LoginController.clickLogin();
				}
			}
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
		if (e.getSource() == btlogin) {
			btlogin.setIcon(Utilites.imageUnlock);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btlogin) {
			btlogin.setIcon(Utilites.imageLock);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Se for uma letra
		if (e.getKeyChar() > 'a' && e.getKeyChar() < 'Z') {
			// delete
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Admin vai entrar com a senha!");
		String passe = JOptionPane.showInputDialog(this,
				"Quem é voce? para ir para Braavos.");

		if (passe.equals("got")) {
			JOptionPane.showMessageDialog(this, "Valar Dohaeris");
			// TODO: Criar tela de Administrador
		}

	}
}
