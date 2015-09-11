package views;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class GUIAdmin extends GUIMyFrame {
	
	private JTabbedPane abas = new JTabbedPane();
	private PainelRelatorioDeNotas painelRelatorioDeNotas;
	private PainelRelatorioDeOperacoes painelRelatorioDeOperacoes;

	public GUIAdmin() {
		configuraPagina();

		painelRelatorioDeNotas = new PainelRelatorioDeNotas();
		painelRelatorioDeOperacoes = new PainelRelatorioDeOperacoes();

		// Nome - data - hora
		JLabel lnome = new JLabel(user.getNome());
		lnome.setHorizontalAlignment(JLabel.CENTER);
		utilites.mostrarHoraNoLabel(lnome);
		getContentPane().add(lnome, BorderLayout.NORTH);

		// Adiciona as abas
		abas.addTab("Relatorio de Notas", painelRelatorioDeNotas);
		abas.addTab("Relatorio de Operacoes", painelRelatorioDeOperacoes);
		getContentPane().add(abas, BorderLayout.CENTER);
	}

	@Override
	public void configuraPagina() {
		setSize(500, 500);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setVisible(true);

	}

}
