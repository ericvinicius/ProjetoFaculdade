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
import javax.swing.JPasswordField;

import model.Usuario;
import textFile.ManipuladorDeArquivos;
import utilities.Utilites;

public class GUILogin extends GUIMyFrame implements MouseListener, KeyListener,
		ActionListener {

	private JLabel btlogin;
	private JLabel lblconta;
	private JLabel lblagencia;
	private JLabel lblsenha;

	public JFormattedTextField txtconta;
	public JFormattedTextField txtagencia;
	public JPasswordField txtsenha;
	
	private Usuario usuarioTentativa = new Usuario();
	private Utilites utilites;

	public GUILogin() {
		utilites = new Utilites();
		
		// Conta
		lblconta = new JLabel("Conta   ");
		add(lblconta);

		txtconta = new JFormattedTextField(
				Utilites.criadorDeMascara(utilites.maskConta));
		txtconta.setSelectionStart(0);
		txtconta.setColumns(12);
		txtconta.addKeyListener(this);
		add(txtconta);

		// Agencia
		lblagencia = new JLabel("Agencia");
		add(lblagencia);

		txtagencia = new JFormattedTextField(
				Utilites.criadorDeMascara(utilites.maskAgencia));
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
		btlogin = new JLabel(utilites.imageLock);
		btlogin.addMouseListener(this);
		add(btlogin);

		//opcaoAdmin.addActionListener(this);

		configuraPagina();
	}

	private void configuraPagina() {
		setLayout(new FlowLayout());
		setSize(250, 200);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		pegaInformacoesDeLogin();
		if (usuarioTentativa.isAdmin()) {
			//TODO: Usuario Admin
		} else {
			verificaLogin();
			
		}
	}
	
	private void verificaLogin() {
		ManipuladorDeArquivos leitor = new ManipuladorDeArquivos();
		user = leitor.fazLeituraDoArquivoParaLogin(usuarioTentativa);
		if(user != null){
			super.redirect(this, "codigoDeAcesso");
		} else {
			utilites.tremeTelaComMensagemDeErro(this);
		}
	}

	public void pegaInformacoesDeLogin(){
		try{
			String agencia = txtagencia.getValue().toString();
			String conta = txtconta.getValue().toString();
			String senha = new String(txtsenha.getPassword());
			usuarioTentativa.guardaInformacoes(agencia, conta, senha);
			
		} catch (NullPointerException e){
			utilites.tremeTelaComMensagemDeErro(this);
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
			btlogin.setIcon(utilites.imageUnlock);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btlogin) {
			btlogin.setIcon(utilites.imageLock);
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
		//TODO: Criar Tela do Admin
	}
}
