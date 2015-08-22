package views;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import views.painels.PainelDebitoAutomatico;
import views.painels.PainelExtrato;
import views.painels.PainelSaque;
import views.painels.PainelTransferencia;

public class GUIPrincipal extends GUIMyFrame {

	private JTabbedPane abas = new JTabbedPane();
	private PainelExtrato painelExtrato = new PainelExtrato(user, utilites);
	private PainelTransferencia painelTransferencia = new PainelTransferencia(user, utilites);
	private PainelDebitoAutomatico painelDebitoAutomatico = new PainelDebitoAutomatico(user, utilites);
	private PainelSaque painelSaque = new PainelSaque(user, utilites);

	@Deprecated
	public GUIPrincipal() {
		configuraJanela();
		
		// Nome - data - hora
		JLabel lnome = new JLabel(user.getNome());
		lnome.setHorizontalAlignment(JLabel.CENTER);
		utilites.mostrarHoraNoLabel(lnome);
		getContentPane().add(lnome, BorderLayout.NORTH);

		// Adiciona as abas
		abas.addTab("Extrato", painelExtrato);
		abas.addTab("Transferencia", painelTransferencia);
		abas.addTab("Debito Automatico", painelDebitoAutomatico);
		abas.addTab("Saque", painelSaque);
		getContentPane().add(abas, BorderLayout.CENTER);

	}

	public void configuraJanela() {
		setSize(500, 500);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
