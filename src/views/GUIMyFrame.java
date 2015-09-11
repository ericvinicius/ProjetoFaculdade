package views;

import interfaces.MyConfiguration;

import javax.swing.JFrame;

import modelos.Cliente;
import textFile.ManipuladorDeArquivos;
import utilities.Utilites;

public abstract class GUIMyFrame extends JFrame implements MyConfiguration {

	protected static Cliente user;
	protected Utilites utilites = new Utilites();
	protected ManipuladorDeArquivos fileHandler = new ManipuladorDeArquivos();

	public GUIMyFrame() {
		super("");
		configuraPagina();
	}

	public void globalConfig() {
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void redirect(JFrame janelaAtual, Class<? extends GUIMyFrame> clazz) {
		janelaAtual.dispose();
		Utilites.temMensagemDeErro = false;
		if(clazz.equals(GUIPrincipal.class)){
			user = user.carregaCliente();
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
