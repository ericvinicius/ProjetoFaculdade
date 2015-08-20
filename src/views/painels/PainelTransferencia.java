package views.painels;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import modelos.Cliente;
import modelos.Movimentacao;

import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTextField;

import utilities.Logger;
import utilities.Utilites;
import builders.ClienteBuilder;
import builders.MovimentacaoBuilder;

public class PainelTransferencia extends MyPanel implements KeyListener, MouseListener {

	private JXButton btefetuaTranferencia;
	private JLabel lblconta;
	private JLabel lblagencia;
	private JLabel lblvalor;

	private JFormattedTextField txtconta;
	private JFormattedTextField txtagencia;
	private JXTextField txtvalor;

	private Cliente userDestino;
	private BigDecimal valor;

	public PainelTransferencia(Cliente u, Utilites ut) {
		super(u, ut);

		// Conta
		JXPanel painelConta = new JXPanel();
		lblconta = new JLabel("Conta   ");
		painelConta.add(lblconta);

		txtconta = new JFormattedTextField(utilites.criadorDeMascara(utilites.maskConta, true));
		txtconta.setSelectionStart(0);
		txtconta.setColumns(12);
		txtconta.addKeyListener(this);
		painelConta.add(txtconta);

		painelC.add(painelConta, BorderLayout.NORTH);

		// Agencia
		JXPanel painelAgencia = new JXPanel();
		lblagencia = new JLabel("Agencia");
		painelAgencia.add(lblagencia);

		txtagencia = new JFormattedTextField(utilites.criadorDeMascara(utilites.maskAgencia, true));
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

		// Cria painel que vai possuir a borda
		JXPanel painelDeTransferencia = new JXPanel();
		painelDeTransferencia.setLayout(new BoxLayout(painelDeTransferencia, BoxLayout.PAGE_AXIS));
		painelDeTransferencia.setBorder(BorderFactory.createLoweredBevelBorder());
		painelDeTransferencia.setBackground(Utilites.corCinzaEscuro);

		// Adiciona conteudo a este painel
		painelDeTransferencia.add(new JLabel("Transferencia: "));
		painelDeTransferencia.add(painelC);
		painelDeTransferencia.add(painelS);

		// forca o painel ficar no centro da tela
		colocaPainelNoCentro(painelDeTransferencia);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(btefetuaTranferencia)) {
			if (dadosValidos() && fileHandler.usuarioExiste(userDestino)) {
				efetuaTransferencia();
			} else {
				tremeTela();
			}
		}
	}

	private void efetuaTransferencia() {
		MovimentacaoBuilder builder = new MovimentacaoBuilder();
		builder.comValor(valor).comIdDoCliente(user.getId()).comIdClienteDestino(/*Tenho que pegar o id do cliente*/1L);
		Movimentacao transferencia = builder.constroi();

		transferencia.efetua();

		user.addMovimentacao(transferencia);
		recreate();
	}

	private boolean dadosValidos() {
		try {
			pegaInformacoesDeLogin();
			
			 /*
			 * TODO: Aqui pode ser feita a verificacao do saldo do cliente
			 */
			if (!validador.possuemAgenciaEContaIguais(user, userDestino)) {
				return true;
			}

			Logger.warn("invalido", "Cliente entrou com os dados dele mesmo");
		} catch (NumberFormatException ne) {
			// TODO: Esta exception é esperada quando o usuario digita uma letra
			// no campo do valor
			Logger.warn("invalido", "Cliente digitou letra no campo do valor");
		}
		return false;
	}

	public void pegaInformacoesDeLogin() throws NumberFormatException {
		String agenciaDestino = txtagencia.getValue().toString();
		String contaDestino = txtconta.getValue().toString();
		ClienteBuilder builder = new ClienteBuilder();
		userDestino = builder.comAgencia(agenciaDestino).comConta(contaDestino).constroi();

		valor = new BigDecimal(Double.parseDouble(txtvalor.getText()));
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
