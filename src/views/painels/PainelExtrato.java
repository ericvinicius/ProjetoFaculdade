package views.painels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.TableColumnModel;

import modelos.Cliente;

import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXTable;

import utilities.Utilites;

public class PainelExtrato extends MyPanel implements MouseListener, KeyListener {

	private JScrollPane scroll = new JScrollPane();

	private JXTable table;
	private Object[][] linhasDaTabela;

	private String[] tituloDaTabela = { "Data", "Tipo", "Valor", "Novo Saldo" };

	private JXButton imprimiExtrato = new JXButton("Imprimir Extrato");
	private JXButton imprimiSaldo = new JXButton("Imprimir Saldo");

	private JLabel lfiltros = new JLabel("Filtrar dias atras:");
	private JFormattedTextField tfiltro = new JFormattedTextField(utilites.criadorDeMascara(utilites.maskFiltraTabela, false));
	private JXButton bfiltrar = new JXButton("Aplicar filtro");

	public PainelExtrato(Cliente u, Utilites ut) {
		super(u, ut);
		linhasDaTabela = user.getExtrato();

		painelN.add(lfiltros, BorderLayout.WEST);

		tfiltro.setSelectionStart(0);
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
		try {
			int dias = Integer.parseInt(periodo);
			filtraTabela(dias);

		} catch (NumberFormatException e) {
			// Este exception é prevista para quando o periodo nao for int, por
			// exemplo para carregar toda a tabela, passo "tudo"
			// TODO: criar log que nao mostra erro na tela do usuario
		}

		table = new JXTable(linhasDaTabela, tituloDaTabela);
		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TableColumnModel modeloDeColunas = table.getColumnModel();
		modeloDeColunas.getColumn(0).setPreferredWidth(165);
		modeloDeColunas.getColumn(1).setPreferredWidth(125);
		modeloDeColunas.getColumn(2).setPreferredWidth(93);
		modeloDeColunas.getColumn(3).setPreferredWidth(93);
		table.setColumnModel(modeloDeColunas);
		table.setEditable(false);
		table.getTableHeader().setReorderingAllowed(false);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(450, 150));
		scroll.setViewportView(table);

		scroll.repaint();
		scroll.revalidate();
	}

	private void filtraTabela(int periodo) {
		//TODO: Este metodo nao esta funfando
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == imprimiExtrato) {
			// TODO: Imprimi extrato
		} else if (e.getSource() == imprimiSaldo) {
			// TODO: Imprimi Saldo
		} else if (e.getSource() == bfiltrar) {
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
