package views.painels;

import idioma.Idioma;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelos.Caixa;

public class PainelRelatorioDeOperacoes extends JPanel {
	
	public PainelRelatorioDeOperacoes(){
		setLayout(new BorderLayout());
		Idioma idioma = new Idioma();
		
		JPanel painel = criaPainelCentral(idioma.translate("porcentagem"));
		painel.setLayout(new GridLayout(6, 1));
		
		JLabel lblsaque = new JLabel(idioma.translate("saque") + " -> " + Caixa.getDadosQtdSaque());
		lblsaque.setHorizontalAlignment(JLabel.CENTER);
		painel.add(lblsaque);
		
		JLabel lbldebitoAutomatico = new JLabel(idioma.translate("debito") + " -> " + Caixa.getDadosQtdDebitoAutomatico());
		lbldebitoAutomatico.setHorizontalAlignment(JLabel.CENTER);
		painel.add(lbldebitoAutomatico);
		
		JLabel lbltransferencia = new JLabel(idioma.translate("transferencia") + " -> " + Caixa.getDadosQtdTransferencia());
		lbltransferencia.setHorizontalAlignment(JLabel.CENTER);
		painel.add(lbltransferencia);
		
		JLabel lblextrato = new JLabel(idioma.translate("extrato") + " -> " + Caixa.getDadosQtdExtato());
		lblextrato.setHorizontalAlignment(JLabel.CENTER);
		painel.add(lblextrato);
		
		JLabel lblsaldo = new JLabel(idioma.translate("saldo") + " -> " + Caixa.getDadosQtdSaldo());
		lblsaldo.setHorizontalAlignment(JLabel.CENTER);
		painel.add(lblsaldo);
		
		add(painel, BorderLayout.CENTER);
		
		JButton btImprimir = new JButton(idioma.translate("imprimir"));
		add(btImprimir, BorderLayout.SOUTH);
	}
	
	private JPanel criaPainelCentral(String titulo) {
		JPanel painel = new JPanel();
		painel.setBorder(BorderFactory.createTitledBorder(titulo));
		return painel;
	}

}
