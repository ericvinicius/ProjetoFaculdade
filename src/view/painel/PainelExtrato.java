package view.painel;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class PainelExtrato extends JPanel implements MouseListener {
	
	private JScrollPane scroll = new JScrollPane();
	
	private JTable table;
	private String[][] rowData;
	private String[] columnNames = {"Valor", "Data", "Tipo", "Novo Saldo"};
	
	private JButton imprimiExtrato = new JButton("Imprimir Extrato");
	private JButton imprimiSaldo = new JButton("Imprimir Saldo");
	
	public PainelExtrato(){
		imprimiExtrato.addMouseListener(this);
		imprimiSaldo.addMouseListener(this);
	}

	public void constroiTela(String[][] ex) {
		//TODO: Descomentar para mostrar o extrato
		rowData = ex;
		
		table = new JTable(rowData, columnNames);
		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setEnabled(false);
		
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(450, 350));
		scroll.setViewportView(table);
		
		add(scroll);
		add(imprimiExtrato);
		add(imprimiSaldo);
		
		
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
