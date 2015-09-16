package views;

import java.awt.FlowLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import utilities.Utilites;

public class GUILogin extends GUIMyFrame {

	protected JLabel btlogin;
	
	private JLabel lblconta;
	private JLabel lblagencia;
	private JLabel lblsenha;

	protected JFormattedTextField txtconta;
	protected JFormattedTextField txtagencia;
	protected JPasswordField txtsenha;

	public GUILogin() {
		// Conta
		lblconta = new JLabel("Conta   ");
		add(lblconta);

		txtconta = new JFormattedTextField(utilites.criadorDeMascara(utilites.maskConta, true));
		txtconta.setSelectionStart(0);
		txtconta.setColumns(12);
		add(txtconta);

		// Agencia
		lblagencia = new JLabel("Agencia");
		add(lblagencia);

		txtagencia = new JFormattedTextField(utilites.criadorDeMascara(utilites.maskAgencia, true));
		txtagencia.setSelectionStart(0);
		txtagencia.setColumns(12);
		add(txtagencia);

		// Senha
		lblsenha = new JLabel("Senha    ");
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
		setLayout(new FlowLayout());
		setSize(250, 200);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	

}
