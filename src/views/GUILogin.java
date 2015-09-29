package views;

import idioma.Idioma;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import utilities.Utilites;

public class GUILogin extends GUIMyFrame implements MouseListener {

	protected JLabel btlogin;
	
	private JLabel lblconta;
	private JLabel lblagencia;
	private JLabel lblsenha;

	protected JFormattedTextField txtconta;
	protected JFormattedTextField txtagencia;
	protected JPasswordField txtsenha;
	
	public GUILogin() {
		// Conta
		lblconta = new JLabel(idioma.translate("conta"));
		add(lblconta);

		txtconta = new JFormattedTextField(utilites.criadorDeMascara(utilites.maskConta, true));
		txtconta.setSelectionStart(0);
		txtconta.setColumns(12);
		add(txtconta);

		// Agencia
		lblagencia = new JLabel(idioma.translate("agencia"));
		add(lblagencia);

		txtagencia = new JFormattedTextField(utilites.criadorDeMascara(utilites.maskAgencia, true));
		txtagencia.setSelectionStart(0);
		txtagencia.setColumns(12);
		add(txtagencia);

		// Senha
		lblsenha = new JLabel(idioma.translate("senha"));
		add(lblsenha);

		txtsenha = new JPasswordField();
		txtsenha.setColumns(12);
		add(txtsenha);

		// botao login
		btlogin = new JLabel(Utilites.imageLock);
		add(btlogin);

		configuraPagina();
	}

	@Override
	public void configuraPagina() {
		idioma = new Idioma();
		setLayout(new FlowLayout());
		setSize(260, 200);
		setLocationRelativeTo(null);
		setVisible(true);
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
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
	

}
