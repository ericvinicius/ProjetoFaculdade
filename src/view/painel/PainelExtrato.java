package view.painel;

import javax.swing.JPanel;
import javax.swing.JTable;

public class PainelExtrato extends JPanel {
	
	private JTable table;

	Object[][] data = { { "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) }, { "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
			{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) }, { "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
			{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) } };

	String[] columnNames = { "First Name", "Last Name", "Sport", "# of Years", "Vegetarian" };
	
	public PainelExtrato(){
		table = new JTable(data, columnNames);
		add(table);
		
		
	}
}
