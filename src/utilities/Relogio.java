package utilities;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;

class Relogio extends Thread {

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
			Date date = Calendar.getInstance().getTime();
			String texto = Utilites.formatDiaHora.format(date);
			if(conteudo != ""){
				texto = conteudo + " - " + texto;
			}
			this.hr.setText(texto);
			 try {
				Thread.sleep(450);
			} catch (InterruptedException ei) {
				Logger.logError(ei, "Erro na espera da thread do relogio");
			}
			this.hr.revalidate();
		}
	}

}