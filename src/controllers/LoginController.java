package controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import modelos.Cliente;
import modelos.ValidadorDeClientes;
import utilities.Logger;
import views.GUIAdmin;
import views.GUILogin;
import builders.ClienteBuilder;

public class LoginController extends GUILogin implements KeyListener {
	
	private Cliente usuarioTentativa;
	private ValidadorDeClientes validador = new ValidadorDeClientes();
	
	public LoginController(){
		super();
		btlogin.addMouseListener(this);
		
		txtconta.addKeyListener(this);
		txtagencia.addKeyListener(this);
		
		txtsenha.addKeyListener(new KeyAdapter() {
		      public void keyPressed(KeyEvent evt) {
		          int key = evt.getKeyCode();
		          if (key == KeyEvent.VK_ENTER){
		        	  fazLogin();
		          }
		      }
		});
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		fazLogin();
	}

	private void fazLogin() {
		try{
			pegaInformacoesDeLogin();
			if (validador.possuiDadosDeAdmin(usuarioTentativa)) {
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
			super.redirect(this, CodigoDeAcessoController.class);
		} else {
			utilites.tremeTelaComMensagemDeErro(this);
		}
	}

	private void pegaInformacoesDeLogin() {
		String agencia = txtagencia.getValue().toString();
		String conta = txtconta.getValue().toString();
		String senha = new String(txtsenha.getPassword());
		usuarioTentativa = new ClienteBuilder().comAgencia(agencia).comConta(conta).comSenha(senha).constroi();
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
