package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

class Relogio extends Thread {

	private JLabel hr;

	public Relogio(JLabel hora) {
		this.hr = hora;
	}

	@Override
	public void run() {
		Utilites utilites = new Utilites();
		while (true) {
			Date d = new Date();
			String data;
			SimpleDateFormat sdfData = new SimpleDateFormat(utilites.maskDia);
			data = sdfData.format(d);
			data += " - ";
			SimpleDateFormat sdf = new SimpleDateFormat(utilites.maskHora);
			this.hr.setText(data + sdf.format(d));
			 try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.hr.revalidate();
		}
	}

}