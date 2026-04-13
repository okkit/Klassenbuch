package tests;

import java.time.LocalDate;
import java.util.ArrayList;

import objekte.Eintrag;
import objekte.Methodik;

public class TestEintrag {

	public static void main(String[] args) {
		
		Eintrag eintrag = new Eintrag(LocalDate.now());
		System.out.println(eintrag);
		System.out.println("--------------");
		eintrag.setInhalt("Abstrakte Klassen");
		System.out.println(eintrag);
		
		Methodik m = new Methodik();
		m.setName("Gruppenarbeit");
		
		// m muss nun in das ArrayList eintrag.methodik
		// Versucht selbst
		
		ArrayList<Methodik> liste = eintrag.getMethodik();
		liste.add(m);
		
		m = new Methodik();
		m.setName("Frontalunterricht");
		eintrag.addMethodik(m);
		
		String in = eintrag.getInhalt();
		in = "Etwas anderes";
		
		System.out.println(eintrag);
	}

}
