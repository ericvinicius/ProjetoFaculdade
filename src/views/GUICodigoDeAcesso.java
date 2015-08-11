package views;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelos.Cliente;
import modelos.ValidadorDeClientes;

import org.jdesktop.swingx.JXButton;

import utilities.Utilites;

public class GUICodigoDeAcesso extends GUIMyFrame implements MouseListener{

	private JXButton bt12, bt34, bt56, bt78, bt90;
	
	private int contadorDeClicks = 0;
	private int[] codigo = new int[Utilites.TAMANHO_CODIGO_DE_ACESSO];
	private int tentativa = 0;

	public GUICodigoDeAcesso() {
		if(user.isNovoCodigoDeAcesso()){
			JOptionPane.showMessageDialog(this, "Voce nao possui codigo de acesso, por favor cadestre um novo com 3 numeros");
		}
		
		bt12 = new JXButton("1 ou 2");
		bt12.addMouseListener(this);

		bt34 = new JXButton("3 ou 4");
		bt34.addMouseListener(this);

		bt56 = new JXButton("5 ou 6");
		bt56.addMouseListener(this);

		bt78 = new JXButton("7 ou 8");
		bt78.addMouseListener(this);

		bt90 = new JXButton("9 ou 0");
		bt90.addMouseListener(this);

		atualizaBotoes();
		configuraJanela();

	}
	
	public void configuraJanela() {
		setLayout(new GridLayout());
		setSize(300, 90);
		setLocationRelativeTo(null);
		setVisible(true);
		
		if(user.isNovoCodigoDeAcesso()){
			setTitle("Crie seu Codigo de acesso");
		} else {
			setTitle("Digite o seu Codigo de Acesso");
		}
	}

	private void atualizaBotoes() {
		remove(bt12);
		remove(bt34);
		remove(bt56);
		remove(bt78);
		remove(bt90);
		revalidate();

		int[] ordemDosBotoes = utilites.criaVetorComOrdemAleatoriaComQuatroPosicoes();
		for (int i = 0; i < ordemDosBotoes.length; i++) {
			switch (ordemDosBotoes[i]) {
			case 0:
				bt12.setFont(utilites.fontNormal);
				add(bt12);
				break;
			case 1:
				bt34.setFont(utilites.fontNormal);
				add(bt34);
				break;
			case 2:
				bt56.setFont(utilites.fontNormal);
				add(bt56);
				break;
			case 3:
				bt78.setFont(utilites.fontNormal);
				add(bt78);
				break;
			case 4:
				bt90.setFont(utilites.fontNormal);
				add(bt90);
				break;
			}
		}
		revalidate();
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
		atualizaBotoes();
		contadorDeClicks++;
		
		if (contadorDeClicks == Utilites.TAMANHO_CODIGO_DE_ACESSO) {
			verificaCodigo();
		}
	}
	
	private void verificaCodigo() {
		Cliente usuarioTentativa = new Cliente();
		ValidadorDeClientes validador = new ValidadorDeClientes();
		usuarioTentativa.setCodigoDeAcesso(codigo);
		
		if (user.isNovoCodigoDeAcesso()) {
			criaCodiggoDeAcesso();
			redirect(this, "principal");

		} else if (validador.validaCodigoDeAcesso(user, usuarioTentativa)) {
			redirect(this, "principal");
			
		} else if(tentativa >= Utilites.MAXIMO_DE_TENTATIVAS_PARA_CODIGO_DE_ACESSO){
			JOptionPane.showMessageDialog(this, "Conta Bloqueada", "Maximo de tentativas atingido", JOptionPane.ERROR_MESSAGE);
			//TODO: Verificar se eh necessario bloquear conta
		}
		tentativa++;
		contadorDeClicks = 0;
		utilites.tremeTela(this);
	}

	private void criaCodiggoDeAcesso() {
		user.setCodigoDeAcesso(codigo);
		JOptionPane.showMessageDialog(this, utilites.converteVetorParaString(codigo));
		fileHandler.cadastraNovoCodigoDeAcessoParaUsuario(user);
		user.setNovoCodigoDeAcesso(false);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		((JButton) e.getSource()).setFont(utilites.fontHover);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		((JButton) e.getSource()).setFont(utilites.fontNormal);
	}
	
}
