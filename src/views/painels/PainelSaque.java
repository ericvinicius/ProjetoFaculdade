package views.painels;

import idioma.Idioma;

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
	
	private String valores[]; 

	public PainelSaque() {
		idioma = new Idioma();
		// Saque textField
		JPanel paineSaqueTxt = new JPanel();
		lblsaque = new JLabel(idioma.translate("saque"));
		paineSaqueTxt.add(lblsaque);

		txtsaque = new JTextField();
		txtsaque.setSelectionStart(0);
		txtsaque.setColumns(12);
		paineSaqueTxt.add(txtsaque);

		painelC.add(paineSaqueTxt, BorderLayout.NORTH);
		
		lblou = new JLabel(idioma.translate("ou"));
		lblou.setHorizontalAlignment(JLabel.CENTER);
		
		painelC.add(lblou, BorderLayout.CENTER);

		// Cod Consumidor
		JPanel panelValores = new JPanel();
		panelValores.add(vazio);
		
		valores = idioma.getOpcoesDeSaque();
		compoValorFixo = new JComboBox<String>(valores);
		panelValores.add(compoValorFixo);
		
		valores = idioma.getOpcoesDeSaque();
		painelC.add(panelValores, BorderLayout.SOUTH);

		// botao debito automatico
		btsacar = new JButton(idioma.translate("sacar"));
		btsacar.addMouseListener(this);
		painelS.add(btsacar, BorderLayout.CENTER);

		JPanel painelDeSaque = criaPainelCentral(idioma.translate("saque"));
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
