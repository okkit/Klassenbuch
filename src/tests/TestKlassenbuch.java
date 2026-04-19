package tests;

import objekte.Eintrag;
import objekte.Gruppe;
import objekte.Klassenbuch;
import objekte.Modul;

public class TestKlassenbuch {

	public static void main(String[] args) {
		
		Modul m = new Modul("Java", 7);
		Gruppe g = new Gruppe("U29", "AE");

		Klassenbuch klBuch = new Klassenbuch(m, g);		
		System.out.println(klBuch);
		
		Eintrag ein = new Eintrag();
		ein.setInhalt("Wir arbeiten am Klassenbuch-Projekt");
		
		klBuch.addEintrag(ein);
		System.out.println(klBuch);

	}

}
