package tests;

import java.util.Arrays;
import java.util.List;

import objekte.Gruppe;

public class TestGruppe {

	public static void main(String[] args) {
		
		String[] leute = {"Anna", "Boris", "Cezar", "Dora"};
		List<String> studenten = Arrays.asList(leute);
		
		Gruppe gr = new Gruppe("U29", "AE");
		gr.setStudenten(studenten);

		System.out.println(gr);
	}

}
