package controllers;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import modelos.Cliente;
import modelos.ValidadorDeClientes;
import utilities.Utilites;
import views.GUICodigoDeAcesso;
import views.GUIPrincipal;
import builders.ClienteBuilder;

public class CodigoDeAcessoController extends GUICodigoDeAcesso {
	
	private int contadorDeClicks = 0;
	private int[] codigo = new int[Utilites.TAMANHO_CODIGO_DE_ACESSO];
	private int tentativa = 0;
	
	public CodigoDeAcessoController() {
		super();
		bt12.addMouseListener(this);
		bt34.addMouseListener(this);
		bt56.addMouseListener(this);
		bt78.addMouseListener(this);
		bt90.addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == bt12) {
			codigo[contadorDeClicks] = 12;
		} else if (e.getSource() == bt34) {
			codigo[contadorDeClicks] = 34;
		} else if (e.getSource() == bt56) {
			codigo[contadorDeClicks] = 56;
		} else if (e.getSource() == bt78) {
			codigo[contadorDeClicks] = 78;
		} else if (e.getSource() == bt90) {
			codigo[contadorDeClicks] = 90;
		}
		super.adicionaBotoesEmbaralhados();
		contadorDeClicks++;
		if (contadorDeClicks == Utilites.TAMANHO_CODIGO_DE_ACESSO) {
			verificaCodigo();
		}
	}
	
	private void verificaCodigo() {
		ValidadorDeClientes validador = new ValidadorDeClientes();
		Cliente usuarioTentativa = new ClienteBuilder().comCodigoDeAcesso(codigo).constroi();
		
		if (user.isNovoCodigoDeAcesso()) {
			criaCodiggoDeAcesso();
			redirect(this, GUIPrincipal.class);

		} else if (validador.possuemCodigoDeAcessoIguais(user, usuarioTentativa)) {
			redirect(this, GUIPrincipal.class);
			
		} else if(tentativa >= Utilites.MAXIMO_DE_TENTATIVAS_PARA_CODIGO_DE_ACESSO){
			JOptionPane.showMessageDialog(this, "Conta Bloqueada", "Maximo de tentativas atingido", JOptionPane.ERROR_MESSAGE);
			user.setStatus(1);
		}
		
		tentativa++;
		contadorDeClicks = 0;
		utilites.tremeTela(this);
	}

	private void criaCodiggoDeAcesso() {
		user.setCodigoDeAcesso(codigo);
		JOptionPane.showMessageDialog(this, utilites.converteCodigoDeAcessoParaString(codigo));
		fileHandler.cadastraNovoCodigoDeAcessoParaUsuario(user);
		user.setNovoCodigoDeAcesso(false);
	}
}
