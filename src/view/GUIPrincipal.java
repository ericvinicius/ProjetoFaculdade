package view;

import java.awt.GridLayout;


public class GUIPrincipal extends GUIMyFrame {
	public GUIPrincipal(){
		configuraJanela();
		
		
		
		
		
	}
	
	public void configuraJanela() {
		setLayout(new GridLayout());
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
