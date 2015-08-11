package views;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import modelos.Cliente;

public class GUILogin extends GUIMyFrame implements MouseListener, KeyListener,
		ActionListener {

	private JLabel btlogin;
	private JLabel lblconta;
	private JLabel lblagencia;
	private JLabel lblsenha;

	private JFormattedTextField txtconta;
	private JFormattedTextField txtagencia;
	private JPasswordField txtsenha;

	private Cliente usuarioTentativa = new Cliente();

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
		btlogin = new JLabel(utilites.imageLock);
		btlogin.addMouseListener(this);
		add(btlogin);

		opcaoAdmin.addActionListener(this);
		
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
		pegaInformacoesEVerificaLogin();
	}

	private void pegaInformacoesEVerificaLogin() {
		try{
			pegaInformacoesDeLogin();
			if (usuarioTentativa.isAdmin()) {
				opcaoAdmin.setText("Quero ir para Braavos!");
				opcoes.add(opcaoAdmin);
			} else {
				verificaLogin();

			}
		} catch (NullPointerException en){
			utilites.logger.logWarn("Em Branco", "Algum campo esta em branco!");
			utilites.tremeTelaComMensagemDeErro(this);
		}
		
	}

	private void verificaLogin() {
		user = fileHandler.fazLeituraDoArquivoParaLogin(usuarioTentativa);
		if (user != null) {
			super.redirect(this, "codigoDeAcesso");
		} else {
			utilites.tremeTelaComMensagemDeErro(this);
		}
	}

	public void pegaInformacoesDeLogin() {
		String agencia = txtagencia.getValue().toString();
		String conta = txtconta.getValue().toString();
		String senha = new String(txtsenha.getPassword());
		usuarioTentativa.guardaInformacoes(agencia, conta, senha);
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
		Object campo = e.getSource();
		char letra = e.getKeyChar();
		if(campo.equals(txtconta) || campo.equals(txtagencia)){
			if (letra > 'a' && letra < 'Z') {
				e.consume();
			}
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
		String passe = JOptionPane.showInputDialog(this,
				"Quem é voce? para ir para Braavos.");

		if (passe.equals("got")) {
			JOptionPane.showMessageDialog(this, "Valar Dohaeris");
			// TODO: Criar tela de Administrador
		}
	}
}
