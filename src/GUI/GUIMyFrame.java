package GUI;

import javax.swing.JFrame;

public class GUIMyFrame extends JFrame {

	public GUIMyFrame() {
		configuraTodasAsJanelas();

	}

	private void configuraTodasAsJanelas() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// TODO: Trocar para false no fim do projeto
		setResizable(true);
	}
}
