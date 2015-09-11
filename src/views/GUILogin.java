package views;

import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import modelos.Cliente;
import utilities.Logger;
import utilities.Utilites;
import builders.ClienteBuilder;

public class GUILogin extends GUIMyFrame implements MouseListener, KeyListener {

	private JLabel btlogin;
	private JLabel lblconta;
	private JLabel lblagencia;
	private JLabel lblsenha;

	private JFormattedTextField txtconta;
	private JFormattedTextField txtagencia;
	private JPasswordField txtsenha;

	private Cliente usuarioTentativa;

	public GUILogin() {
		// Conta
		lblconta = new JLabel("Conta   ");
		add(lblconta);

		txtconta = new JFormattedTextField(
				utilites.criadorDeMascara(utilites.maskConta, true));
		txtconta.setSelectionStart(0);
		txtconta.setColumns(12);
		txtconta.addKeyListener(this);
		add(txtconta);

		// Agencia
		lblagencia = new JLabel("Agencia");
		add(lblagencia);

		txtagencia = new JFormattedTextField(
				utilites.criadorDeMascara(utilites.maskAgencia, true));
		txtagencia.setSelectionStart(0);
		txtagencia.setColumns(12);
		txtagencia.addKeyListener(this);
		add(txtagencia);

		// Senha
		lblsenha = new JLabel("Senha    ");
		add(lblsenha);

		txtsenha = new JPasswordField();
		txtsenha.setColumns(12);
		txtsenha.addKeyListener(new KeyAdapter() {
		      public void keyPressed(KeyEvent evt) {
		          int key = evt.getKeyCode();
		          if (key == KeyEvent.VK_ENTER){
		        	  pegaInformacoesEVerificaLogin();
		          }
		      }
		});
		add(txtsenha);

		// botao login
		btlogin = new JLabel(Utilites.imageLock);
		btlogin.addMouseListener(this);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		pegaInformacoesEVerificaLogin();
	}

	private void pegaInformacoesEVerificaLogin() {
		try{
			pegaInformacoesDeLogin();
			if (usuarioTentativa.verificaAdmin()) {
				redirect(this, GUIAdmin.class);
			} else {
				verificaLogin();
			}
		} catch (NullPointerException en){
			Logger.warn("Em Branco", "Algum campo esta em branco!");
			utilites.tremeTelaComMensagemDeErro(this);
		}
		
	}

	private void verificaLogin() {
		user = fileHandler.fazLeituraDoArquivoParaLogin(usuarioTentativa);
		if (user != null) {
			super.redirect(this, GUICodigoDeAcesso.class);
		} else {
			utilites.tremeTelaComMensagemDeErro(this);
		}
	}

	public void pegaInformacoesDeLogin() {
		String agencia = txtagencia.getValue().toString();
		String conta = txtconta.getValue().toString();
		String senha = new String(txtsenha.getPassword());
		usuarioTentativa = new ClienteBuilder().comAgencia(agencia).comConta(conta).comSenha(senha).constroi();
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
		Object campo = e.getSource();
		char letra = e.getKeyChar();
		if(campo.equals(txtconta) || campo.equals(txtagencia)){
			if (letra > 'a' && letra < 'Z') {
				e.consume();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

}
