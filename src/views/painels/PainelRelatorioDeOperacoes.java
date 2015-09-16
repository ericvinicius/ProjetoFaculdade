package views.painels;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelos.Caixa;

import javax.swing.JButton;

public class PainelRelatorioDeOperacoes extends JPanel {
	
	public PainelRelatorioDeOperacoes(){
		setLayout(new BorderLayout());
		
		JPanel painel = criaPainelCentral("Porcentagem das Operacoes");
		painel.setLayout(new GridLayout(6, 1));
		
		JLabel lblsaque = new JLabel("Saque -> " + Caixa.getDadosQtdSaque());
		lblsaque.setHorizontalAlignment(JLabel.CENTER);
		painel.add(lblsaque);
		
		JLabel lbldebitoAutomatico = new JLabel("Cadastro de debitos Automatico -> " + Caixa.getDadosQtdDebitoAutomatico());
		lbldebitoAutomatico.setHorizontalAlignment(JLabel.CENTER);
		painel.add(lbldebitoAutomatico);
		
		JLabel lbltransferencia = new JLabel("Transferencia -> " + Caixa.getDadosQtdTransferencia());
		lbltransferencia.setHorizontalAlignment(JLabel.CENTER);
		painel.add(lbltransferencia);
		
		JLabel lblextrato = new JLabel("Impressao de Extrato -> " + Caixa.getDadosQtdExtato());
		lblextrato.setHorizontalAlignment(JLabel.CENTER);
		painel.add(lblextrato);
		
		JLabel lblsaldo = new JLabel("Impressao de Saldo -> " + Caixa.getDadosQtdSaldo());
		lblsaldo.setHorizontalAlignment(JLabel.CENTER);
		painel.add(lblsaldo);
		
		add(painel, BorderLayout.CENTER);
		
		JButton btImprimir = new JButton("Imprimir");
		add(btImprimir, BorderLayout.SOUTH);
	}
	
	private JPanel criaPainelCentral(String titulo) {
		JPanel painel = new JPanel();
		painel.setBorder(BorderFactory.createTitledBorder(titulo));
		return painel;
	}

}
