package GUI;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import utils.Utilites;

public class GUILogin extends GUIMyFrame implements MouseListener, KeyListener {

	private String tentativaDeConta;
	private String tentativaDeAgencia;
	private String tentativaDeSenha;

	private JLabel btlogin;

	private ImageIcon imageLock;
	private ImageIcon imageUnlock;

	private JLabel lblconta;
	private JLabel lblagencia;
	private JLabel lblsenha;
	private JFormattedTextField txtconta;
	private JFormattedTextField txtagencia;
	private JPasswordField txtsenha;

	private boolean jaTremeuATelaDeLogin = false;

	public GUILogin() {

		carregaImagens();

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
		btlogin = new JLabel(imageLock);
		btlogin.addMouseListener(this);
		add(btlogin);

		configuraPagina();
	}

	private void configuraPagina() {
		setLayout(new FlowLayout());
		setSize(250, 200);
		setLocationRelativeTo(null);
	}

	private void carregaImagens() {
		imageLock = new ImageIcon("src/images/locked.png");
		imageUnlock = new ImageIcon("src/images/unlocked.png");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == btlogin) {
			try {
				tentativaDeAgencia = txtagencia.getValue().toString();
				tentativaDeConta = txtconta.getValue().toString();
				tentativaDeSenha = txtsenha.getPassword().toString();

				System.out.printf("agencia: %s conta: %s senha: %s",
						tentativaDeAgencia, tentativaDeConta, tentativaDeSenha);
			} catch(Exception e1){
				System.out.println("Usuario deixou os campos em branco na tela de login!");
				
			} finally {
				if (Utilites.loginOk(tentativaDeAgencia, tentativaDeConta, tentativaDeSenha)) {
					new GUICodigoDeAcesso();
				} else {
					if (jaTremeuATelaDeLogin) {
						Utilites.tremeTelaNormal(this);
					} else {
						jaTremeuATelaDeLogin = true;
						Utilites.tremeTelaLogin(this);
					}
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
			btlogin.setIcon(imageUnlock);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btlogin) {
			btlogin.setIcon(imageLock);
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
}
