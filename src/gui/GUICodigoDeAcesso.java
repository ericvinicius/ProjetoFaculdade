package gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import objects.UsuarioTentativa;
import utils.Utilites;

public class GUICodigoDeAcesso extends GUIMyFrame implements MouseListener {

	private int[] codigo = new int[Utilites.TAMANHO_CODIGO_DE_ACESSO];
	private int contadorDeClicks = -1;
	private int tentativa = 0;

	private JButton bt12, bt34, bt56, bt78, bt90;

	private Font normal = new Font("Arial", Font.PLAIN, 12);
	private Font nova = new Font("Arial", Font.BOLD, 15);

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

	private void configuraJanela() {
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

		int[] ordemDosBotoes = randomizaOrdem();
		for (int i = 0; i < ordemDosBotoes.length; i++) {
			switch (ordemDosBotoes[i]) {
			case 0:
				bt12.setFont(normal);
				add(bt12);
				break;
			case 1:
				bt34.setFont(normal);
				add(bt34);
				break;
			case 2:
				bt56.setFont(normal);
				add(bt56);
				break;
			case 3:
				bt78.setFont(normal);
				add(bt78);
				break;
			case 4:
				bt90.setFont(normal);
				add(bt90);
				break;
			}
		}
		revalidate();
		contadorDeClicks++;

	}

	private int[] randomizaOrdem() {
		int[] ordemDosBotoes = { 0, 1, 2, 3, 4 };

		for (int i = 0; i < ordemDosBotoes.length; i++) {
			int posicaoAleatoria = (int) (Math.random() * 4);

			int aux = ordemDosBotoes[i];
			ordemDosBotoes[i] = ordemDosBotoes[posicaoAleatoria];
			ordemDosBotoes[posicaoAleatoria] = aux;
		}
		return ordemDosBotoes;
	}

	public int[] getCodigo() {
		return codigo;
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
		adicionaBotoes();
		if (contadorDeClicks == Utilites.TAMANHO_CODIGO_DE_ACESSO) {
			UsuarioTentativa.setCodigoDeAcesso(codigo);
			
			System.out.println("[Tentativa] codigo{"
					+ UsuarioTentativa.getCodigoDeAcesso().toString() + "}\n");
			
			if (Utilites.codigoDeAcessoOk()) {
				dispose();
				JOptionPane.showMessageDialog(this, "Logado com sucesso!");
				//TODO:Falta criar a tela principal do sistema
			
			} else if(tentativa >= 3){ 
				dispose();
				Utilites.travaUsuario();
			} else {
				Utilites.tremeTelaNormal(this);
				contadorDeClicks = 0;
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
		((JButton) e.getSource()).setFont(nova);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		((JButton) e.getSource()).setFont(normal);
	}

}
