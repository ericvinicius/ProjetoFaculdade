package views.painels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.math.BigDecimal;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import modelos.Cliente;
import modelos.ValidadorDeClientes;

import org.jdesktop.swingx.JXPanel;

import textFile.ManipuladorDeArquivos;
import utilities.Logger;
import utilities.Utilites;
import views.GUIMyFrame;
import views.GUIPrincipal;
import dao.ClienteDao;

public class MyPanel extends JXPanel {
	protected Cliente user;
	protected Utilites utilites;
	protected ManipuladorDeArquivos fileHandler = new ManipuladorDeArquivos();
	protected ValidadorDeClientes validador = new ValidadorDeClientes();
	
	protected JXPanel painelN = new JXPanel(new BorderLayout());
	protected JXPanel painelS = new JXPanel(new BorderLayout());
	protected JXPanel painelE = new JXPanel(new BorderLayout());
	protected JXPanel painelW = new JXPanel(new BorderLayout());
	protected JXPanel painelC = new JXPanel(new BorderLayout());
	
	public MyPanel(Cliente u, Utilites ut){
		user = u;
		utilites = ut;
		JXPanel containerSaldo = new JXPanel();
		
		JLabel lsaldos = new JLabel("Saldo: ");
		JLabel lvalSaldos = atualizaSaldo();

		containerSaldo.add(lsaldos);
		containerSaldo.add(lvalSaldos);
		painelN.add(containerSaldo, BorderLayout.NORTH);
		
		configuraPainel();
	}
	
	protected void colocaPainelNoCentro(JPanel painel) {
		painel.add(Box.createVerticalGlue());
		painel.add(Box.createHorizontalGlue());
		JXPanel centerPanel = new JXPanel(new GridBagLayout());
		centerPanel.add(painel);
		add(centerPanel);
	}
	
	private void configuraPainel(){
		setLayout(new BorderLayout());
		add(painelN, BorderLayout.NORTH);
		add(painelS, BorderLayout.SOUTH);
		add(painelE, BorderLayout.EAST);
		add(painelW, BorderLayout.WEST);
		add(painelC, BorderLayout.CENTER);
	}
	
	protected JLabel atualizaSaldo() {
		BigDecimal saldo = BigDecimal.TEN;
		saldo = user.getConta().getSaldo();
		int compareTo = saldo.compareTo(BigDecimal.ZERO);
		JLabel lsaldo = new JLabel(utilites.getValorComMoeda(user.getConta().getSaldo()));

		if (compareTo == -1) {
			// Saldo Negativo
			lsaldo.setForeground(Color.red);
		} else {
			// Saldo 0 ou positivo
			lsaldo.setForeground(Color.blue);
		}
		return lsaldo;
	}
	
	protected void recreate() {
		GUIMyFrame tela = (GUIMyFrame) SwingUtilities.getAncestorOfClass(GUIMyFrame.class, this);
		tela.redirect(tela, GUIPrincipal.class);
		
	}
	
	protected void tremeTela() {
		utilites.tremeTela((GUIMyFrame) SwingUtilities.getAncestorOfClass(GUIMyFrame.class, this));
	}
	
	protected void tremeTela(String mensagem) {
		utilites.tremeTela((GUIMyFrame) SwingUtilities.getAncestorOfClass(GUIMyFrame.class, this));
		JOptionPane.showMessageDialog(this, mensagem, "[ Erro ]", JOptionPane.ERROR_MESSAGE);
	}
	
	protected BigDecimal atualizaSaldoCliente(BigDecimal valor) {
		BigDecimal novoSaldo = user.getConta().getSaldo().subtract(valor);
		user.getConta().setSaldo(novoSaldo);
		
		ClienteDao dao = new ClienteDao();
		dao.atualizaClientePorId(user);
		
		Logger.info("Atualização", "O saldo do cliente foi atualizado");
		
		return novoSaldo;
	}
	
}
