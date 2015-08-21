package views;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import modelos.Cliente;

import org.jdesktop.swingx.JXFrame;

import textFile.ManipuladorDeArquivos;
import utilities.Utilites;
import dao.ClienteDao;

public class GUIMyFrame extends JXFrame {

	private JMenuBar barraDeMenu;
	protected JMenu opcoes;
	protected JMenuItem opcaoAdmin;
	
	private ClienteDao clienteDao = new ClienteDao();
	
	protected static Cliente user;
	protected Utilites utilites = new Utilites();
	protected ManipuladorDeArquivos fileHandler = new ManipuladorDeArquivos();

	public GUIMyFrame() {
		super("", true);
		configuraJanela();
		
		barraDeMenu = new JMenuBar();
		opcoes = new JMenu("Opcoes");
		opcaoAdmin = new JMenuItem();
		
		barraDeMenu.add(opcoes);
		
		setJMenuBar(barraDeMenu);
	}

	public void configuraJanela() {
		// TODO: Trocar para false no fim do projeto
		setResizable(true);
	}
	
	public void redirect(JFrame janelaAtual, String frame) {
		janelaAtual.dispose();
		Utilites.temMensagemDeErro = false;
		
		if(frame.equals("codigoDeAcesso")){
			new GUICodigoDeAcesso();
		} else if(frame.equals("principal")){
			user = clienteDao.carregaCliente(user);
			new GUIPrincipal();
		} else if(frame.equals("login")){
			new GUILogin();
		}
	}

	public void destroyAndInit() {
		user = clienteDao.carregaCliente(user);
		new GUIPrincipal();
	}
	
}
