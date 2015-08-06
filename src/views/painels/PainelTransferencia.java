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

import modelos.Cliente;

import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTextField;

import utilities.Utilites;

public class PainelTransferencia extends MyPanel implements KeyListener, MouseListener {

	private JXButton btefetuaTranferencia;
	private JLabel lblconta;
	private JLabel lblagencia;
	private JLabel lblvalor;

	private JFormattedTextField txtconta;
	private JFormattedTextField txtagencia;
	private JXTextField txtvalor;
	
	public PainelTransferencia(Cliente u, Utilites ut) {
		super(u, ut);
		
		// Conta
		JXPanel painelConta = new JXPanel();
		lblconta = new JLabel("Conta   ");
		painelConta.add(lblconta);

		txtconta = new JFormattedTextField(utilites.criadorDeMascara(utilites.maskConta));
		txtconta.setSelectionStart(0);
		txtconta.setColumns(12);
		txtconta.addKeyListener(this);
		painelConta.add(txtconta);
		
		painelC.add(painelConta, BorderLayout.NORTH);

		// Agencia
		JXPanel painelAgencia = new JXPanel();
		lblagencia = new JLabel("Agencia");
		painelAgencia.add(lblagencia);

		txtagencia = new JFormattedTextField(utilites.criadorDeMascara(utilites.maskAgencia));
		txtagencia.setSelectionStart(0);
		txtagencia.setColumns(12);
		txtagencia.addKeyListener(this);
		painelAgencia.add(txtagencia);
		
		painelC.add(painelAgencia, BorderLayout.CENTER);

		// Valor
		JXPanel painelValor = new JXPanel();
		lblvalor = new JLabel("Valor    ");
		painelValor.add(lblvalor);

		txtvalor = new JXTextField();
		txtvalor.setColumns(12);
		painelValor.add(txtvalor);
		
		painelC.add(painelValor, BorderLayout.SOUTH);

		// botao login
		btefetuaTranferencia = new JXButton("Realizar Transferencia");
		btefetuaTranferencia.addMouseListener(this);
		painelS.add(btefetuaTranferencia, BorderLayout.CENTER);
		
		//Cria painel que vai possuir a borda
		JXPanel painelDeTransferencia = new JXPanel();
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
		if(e.getSource().equals(btefetuaTranferencia)){
			
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
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
