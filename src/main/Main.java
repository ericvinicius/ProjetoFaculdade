package main;

import java.util.Calendar;
import java.util.Date;

import utilities.Logger;
import utilities.Utilites;
import view.GUIIdioma;


public class Main {
	public static void main(String[] args) {
		//Faz o log com a data e hora de inicio da aplicacao
		Logger log = new Logger();
		Date date = Calendar.getInstance().getTime();
		log.logInfo("Inicio", "Aplicacao iniciada (" + Utilites.formatDiaHora.format(date) + ")");
		
		//Coloca o menu externo no mac
		System.setProperty("apple.laf.useScreenMenuBar", "true");

		//Inicia a tela de idioma
		new GUIIdioma();
	}
}
