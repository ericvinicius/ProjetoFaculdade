package views.painels;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelos.Caixa;

public class PainelRelatorioDeNotas extends JPanel {
	
	public PainelRelatorioDeNotas() {
		setLayout(new BorderLayout());
		
		JPanel painelCentral = criaPainelCentral("Quantidade de Notas");
		painelCentral.setLayout(new BorderLayout());
		painelCentral.setSize(300, 280);
		
		JLabel lblnota10 = new JLabel(Caixa.getDadosNotas10());
		lblnota10.setHorizontalAlignment(JLabel.CENTER);
		painelCentral.add(lblnota10, BorderLayout.NORTH);
		
		JLabel lblnota20 = new JLabel(Caixa.getDadosNotas20());
		lblnota20.setHorizontalAlignment(JLabel.CENTER);
		painelCentral.add(lblnota20, BorderLayout.CENTER);
		
		JLabel lblnota50 = new JLabel(Caixa.getDadosNotas50());
		lblnota50.setHorizontalAlignment(JLabel.CENTER);
		painelCentral.add(lblnota50, BorderLayout.SOUTH);
		
		add(painelCentral, BorderLayout.CENTER);
		
		JButton btImprimir = new JButton("Imprimir");
		add(btImprimir, BorderLayout.SOUTH);
		
	}
	
	private JPanel criaPainelCentral(String titulo) {
		JPanel painel = new JPanel();
		painel.setBorder(BorderFactory.createTitledBorder(titulo));
		return painel;
	}
	
}
