package views.painels;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import modelos.Cliente;

import org.joda.time.DateTime;

import utilities.Utilites;

public class PainelExtrato extends MyPanel implements MouseListener, FocusListener, KeyListener {
	
	private JScrollPane scroll = new JScrollPane();
	
	private JTable table;
	private Object[][] linhasDaTabela;
	private String[] tituloDaTabela = {"Valor", "Data", "Tipo", "Novo Saldo"};
	
	private JButton imprimiExtrato = new JButton("Imprimir Extrato");
	private JButton imprimiSaldo = new JButton("Imprimir Saldo");
	
	private JLabel lfiltros = new JLabel("Dias:");
	private JTextField tfiltro = new JTextField("");
	private JButton bfiltrar = new JButton("Filtrar");
	
	public PainelExtrato(Cliente u, Utilites ut){
		super(u, ut);
		linhasDaTabela = user.getExtrato();
		
		add(lfiltros);
		
		tfiltro.setColumns(5);
		tfiltro.addFocusListener(this);
		tfiltro.addKeyListener(this);
		add(tfiltro);
		
		bfiltrar.addMouseListener(this);
		add(bfiltrar);
		
		criaEAdicionaTabela();
		
		add(imprimiExtrato);
		add(imprimiSaldo);
		
		imprimiExtrato.addMouseListener(this);
		imprimiSaldo.addMouseListener(this);
	}

	private void criaEAdicionaTabela() {
		atualizaTabela("tudo");
		add(scroll);
	}
	
	private void atualizaTabela(String periodo) {
		try{
			periodo = periodo.trim();
			int dias = Integer.parseInt(periodo);
			filtraTabela(dias);
			
		} catch(NumberFormatException e){
			//Este exception é prevista para quando o periodo nao for int, por exemplo para carregar toda a tabela
		}
		
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
		
		scroll.repaint();
		scroll.revalidate();
	}
	
	private void filtraTabela(int periodo) {
		DateTime data = DateTime.now().minusDays(periodo);
		
		int linhas = linhasDaTabela.length;
		int colunas = linhasDaTabela[0].length;
		Object[][] extrato = new Object[linhas][colunas];
		
		int j = 0;
		for(int i = 0; i < linhas; i++){
			DateTime dataMovimentacao = (DateTime)linhasDaTabela[i][1];
			if(dataMovimentacao.isAfter(data)){
				extrato[j][0] = linhasDaTabela[i][0];
				extrato[j][1] = linhasDaTabela[i][1];
				extrato[j][2] = linhasDaTabela[i][2];
				extrato[j][3] = linhasDaTabela[i][3];
				j++;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == imprimiExtrato){
			//TODO: Imprimi extrato
		} else if(e.getSource() == imprimiSaldo){
			//TODO: Imprimi Saldo
		} else if(e.getSource() == bfiltrar){
			atualizaTabela(lfiltros.getText());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		atualizaTabela(tfiltro.getText());
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// Se for uma letra
		if (e.getKeyChar() > 'a' && e.getKeyChar() < 'Z') {
			// delete
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
