package views;

import idioma.Idioma;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class GUICodigoDeAcesso extends GUIMyFrame implements MouseListener {

	protected JButton bt12, bt34, bt56, bt78, bt90;
	protected Idioma idioma = new Idioma(GUICodigoDeAcesso.class);

	public GUICodigoDeAcesso() {
		if (user.isNovoCodigoDeAcesso()) {
			JOptionPane.showMessageDialog(this, "Voce nao possui codigo de acesso, por favor cadestre um novo com 3 numeros");
		}
		
		String ou = idioma.translate("ou");
		bt12 = new JButton("1 " + ou + " 2");
		bt34 = new JButton("3 " + ou + " 4");
		bt56 = new JButton("5 " + ou + " 6");
		bt78 = new JButton("7 " + ou + " 8");
		bt90 = new JButton("9 " + ou + " 0");

		adicionaBotoesEmbaralhados();
		configuraPagina();

	}

	@Override
	public void configuraPagina() {
		setLayout(new GridLayout());
		setSize(300, 90);
		setLocationRelativeTo(null);
		setVisible(true);

		if (user.isNovoCodigoDeAcesso()) {
			setTitle("Crie seu Codigo de acesso");
		} else {
			setTitle("Digite o seu Codigo de Acesso");
		}
	}

	protected void adicionaBotoesEmbaralhados() {
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
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		((JButton) e.getSource()).setFont(utilites.fontHover);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		((JButton) e.getSource()).setFont(utilites.fontNormal);
	}

}
