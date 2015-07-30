package main;

import java.util.Calendar;
import java.util.Date;

import utilities.Logger;
import utilities.Utilites;
import view.GUIIdioma;


public class Main {
	public static void main(String[] args) {
		Logger log = new Logger();
		Date date = Calendar.getInstance().getTime();
		log.logInfo("Inicio", "Aplicacao iniciada (" + Utilites.formatDiaHora.format(date) + ")");
		System.setProperty("apple.laf.useScreenMenuBar", "true");

		new GUIIdioma();
	}
}
