package tests;

import objekte.Eintrag;
import objekte.Gruppe;
import objekte.Klassenbuch;
import objekte.Methodik;
import objekte.Modul;
import persistence.DataSaver;
import persistence.SimpleFileSaver;

public class TestEintrag {

	public static void main(String[] args) {
		
		Eintrag dienstag = new Eintrag();
		dienstag.setInhalt("Wir versuchen mit Objekten klarzukommen");
		
		Methodik method = new Methodik();
		method.setName("Teamwork");
		dienstag.addMethodik(method);
		
		dienstag.addMethodik(new Methodik("Selbermachen"));
		
		System.out.println(dienstag);
		
		Klassenbuch buch = new Klassenbuch(new Modul("Java", 7), new Gruppe("Hyenen", "AE"));
		buch.addEintrag(dienstag);
		
		System.out.println(dienstag);
		
		// dienstag speichern
		
		DataSaver saver = new SimpleFileSaver();
		String err = saver.save(dienstag);
		System.out.println("Fehler beim Speichern: " + err);
	}

}
