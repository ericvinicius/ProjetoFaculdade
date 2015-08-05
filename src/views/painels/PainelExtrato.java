package views.painels;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import utilities.Utilites;

public class PainelExtrato extends MyPanel implements MouseListener, KeyListener {
	
	private JScrollPane scroll = new JScrollPane();
	
	private JTable table;
	private Object[][] linhasDaTabela;

	private String[] tituloDaTabela = {"Valor", "Data", "Tipo", "Novo Saldo"};
	
	private JButton imprimiExtrato = new JButton("Imprimir Extrato");
	private JButton imprimiSaldo = new JButton("Imprimir Saldo");
	
	private JLabel lfiltros = new JLabel("Filtrar dias atras:");
	private JTextField tfiltro = new JTextField("");
	private JButton bfiltrar = new JButton("Aplicar filtro");
	
	public PainelExtrato(Cliente u, Utilites ut){
		super(u, ut);
		linhasDaTabela = user.getExtrato();
		
		painelN.add(lfiltros, BorderLayout.WEST);
		
		tfiltro.setColumns(5);
		tfiltro.addKeyListener(this);
		painelN.add(tfiltro, BorderLayout.CENTER);
		
		bfiltrar.addMouseListener(this);
		painelN.add(bfiltrar, BorderLayout.EAST);
		
		criaEAdicionaTabela();
		
		painelS.add(imprimiExtrato, BorderLayout.WEST);
		painelS.add(imprimiSaldo, BorderLayout.EAST);
		
		imprimiExtrato.addMouseListener(this);
		imprimiSaldo.addMouseListener(this);
	}

	private void criaEAdicionaTabela() {
		atualizaTabela("tudo");
		painelC.add(scroll, BorderLayout.CENTER);
	}
	
	private void atualizaTabela(String periodo) {
		try{
			int dias = Integer.parseInt(periodo);
			filtraTabela(dias);
			
		} catch(NumberFormatException e){
			//Este exception é prevista para quando o periodo nao for int, por exemplo para carregar toda a tabela, passo "tudo"
			//TODO: criar log que nao mostra erro na tela do usuario
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
		scroll.setPreferredSize(new Dimension(450, 150));
		scroll.setViewportView(table);
		
		scroll.repaint();
		scroll.revalidate();
	}
	
	private void filtraTabela(int periodo) {
		DateTimeFormatter fmt = DateTimeFormat.forPattern(utilites.maskDiaHora);
		DateTime data = DateTime.now().minusDays(periodo);
		String dataFormatada = fmt.print(data);
		data = fmt.parseDateTime(dataFormatada);
		
		int linhas = linhasDaTabela.length;
		int colunas = linhasDaTabela[0].length;
		Object[][] extrato = new Object[linhas][colunas];
		
		int j = 0;
		for(int i = 0; i < linhas; i++){
			DateTime dataMovimentacao = fmt.parseDateTime(linhasDaTabela[i][1] + "");
			System.out.println(dataMovimentacao + "- -- - -" + data);
			System.out.println(linhasDaTabela[i][1]);
			if(dataMovimentacao.isAfter(data)){
				extrato[j][0] = linhasDaTabela[i][0];
				extrato[j][1] = linhasDaTabela[i][1];
				extrato[j][2] = linhasDaTabela[i][2];
				extrato[j][3] = linhasDaTabela[i][3];
				j++;
			}
		}
		System.out.println("==========");
		linhasDaTabela = extrato;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == imprimiExtrato){
			//TODO: Imprimi extrato
		} else if(e.getSource() == imprimiSaldo){
			//TODO: Imprimi Saldo
		} else if(e.getSource() == bfiltrar){
			atualizaTabela(tfiltro.getText());
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
	public void keyTyped(KeyEvent e) {
		// Se for uma letra
		if (e.getKeyChar() > 'a' && e.getKeyChar() < 'Z') {
			// delete
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
