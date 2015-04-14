package GUI;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUICodigoDeAcesso extends GUIMyFrame {
	
	private int codigo;
	private JButton bt12, bt34, bt56, bt78, bt90;
	
	private int[] ordemDosBotoes = {0, 1, 2, 3, 4};
	
	public GUICodigoDeAcesso(){
		setLayout(new FlowLayout());
			
		bt12 = new JButton("1 ou 2");
		bt34 = new JButton("3 ou 4");
		bt56 = new JButton("5 ou 6");
		bt78 = new JButton("7 ou 8");
		bt90 = new JButton("9 ou 0");
		
		adcionaBotoes();
		
		
	}

	private void adcionaBotoes() {
		randomizaOrdem();
		for(int i = 0; i < ordemDosBotoes.length; i++){
			switch(ordemDosBotoes[i]){
			case 0:
				add(bt12);
			}
		}
		
	}

	private void randomizaOrdem() {
		for(int i = 0; i < ordemDosBotoes.length; i++){
			int posicaoAleatoria = (int) (Math.random() * (4 - 0) + 0);
			
			int aux = ordemDosBotoes[i];
			ordemDosBotoes[i] = ordemDosBotoes[posicaoAleatoria];
			ordemDosBotoes[posicaoAleatoria] = aux;
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
