package views;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import views.painels.PainelRelatorioDeNotas;
import views.painels.PainelRelatorioDeOperacoes;

public class GUIAdmin extends GUIMyFrame {
	
	private JTabbedPane abas = new JTabbedPane();
	private PainelRelatorioDeNotas painelRelatorioDeNotas;
	private PainelRelatorioDeOperacoes painelRelatorioDeOperacoes;
	
	private JLabel admin;

	public GUIAdmin() {
		configuraPagina();

		painelRelatorioDeNotas = new PainelRelatorioDeNotas();
		painelRelatorioDeOperacoes = new PainelRelatorioDeOperacoes();
		
		admin = new JLabel("ADMINISTRADOR");
		admin.setHorizontalAlignment(JLabel.CENTER);
		add(admin, BorderLayout.NORTH);
		
		// Adiciona as abas
		abas.addTab("Relatorio de Notas", painelRelatorioDeNotas);
		abas.addTab("Relatorio de Operacoes", painelRelatorioDeOperacoes);
		add(abas, BorderLayout.CENTER);
	}

	public void configuraPagina() {
		setSize(332, 288);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setVisible(true);

	}

}
