package views;

import idioma.Idioma;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class GUICodigoDeAcesso extends GUIMyFrame implements MouseListener {

	protected JButton bt12, bt34, bt56, bt78, bt90;

	public GUICodigoDeAcesso() {
		if (user.isNovoCodigoDeAcesso()) {
			JOptionPane.showMessageDialog(this, idioma.translatePopUp("novoCodigo"));
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
		idioma = new Idioma();
		setLayout(new GridLayout());
		setSize(300, 90);
		setLocationRelativeTo(null);
		setVisible(true);

		if (user.isNovoCodigoDeAcesso()) {
			setTitle(idioma.getTitle("novoCodigo"));
		} else {
			System.out.println(idioma);
			setTitle(idioma.getTitle("comCodigo"));
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
