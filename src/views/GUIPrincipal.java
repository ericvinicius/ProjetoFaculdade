package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import views.painels.MyPanel;
import views.painels.PainelDebitoAutomatico;
import views.painels.PainelExtrato;
import views.painels.PainelSaque;
import views.painels.PainelTransferencia;

public class GUIPrincipal extends GUIMyFrame {

	private JTabbedPane abas = new JTabbedPane();
	private PainelExtrato painelExtrato;
	private PainelTransferencia painelTransferencia;
	private PainelDebitoAutomatico painelDebitoAutomatico;
	private PainelSaque painelSaque;

	public GUIPrincipal() {
		configuraPagina();
		
		MyPanel.setUser(user);
		MyPanel.setUtilites(utilites);
		
		painelExtrato = new PainelExtrato();
		painelTransferencia = new PainelTransferencia();
		painelDebitoAutomatico = new PainelDebitoAutomatico();
		painelSaque = new PainelSaque();
		
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
	
	@Override
	public void configuraPagina() {
		setSize(500, 500);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
