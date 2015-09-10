package views.painels;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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

	private JButton btefetuaTranferencia;
	private JLabel lblconta;
	private JLabel lblagencia;
	private JLabel lblvalor;

	private JFormattedTextField txtoperadora;
	private JFormattedTextField txtconsumidor;
	private JDateChooser combodia;
	private JRadioButton radiotipo;
	private JRadioButton radioluz;
	private JRadioButton radioagua;
	private JRadioButton radiotel;

	public PainelDebitoAutomatico(Cliente u, Utilites ut) {
		super(u, ut);

		//Cod Operadora
		JPanel paineloperadora = new JPanel();
		lblconta = new JLabel(" Cod. Operadora:  ");
		paineloperadora.add(lblconta);

		txtoperadora = new JFormattedTextField(utilites.criadorDeMascara(utilites.maskConta, true));
		txtoperadora.setSelectionStart(0);
		txtoperadora.setColumns(12);
		paineloperadora.add(txtoperadora);

		painelC.add(paineloperadora, BorderLayout.NORTH);

		// Cod Consumidor
		JPanel painelconsumidor = new JPanel();
		lblagencia = new JLabel("Cod. Consumidor:");
		painelconsumidor.add(lblagencia);

		txtconsumidor = new JFormattedTextField(utilites.criadorDeMascara(utilites.maskAgencia, true));
		txtconsumidor.setSelectionStart(0);
		txtconsumidor.setColumns(12);
		painelconsumidor.add(txtconsumidor);

		painelC.add(painelconsumidor, BorderLayout.CENTER);

		// Data
		JPanel painelData = new JPanel();
		lblvalor = new JLabel("Data ");
		painelData.add(lblvalor);

		combodia = new JDateChooser();
		painelData.add(combodia);
		
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

		// botao transferencia
		btefetuaTranferencia = new JButton("Autorizar Debido Automatico");
		btefetuaTranferencia.addMouseListener(this);
		painelS.add(btefetuaTranferencia, BorderLayout.CENTER);

		// Cria painel que vai possuir a borda
		JPanel painelDeTransferencia = new JPanel();
		painelDeTransferencia.setLayout(new BoxLayout(painelDeTransferencia, BoxLayout.PAGE_AXIS));
		painelDeTransferencia.setBorder(BorderFactory.createLoweredBevelBorder());
		painelDeTransferencia.setBackground(Utilites.corAzul);

		// Adiciona conteudo a este painel
		JLabel titulo = new JLabel("Debito Automatico: ");
		titulo.setForeground(Utilites.corBranco);
		painelDeTransferencia.add(titulo);
		painelDeTransferencia.add(painelC);
		painelDeTransferencia.add(painelS);

		// forca o painel ficar no centro da tela
		colocaPainelNoCentro(painelDeTransferencia);
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
