package objekte;

import java.time.LocalDate;
import java.util.ArrayList;

public class Eintrag extends MutterObjekt {

	private LocalDate datum;
	private String inhalt;
	private ArrayList<Methodik> methodik;

	private Klassenbuch klassenbuch;

	/**
	 * Standardkonstruktor<br>
	 * Das Datum wird auf das aktuelle Datum initialisiert.
	 */
	public Eintrag() {
		this(LocalDate.now());
	}

	public Eintrag(LocalDate datum) {
		super();
		this.datum = datum;
		methodik = new ArrayList<Methodik>();
	}

	@Override
	public String toString() {
		String info = "\n Eintrag vom " + datum;
		if (klassenbuch != null)
			info += " der Gruppe " + klassenbuch.getGruppe().getName();
		info += "\n Inhalt: " + inhalt + "\n Methodik: " + methodik;
		return info;
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

	public Klassenbuch getKlassenbuch() {
		return klassenbuch;
	}

	public void setKlassenbuch(Klassenbuch klassenbuch) {
		this.klassenbuch = klassenbuch;
	}

}
