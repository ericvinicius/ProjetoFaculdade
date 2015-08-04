package views.painels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.math.BigDecimal;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelos.Cliente;
import utilities.Utilites;

public class MyPanel extends JPanel {
	protected static Cliente user;
	protected Utilites utilites;
	
	
	public MyPanel(Cliente u, Utilites ut){
		user = u;
		utilites = ut;
		
		configuraPainel();
		
		JLabel lsaldos = new JLabel("Saldo: ");
		JLabel lvalSaldos = atualizaSaldo();

		add(lsaldos);
		add(lvalSaldos);
	}
	
	private void configuraPainel(){
		setLayout(new FlowLayout());
	}
	
	protected JLabel atualizaSaldo() {
		BigDecimal saldo = BigDecimal.TEN;
		saldo = user.getSaldo();
		int compareTo = saldo.compareTo(BigDecimal.ZERO);
		JLabel lsaldo = new JLabel(utilites.getValorComMoeda(user.getSaldo()));

		if (compareTo == -1) {
			// Saldo Negativo
			lsaldo.setForeground(Color.red);
		} else {
			// Saldo 0 ou positivo
			lsaldo.setForeground(Color.blue);
		}
		return lsaldo;
	}
}
