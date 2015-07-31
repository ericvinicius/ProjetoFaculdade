package anotations;

import java.util.Observable;

import utilities.Utilites;

public class Observer implements java.util.Observer {
	
	Utilites u = new Utilites();

	@Override
	public void update(Observable o, Object arg) {
		Throwable t = new Throwable();
		//StackTraceElement[] trace = t.getStackTrace();
		t.printStackTrace();
	}
}
