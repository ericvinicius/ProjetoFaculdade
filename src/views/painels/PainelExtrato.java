package views.painels;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import utilities.Utilites;
import modelos.Cliente;

public class PainelExtrato extends MyPanel implements MouseListener {
	
	private JScrollPane scroll = new JScrollPane();
	
	private JTable table;
	private String[][] linhasDaTabela;
	private String[] tituloDaTabela = {"Valor", "Data", "Tipo", "Novo Saldo"};
	
	private JButton imprimiExtrato = new JButton("Imprimir Extrato");
	private JButton imprimiSaldo = new JButton("Imprimir Saldo");
	
	private JLabel lfiltros = new JLabel("Dias:");
	
	public PainelExtrato(Cliente u, Utilites ut){
		super(u, ut);
		
		linhasDaTabela = user.getExtrato();
		
		criaTabela();
		
		add(imprimiExtrato);
		add(imprimiSaldo);
		
		imprimiExtrato.addMouseListener(this);
		imprimiSaldo.addMouseListener(this);
	}

	private void criaTabela() {
		table = new JTable(linhasDaTabela, tituloDaTabela);
		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setEnabled(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(63);
		table.getColumnModel().getColumn(1).setPreferredWidth(204);
		table.getColumnModel().getColumn(2).setPreferredWidth(104);
		table.getColumnModel().getColumn(3).setPreferredWidth(77);
		
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(450, 350));
		scroll.setViewportView(table);
		add(scroll);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == imprimiExtrato){
			//TODO: Imprimi extrato
		} else if(e.getSource() == imprimiSaldo){
			//TODO: Imprimi Saldo
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
