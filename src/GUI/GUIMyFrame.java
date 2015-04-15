package GUI;

import java.text.Format;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.text.MaskFormatter;

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

	public void tremeTela() {

	}

	public MaskFormatter criadorDeMascara(String paraOnde) {
		MaskFormatter mascara = new MaskFormatter();
		mascara.setPlaceholderCharacter('_');
		
		try {
			if (paraOnde.equals("conta")) {
				mascara.setMask("##.###-#");

			} else if (paraOnde.equals("agencia")) {
				mascara.setMask("####-#");
			}
		} catch (Exception e) {
			System.out.println("Erro no Formatador - Classe GUIMyFrame");
		}
		return mascara;

	}
}
