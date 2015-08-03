package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.math.BigDecimal;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import view.painel.PainelDebitoAutomatico;
import view.painel.PainelExtrato;
import view.painel.PainelSaque;
import view.painel.PainelTransferencia;

public class GUIPrincipal extends GUIMyFrame {

	private JTabbedPane abas = new JTabbedPane();
	private PainelExtrato painelExtrato = new PainelExtrato();
	private PainelTransferencia painelTransferencia = new PainelTransferencia();
	private PainelDebitoAutomatico painelDebitoAutomatico = new PainelDebitoAutomatico();
	private PainelSaque painelSaque = new PainelSaque();
	

	public GUIPrincipal() {
		configuraJanela();
		criaPaineis();
		
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

	private void criaPaineis() {
		adicionaComponetesPadroesParaTodasOsPaineis();
		painelExtrato.constroiTela(user.getExtrato());
		painelTransferencia.controiTela();
		painelDebitoAutomatico.constroiTela();
		painelSaque.constroiTela();
	}

	private void adicionaComponetesPadroesParaTodasOsPaineis() {
		JLabel[] lsaldos = new JLabel[4];
		JLabel[] lvalSaldos = new JLabel[4];

		for (int i = 0; i <= 3; i++) {
			lsaldos[i] = new JLabel("Saldo: ");
			lvalSaldos[i] = atualizaSaldo();
		}

		painelExtrato.add(lsaldos[0]);
		painelExtrato.add(lvalSaldos[0]);

		painelTransferencia.add(lsaldos[1]);
		painelTransferencia.add(lvalSaldos[1]);

		painelDebitoAutomatico.add(lsaldos[2]);
		painelDebitoAutomatico.add(lvalSaldos[2]);

		painelSaque.add(lsaldos[3]);
		painelSaque.add(lvalSaldos[3]);
	}

	private JLabel atualizaSaldo() {
		BigDecimal saldo = user.getSaldo();
		int compareTo = saldo.compareTo(BigDecimal.ZERO);
		JLabel lsaldo = new JLabel(utilites.getValorComMoeda(user.getSaldo()));

		if (compareTo == -1) {
			// Saldo Negativo
			lsaldo.setForeground(Color.red);
		} else {
			// Saldo 0 ou positivo
			lsaldo.setForeground(Color.blue);
		}
		return lsaldo;
	}

	public void configuraJanela() {
		setSize(500, 500);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
