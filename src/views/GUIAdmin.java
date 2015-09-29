package views;

import idioma.Idioma;

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
		idioma = new Idioma();
		configuraPagina();

		painelRelatorioDeNotas = new PainelRelatorioDeNotas();
		painelRelatorioDeOperacoes = new PainelRelatorioDeOperacoes();
		
		admin = new JLabel(idioma.translate("admin"));
		admin.setHorizontalAlignment(JLabel.CENTER);
		add(admin, BorderLayout.NORTH);
		
		// Adiciona as abas
		abas.addTab(idioma.translate("notas"), painelRelatorioDeNotas);
		abas.addTab(idioma.translate("operacao"), painelRelatorioDeOperacoes);
		add(abas, BorderLayout.CENTER);
	}

	public void configuraPagina() {
		setSize(330, 290);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setVisible(true);

	}

}
