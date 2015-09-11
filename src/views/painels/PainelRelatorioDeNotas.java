package views.painels;

import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PainelRelatorioDeNotas extends JPanel {
	
	public PainelRelatorioDeNotas() {
	}
	
	protected JPanel criaPainelCentral(String titulo) {
		JPanel painel = new JPanel();
		painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
		painel.setBorder(BorderFactory.createTitledBorder(titulo));

		colocaPainelNoCentro(painel);

		return painel;
	}
	
	private void colocaPainelNoCentro(JPanel painel) {
		painel.add(Box.createVerticalGlue());
		painel.add(Box.createHorizontalGlue());
		JPanel centerPanel = new JPanel(new GridBagLayout());
		centerPanel.add(painel);
		add(centerPanel);
	}
		
}
