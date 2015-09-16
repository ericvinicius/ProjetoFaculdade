package main;

import java.util.Calendar;
import java.util.Date;

import utilities.Logger;
import utilities.Utilites;
import controllers.IdiomaControler;


public class Main {
	public static void main(String[] args) {
		//Faz o log com a data e hora de inicio da aplicacao
		Date date = Calendar.getInstance().getTime();
		Logger.info("Inicio", "Aplicacao iniciada (" + Utilites.formatDiaHora.format(date) + ")");
		
		//Coloca o menu externo no mac
		System.setProperty("apple.laf.useScreenMenuBar", "true");

		//Inicia a tela de idioma
		new IdiomaControler();
	}
}
