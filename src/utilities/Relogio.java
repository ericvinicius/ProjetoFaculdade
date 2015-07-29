package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

class Relogio extends Thread {

	private Utilites utilites = new Utilites();
	private JLabel hr;
	private String conteudo = "";

	public Relogio(JLabel hora) {
		this.hr = hora;
		if(hora.getText() != null){
			conteudo = hora.getText();
		}
	}

	@Override
	public void run() {
		while (true) {
			Date d = new Date();
			String data;
			SimpleDateFormat sdfData = new SimpleDateFormat(utilites.maskDia);
			data = sdfData.format(d);
			data += " - ";
			if(conteudo != ""){
				data = conteudo + " - " + data;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(utilites.maskHora);
			this.hr.setText(data + sdf.format(d));
			 try {
				Thread.sleep(450);
			} catch (InterruptedException ei) {
				utilites.paraLogDeErro(ei, "Erro na espera da thread do relogio");
			}
			this.hr.revalidate();
		}
	}

}