package views.painels;

import idioma.Idioma;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.TableColumnModel;

import utilities.Utilites;

public class PainelExtrato extends MyPanel implements MouseListener, KeyListener {

	private JScrollPane scroll = new JScrollPane();

	private JTable table;
	private Object[][] linhasDaTabela;

	private String[] tituloDaTabela;

	private JButton imprimiExtrato;
	private JButton imprimiSaldo;

	private JLabel lfiltros;
	private JFormattedTextField tfiltro = new JFormattedTextField(utilites.criadorDeMascara(utilites.maskFiltraTabela, false));
	private JButton bfiltrar;

	public PainelExtrato() {
		idioma = new Idioma();
		
		tituloDaTabela = idioma.getTitulasDaTabela();
		linhasDaTabela = user.getExtrato();

		lfiltros = new JLabel(idioma.translate("filtrarDias"));
		painelN.add(lfiltros, BorderLayout.WEST);

		tfiltro.setSelectionStart(0);
		tfiltro.addKeyListener(this);
		painelN.add(tfiltro, BorderLayout.CENTER);
		
		bfiltrar = new JButton(idioma.translate("filtrar"));
		bfiltrar.addMouseListener(this);
		painelN.add(bfiltrar, BorderLayout.EAST);

		criaEAdicionaTabela();

		imprimiExtrato = new JButton(idioma.translate("impExtrato"));
		imprimiSaldo = new JButton(idioma.translate("impSaldo"));
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
		try {
			int dias = Integer.parseInt(periodo.trim());
			filtraTabela(dias);

		} catch (NumberFormatException e) {
			System.out.println("exception");
			// Este exception é prevista para quando o periodo nao for int, por
			// exemplo para carregar toda a tabela, passo "tudo"
			// TODO: criar log que nao mostra erro na tela do usuario
		}

		table = new JTable(linhasDaTabela, tituloDaTabela);
		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TableColumnModel modeloDeColunas = table.getColumnModel();
		modeloDeColunas.getColumn(0).setPreferredWidth(87);
		modeloDeColunas.getColumn(1).setPreferredWidth(147);
		modeloDeColunas.getColumn(2).setPreferredWidth(121);
		modeloDeColunas.getColumn(3).setPreferredWidth(120);
		table.setColumnModel(modeloDeColunas);
		table.getTableHeader().setReorderingAllowed(false);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(450, 150));
		scroll.setViewportView(table);

		scroll.repaint();
		scroll.revalidate();
	}

	private void filtraTabela(int periodo) {
		LocalDate hoje = LocalDate.now();
		LocalDate diaMaximoParaFiltrarTabela = hoje.minusDays(periodo);
		getNovoExtrato(diaMaximoParaFiltrarTabela);
	}

	private void getNovoExtrato(LocalDate diaMaximoParaFiltrarTabela) {
		Object tabela[][] = user.getExtrato();
		Object novaTabela[][] = new Object[linhasDaTabela.length][4];
		
		int j = 0;
		for(int i = 0; i < tabela.length; i++){
			String diaFormatado = (String) tabela[i][0];
			LocalDate diaDaMovimentacao = LocalDate.parse(diaFormatado, Utilites.formatDia);
			
			if(diaDaMovimentacao.isAfter(diaMaximoParaFiltrarTabela)){
				for(int k = 0; k <= 3; k++){
					novaTabela[j][k] = tabela[i][k];
				}
				j++;
			} 
		}
		linhasDaTabela = novaTabela;
		this.revalidate();
		this.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == imprimiExtrato) {
			// TODO: Imprimi extrato
		} else if (e.getSource() == imprimiSaldo) {
			// TODO: Imprimi Saldo
		} else if (e.getSource() == bfiltrar) {
			System.out.println("tfiltro = (" + tfiltro.getText() + ")");
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
		Object campo = e.getSource();
		char letra = e.getKeyChar();
		if(campo.equals(tfiltro)){
			if (letra > 'a' && letra < 'Z') {
				e.consume();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
