package views;

import interfaces.MyConfiguration;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import modelos.Cliente;

import org.jdesktop.swingx.JXFrame;

import textFile.ManipuladorDeArquivos;
import utilities.Utilites;
import dao.ClienteDao;

public abstract class GUIMyFrame extends JXFrame implements MyConfiguration {

	private JMenuBar barraDeMenu;
	protected JMenu opcoes;
	protected JMenuItem opcaoAdmin;
	
	private ClienteDao clienteDao = new ClienteDao();
	
	protected static Cliente user;
	protected Utilites utilites = new Utilites();
	protected ManipuladorDeArquivos fileHandler = new ManipuladorDeArquivos();

	public GUIMyFrame() {
		super("", true);
		configuraPagina();
		
		barraDeMenu = new JMenuBar();
		opcoes = new JMenu("Opcoes");
		opcaoAdmin = new JMenuItem();
		
		barraDeMenu.add(opcoes);
		
		setJMenuBar(barraDeMenu);
	}

	public void globalConfig() {
		// TODO: Trocar para false no fim do projeto
		setResizable(true);
	}
	
	public void redirect(JFrame janelaAtual, Class<? extends GUIMyFrame> clazz) {
		janelaAtual.dispose();
		Utilites.temMensagemDeErro = false;
		if(clazz.equals(GUIPrincipal.class)){
			user = clienteDao.carregaCliente(user);
		}
		try {
			clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
