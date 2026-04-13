package objekte;

import java.time.LocalDate;
import java.util.ArrayList;

public class Eintrag extends MutterObjekt {

	private LocalDate datum;
	private String inhalt;
	private ArrayList<Methodik> methodik;
	// TODO: zum Eintrag gehören auch
	// Dozent
	// Thema
	// Bemerkung

	// Welchen Konstruktor bieten wir an?
	// Dabei die Überlegung: Ein Dozent will einen neuen Eintrag machen.
	// Dafür muss ein Objekt erzeugt werden. Welche Mindestinformation muss
	// dabei bereits vorhanden sein?

	public Eintrag(LocalDate datum) {
		super();
		this.datum = datum;
		methodik = new ArrayList<Methodik>();
	}

	@Override
	public String toString() {
		return "Eintrag [datum=" + datum + ", inhalt=" + inhalt + ", methodik=" + methodik + "]";
	}

	// Methode zum adden einer Instanz der Klasse Methodik zum ArrayList methodik
	public void addMethodik(Methodik m) {
		methodik.add(m);
	}

	// Getters und Setters Alt + Hochtaste + s
	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public String getInhalt() {
		return inhalt;
	}

	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}

	public ArrayList<Methodik> getMethodik() {
		return methodik;
	}

	public void setMethodik(ArrayList<Methodik> methodik) {
		this.methodik = methodik;
	}

}
