package view;

import java.awt.GridLayout;
import javax.swing.JTabbedPane;


public class GUIPrincipal extends GUIMyFrame {
	public GUIPrincipal(){
		configuraJanela();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Saldo", null, tabbedPane_1, null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Pagamento e Transferencia", null, tabbedPane_2, null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Cadastrar debito Automatico", null, tabbedPane_3, null);
		
		
		
	}
	
	public void configuraJanela() {
		getContentPane().setLayout(new GridLayout());
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
