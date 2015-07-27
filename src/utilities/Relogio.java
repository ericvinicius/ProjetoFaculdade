package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class Relogio extends Thread {

	private JLabel hr;

	public Relogio(JLabel hora) {
		this.hr = hora;
	}

	@Override
	public void run() {
		while (true) {
			Date d = new Date();
			String data;
			SimpleDateFormat sdfData = new SimpleDateFormat("dd.MM.yyyy");
			data = sdfData.format(d);
			data += " - ";
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
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