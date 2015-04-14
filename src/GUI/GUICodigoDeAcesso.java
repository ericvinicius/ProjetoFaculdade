package GUI;

import java.awt.Event;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class GUICodigoDeAcesso extends GUIMyFrame implements MouseListener {

	private int[] codigo;
	private int contadorDeClicks = 0;
	
	private JButton bt12, bt34, bt56, bt78, bt90;

	public GUICodigoDeAcesso() {
		
		configuraJanela();

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

	}

	private void configuraJanela() {
		setLayout(new GridLayout());
		setSize(300, 90);
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
				add(bt12);
				break;
				
			case 1:
				add(bt34);
				break;
				
			case 2:
				add(bt56);
				break;
				
			case 3:
				add(bt78);
				break;
				
			case 4:
				add(bt90);
				break;

			}
		}
		revalidate();

	}

	private int[] randomizaOrdem() {
		int[] ordemDosBotoes = { 0, 1, 2, 3, 4 };
		
		for (int i = 0; i < ordemDosBotoes.length; i++) {
			int posicaoAleatoria = (int) (Math.random() * (4 - 0) + 0);

			int aux = ordemDosBotoes[i];
			ordemDosBotoes[i] = ordemDosBotoes[posicaoAleatoria];
			ordemDosBotoes[posicaoAleatoria] = aux;
		}
		
		return ordemDosBotoes;
	}

	public int[] getCodigo() {
		return codigo;
	}

	public void setCodigo(int[] codigo) {
		this.codigo = codigo;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == bt12){
			adicionaBotoes();
			contadorDeClicks++;
			
		} else if(e.getSource() == bt34){
			adicionaBotoes();
			contadorDeClicks++;
			
		} else if(e.getSource() == bt56){
			adicionaBotoes();
			contadorDeClicks++;
			
		} else if(e.getSource() == bt78){
			adicionaBotoes();
			contadorDeClicks++;
			
		} else if(e.getSource() == bt90){
			adicionaBotoes();
			contadorDeClicks++;
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
