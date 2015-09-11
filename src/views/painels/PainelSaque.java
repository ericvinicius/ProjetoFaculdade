package views.painels;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelSaque extends MyPanel implements MouseListener {

	private JLabel lblsaque;
	private JTextField txtsaque;
	private JComboBox<String> compoValorFixo;
	private JButton btsacar;
	private JLabel lblou;
	
	private String valores[] = {"Valor", "10 reais", "20 reais", "50 reais", "100 reais"}; 

	public PainelSaque() {

		// Saque textField
		JPanel paineSaqueTxt = new JPanel();
		lblsaque = new JLabel("Saque");
		paineSaqueTxt.add(lblsaque);

		txtsaque = new JTextField();
		txtsaque.setSelectionStart(0);
		txtsaque.setColumns(12);
		paineSaqueTxt.add(txtsaque);

		painelC.add(paineSaqueTxt, BorderLayout.NORTH);
		
		lblou = new JLabel("ou");
		lblou.setHorizontalAlignment(JLabel.CENTER);
		
		painelC.add(lblou, BorderLayout.CENTER);

		// Cod Consumidor
		JPanel panelValores = new JPanel();
		panelValores.add(vazio);
		
		compoValorFixo = new JComboBox<String>(valores);
		panelValores.add(compoValorFixo);
		
		painelC.add(panelValores, BorderLayout.SOUTH);

		// botao debito automatico
		btsacar = new JButton("Sacar");
		btsacar.addMouseListener(this);
		painelS.add(btsacar, BorderLayout.CENTER);

		JPanel painelDeSaque = criaPainelCentral("Saque");
		painelDeSaque.add(painelC);
		painelDeSaque.add(painelS);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
