package objekte;

/**
 * Ein Modul beschreibt ein Unterrichtsfach mit Name und Nummer.
 * Zum Beispiel: Java, Modul 7.
 */
public class Modul extends MutterObjekt {

	private String name;
	private int nummer;

	/**
	 * Erstellt ein neues Modul.
	 * @param name der Modulname (z.B. Java)
	 * @param nummer die Modulnummer
	 */
	public Modul(String name, int nummer) {
		super();
		this.name = name;
		this.nummer = nummer;
	}

	@Override
	public String toString() {
		return "Modul [name=" + name + ", nummer=" + nummer + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

}
