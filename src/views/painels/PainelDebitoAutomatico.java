package views.painels;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import modelos.Cliente;
import utilities.Utilites;

import com.toedter.calendar.JDateChooser;

public class PainelDebitoAutomatico extends MyPanel implements MouseListener {

	private JButton btdebitoAutomatico;
	private JLabel lbloperadora;
	private JLabel lblconsumidor;
	private JLabel lbldata;

	private JFormattedTextField txtoperadora;
	private JFormattedTextField txtconsumidor;
	private JDateChooser dateChooser;
	private JRadioButton radioluz;
	private JRadioButton radioagua;
	private JRadioButton radiotel;

	public PainelDebitoAutomatico() {

		//Cod Operadora
		JPanel paineloperadora = new JPanel();
		lbloperadora = new JLabel(" Cod. Operadora:  ");
		paineloperadora.add(lbloperadora);

		txtoperadora = new JFormattedTextField(utilites.criadorDeMascara(utilites.maskConta, true));
		txtoperadora.setSelectionStart(0);
		txtoperadora.setColumns(12);
		paineloperadora.add(txtoperadora);

		painelC.add(paineloperadora, BorderLayout.NORTH);

		// Cod Consumidor
		JPanel painelconsumidor = new JPanel();
		lblconsumidor = new JLabel("Cod. Consumidor:");
		painelconsumidor.add(lblconsumidor);

		txtconsumidor = new JFormattedTextField(utilites.criadorDeMascara(utilites.maskAgencia, true));
		txtconsumidor.setSelectionStart(0);
		txtconsumidor.setColumns(12);
		painelconsumidor.add(txtconsumidor);

		painelC.add(painelconsumidor, BorderLayout.CENTER);

		// Data
		JPanel painelData = new JPanel();
		lbldata = new JLabel("Data ");
		painelData.add(lbldata);

		dateChooser = new JDateChooser();
		painelData.add(dateChooser);
		
		painelC.add(painelData, BorderLayout.SOUTH);
		
		// Radios type
		JPanel painelRadio = new JPanel();
		ButtonGroup radioGroup = new ButtonGroup();
		
		radioagua = new JRadioButton("Agua");
		radioluz = new JRadioButton("Luz");
		radiotel = new JRadioButton("Telefone");
		
		radioGroup.add(radioagua);
		radioGroup.add(radioluz);
		radioGroup.add(radiotel);
		
		painelRadio.add(radioagua);
		painelRadio.add(radioluz);
		painelRadio.add(radiotel);
		
		painelS.add(painelRadio, BorderLayout.NORTH);

		// botao debito automatico
		btdebitoAutomatico = new JButton("Autorizar Debido Automatico");
		btdebitoAutomatico.addMouseListener(this);
		painelS.add(btdebitoAutomatico, BorderLayout.CENTER);

		JPanel painelDeDebitoAutomatico = criaPainelCentral("Debito Automatico");
		painelDeDebitoAutomatico.add(painelC);
		painelDeDebitoAutomatico.add(painelS);
	}


	@Override
	public void mouseClicked(MouseEvent e) {

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

}
