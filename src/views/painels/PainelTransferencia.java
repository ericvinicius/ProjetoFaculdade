package views.painels;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelos.Cliente;
import modelos.Movimentacao;
import utilities.Logger;
import utilities.Utilites;
import builders.ClienteBuilder;
import builders.MovimentacaoBuilder;

public class PainelTransferencia extends MyPanel implements MouseListener {

	private JButton btefetuaTranferencia;
	private JLabel lblconta;
	private JLabel lblagencia;
	private JLabel lblvalor;

	private JFormattedTextField txtconta;
	private JFormattedTextField txtagencia;
	private JTextField txtvalor;

	private Cliente userDestino;
	private BigDecimal valor;

	public PainelTransferencia(Cliente u, Utilites ut) {
		super(u, ut);

		// Conta
		JPanel painelConta = new JPanel();
		lblconta = new JLabel("Conta   ");
		painelConta.add(lblconta);

		txtconta = new JFormattedTextField(utilites.criadorDeMascara(utilites.maskConta, true));
		txtconta.setSelectionStart(0);
		txtconta.setColumns(12);
		painelConta.add(txtconta);

		painelC.add(painelConta, BorderLayout.NORTH);

		// Agencia
		JPanel painelAgencia = new JPanel();
		lblagencia = new JLabel("Agencia");
		painelAgencia.add(lblagencia);

		txtagencia = new JFormattedTextField(utilites.criadorDeMascara(utilites.maskAgencia, true));
		txtagencia.setSelectionStart(0);
		txtagencia.setColumns(12);
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

		// botao transferencia
		btefetuaTranferencia = new JButton("Realizar Transferencia");
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
		if (e.getSource().equals(btefetuaTranferencia)) {
			if (carregaEVerificaDados()) {
					efetuaTransferencia();
					
			} else {
				tremeTela();
			}
		}
	}

	private void efetuaTransferencia() {
		MovimentacaoBuilder builder = new MovimentacaoBuilder();
		builder.comValor(valor).comIdDoCliente(user.getId()).comIdClienteDestino(userDestino.getId()).comNovoSaldo(user.getConta().getSaldo().subtract(valor));
		Movimentacao transferencia = builder.constroi();

		transferencia.efetua();

		user.addMovimentacao(transferencia);
		recreate();
	}

	private boolean carregaEVerificaDados() {
		try {
			pegaInformacoesDeLogin();
			if(valor.compareTo(BigDecimal.ZERO) <= 0){
				return false;
			}
			
			userDestino = fileHandler.usuarioExiste(userDestino);
			if (userDestino != null && userDestino.getId() != user.getId()) {
				return true;
			}
			Logger.warn("invalido", "Cliente entrou com os dados dele mesmo");
		} catch (NumberFormatException nfe) {
			// TODO: Esta exception é esperada quando o usuario digita uma letra
			// no campo do valor tenho que impedir isto
			Logger.warn("invalido", "Cliente digitou letra no campo do valor");
		} catch (NullPointerException npe) {
			Logger.warn("Em Branco", "Cliente deixou campos da transferencia em branco");
		}
		return false;
	}

	public void pegaInformacoesDeLogin() throws NumberFormatException, NullPointerException {
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
}
