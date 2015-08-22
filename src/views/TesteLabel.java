package views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import utilities.Logger;
import utilities.Utilites;

public class TesteLabel {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 500);
		JLabel jLabel = new JLabel();
		Girando girando = new Girando(jLabel, Utilites.br, f);
		girando.start();

		f.setVisible(true);
	}
}

class Girando extends Thread {

	private JFrame frame;
	private JLabel label;
	private double anguloEmRadianos = -10;
	private ImageIcon icon;
	private int x = 10;
	int i = 0;

	public Girando(JLabel label, ImageIcon icon, JFrame frame) {
		this.frame = frame;
		this.label = label;
		this.icon = icon;
	}

	@Override
	public void run() {
		while (true) {
			label = new JLabel(icon) {
				protected void paintComponent(Graphics g) {
					Dimension tamanho = getSize();
					Graphics2D g2d = (Graphics2D) g;

					if (anguloEmRadianos > x) {
						anguloEmRadianos -= Math.toRadians(1);
						x = -10;
					} else {
						anguloEmRadianos += Math.toRadians(1);
						x = 10;
					}
					System.out.println(anguloEmRadianos);
					if(anguloEmRadianos > 30){
						anguloEmRadianos = Math.toRadians(90);
					}

					g2d.rotate(anguloEmRadianos, tamanho.width / 2, tamanho.height / 2);

					super.paintComponent(g2d);
				}
			};

			frame.getContentPane().add(label);

			try {
				Thread.sleep(50);
			} catch (InterruptedException ei) {
				Logger.error(ei, "Erro na espera da thread do relogio");
			}
			frame.repaint();
			frame.revalidate();
		}
	}

}
