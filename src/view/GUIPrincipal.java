package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.math.BigDecimal;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class GUIPrincipal extends GUIMyFrame {

	private JTabbedPane painelDeAbas = new JTabbedPane();
	private JPanel painelExtrato = new JPanel();
	private JPanel painelTransferencia = new JPanel();
	private JPanel painelDebitoAutomatico = new JPanel();
	private JPanel painelSaque = new JPanel();
	private JLabel[] lsaldos;
	private JLabel[] lvalSaldos;
	private final JTable table;
	
	
	Object[][] data = {
		    {"Kathy", "Smith",
		     "Snowboarding", new Integer(5), new Boolean(false)},
		    {"John", "Doe",
		     "Rowing", new Integer(3), new Boolean(true)},
		    {"Sue", "Black",
		     "Knitting", new Integer(2), new Boolean(false)},
		    {"Jane", "White",
		     "Speed reading", new Integer(20), new Boolean(true)},
		    {"Joe", "Brown",
		     "Pool", new Integer(10), new Boolean(false)}
		};
	
	String[] columnNames = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};

	public GUIPrincipal() {
		configuraJanela();
		criaPaineis();
		table = new JTable(data, columnNames);
		// Nome - data - hora
		JLabel lnome = new JLabel(user.getNome());
		lnome.setHorizontalAlignment(JLabel.CENTER);
		utilites.mostrarHoraNoLabel(lnome);
		getContentPane().add(lnome, BorderLayout.NORTH);

		// Adiciona as abas
		painelDeAbas.addTab("Extrato", painelExtrato);
		painelExtrato.add(table);
		painelDeAbas.addTab("Transferencia", painelTransferencia);
		painelDeAbas.addTab("Debito Automatico", painelDebitoAutomatico);
		painelDeAbas.addTab("Saque", painelSaque);
		getContentPane().add(painelDeAbas, BorderLayout.CENTER);

	}

	private void criaPaineis() {
		adicionaComponetesPadroesParaTodasOsPaineis();

		// news dos paineis
	}

	private void adicionaComponetesPadroesParaTodasOsPaineis() {
		lsaldos = new JLabel[4];
		lvalSaldos = new JLabel[4];
		
		for(int i = 0; i <= 3; i++){	
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
		
		if(compareTo == -1){
			//Saldo Negativo
			lsaldo.setForeground(Color.red);
		} else {
			//Saldo 0 ou positivo
			lsaldo.setForeground(Color.blue);
		}
		return lsaldo;
	}

	public void configuraJanela() {
		getContentPane().setLayout(new GridLayout());
		setSize(500, 500);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
