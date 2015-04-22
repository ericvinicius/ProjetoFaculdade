package view;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import controller.CodigoDeAcessoController;
import controller.Utilites;

public class GUICodigoDeAcesso extends GUIMyFrame implements MouseListener{

	private JButton bt12, bt34, bt56, bt78, bt90;

	public GUICodigoDeAcesso() {

		bt12 = new JButton("1 ou 2");
		bt12.addMouseListener(this);

		bt34 = new JButton("3 ou 4");
		bt34.addMouseListener(this);

		bt56 = new JButton("5 ou 6");
		bt56.addMouseListener(this);

		bt78 = new JButton("7 ou 8");
		bt78.addMouseListener(this);

		bt90 = new JButton("9 ou 0");
		bt90.addMouseListener(this);

		adicionaBotoes();
		configuraJanela();

	}
	
	public void configuraJanela() {
		setLayout(new GridLayout());
		setSize(300, 90);
		setLocationRelativeTo(null);
	}

	private void adicionaBotoes() {
		remove(bt12);
		remove(bt34);
		remove(bt56);
		remove(bt78);
		remove(bt90);
		revalidate();

		int[] ordemDosBotoes = CodigoDeAcessoController.randomizaOrdemBotoes();
		for (int i = 0; i < ordemDosBotoes.length; i++) {
			switch (ordemDosBotoes[i]) {
			case 0:
				bt12.setFont(Utilites.fontNormal);
				add(bt12);
				break;
			case 1:
				bt34.setFont(Utilites.fontNormal);
				add(bt34);
				break;
			case 2:
				bt56.setFont(Utilites.fontNormal);
				add(bt56);
				break;
			case 3:
				bt78.setFont(Utilites.fontNormal);
				add(bt78);
				break;
			case 4:
				bt90.setFont(Utilites.fontNormal);
				add(bt90);
				break;
			}
		}
		revalidate();
		CodigoDeAcessoController.contadorDeClicks++;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == bt12) {
			CodigoDeAcessoController.codigo[CodigoDeAcessoController.contadorDeClicks] = 12;
		} else if (e.getSource() == bt34) {
			CodigoDeAcessoController.codigo[CodigoDeAcessoController.contadorDeClicks] = 34;
		} else if (e.getSource() == bt56) {
			CodigoDeAcessoController.codigo[CodigoDeAcessoController.contadorDeClicks] = 56;
		} else if (e.getSource() == bt78) {
			CodigoDeAcessoController.codigo[CodigoDeAcessoController.contadorDeClicks] = 78;
		} else if (e.getSource() == bt90) {
			CodigoDeAcessoController.codigo[CodigoDeAcessoController.contadorDeClicks] = 90;
		}
		
		adicionaBotoes();
		
		if (CodigoDeAcessoController.contadorDeClicks == CodigoDeAcessoController.TAMANHO_CODIGO_DE_ACESSO) {
			CodigoDeAcessoController.verificaCodigo(this);
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
		((JButton) e.getSource()).setFont(Utilites.fontHover);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		((JButton) e.getSource()).setFont(Utilites.fontNormal);
	}

}
