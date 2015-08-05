package views.painels;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelos.Cliente;
import utilities.Utilites;

public class PainelTransferencia extends MyPanel implements KeyListener, MouseListener {

	private JLabel btefetuaTranferencia;
	private JLabel lblconta;
	private JLabel lblagencia;
	private JLabel lblvalor;

	private JFormattedTextField txtconta;
	private JFormattedTextField txtagencia;
	private JTextField txtvalor;
	
	public PainelTransferencia(Cliente u, Utilites ut) {
		super(u, ut);
		
		// Conta
		JPanel painelConta = new JPanel();
		lblconta = new JLabel("Conta   ");
		painelConta.add(lblconta);

		txtconta = new JFormattedTextField(utilites.criadorDeMascara(utilites.maskConta));
		txtconta.setSelectionStart(0);
		txtconta.setColumns(12);
		txtconta.addKeyListener(this);
		painelConta.add(txtconta);
		
		painelC.add(painelConta, BorderLayout.NORTH);

		// Agencia
		JPanel painelAgencia = new JPanel();
		lblagencia = new JLabel("Agencia");
		painelAgencia.add(lblagencia);

		txtagencia = new JFormattedTextField(utilites.criadorDeMascara(utilites.maskAgencia));
		txtagencia.setSelectionStart(0);
		txtagencia.setColumns(12);
		txtagencia.addKeyListener(this);
		painelAgencia.add(txtagencia);
		
		painelC.add(painelAgencia, BorderLayout.CENTER);

		// Valor
		JPanel painelValor = new JPanel();
		lblvalor = new JLabel("Valor    ");
		painelValor.add(lblvalor);

		txtvalor = new JTextField();
		txtvalor.setColumns(12);
		painelValor.add(txtvalor);
		
		painelC.add(painelValor, BorderLayout.SOUTH);

		// botao login
		btefetuaTranferencia = new JLabel("Realizar Transferencia");
		btefetuaTranferencia.addMouseListener(this);
		painelS.add(btefetuaTranferencia, BorderLayout.CENTER);
		
		//Cria painel que vai possuir a borda
		JPanel painelDeTransferencia = new JPanel();
		painelDeTransferencia.setLayout(new BoxLayout(painelDeTransferencia, BoxLayout.PAGE_AXIS));
		painelDeTransferencia.setBorder(BorderFactory.createLoweredBevelBorder());
		painelDeTransferencia.setBackground(Utilites.corCinzaEscuro);
		
		//Adiciona conteudo a este painel
		painelDeTransferencia.add(new JLabel("Transferencia: "));
		painelDeTransferencia.add(painelC);
		painelDeTransferencia.add(painelS);
		
		//forca o painel ficar no centro da tela
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

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
