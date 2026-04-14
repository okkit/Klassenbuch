package objekte;

/**
 * Eine Methodik beschreibt die Unterrichtsmethode, z.B. Frontalunterricht,
 * Teamwork oder Selbstlernphase.
 */
public class Methodik extends MutterObjekt {

	private String name;
	private String beschreibung;

	/**
	 * Standardkonstruktor.
	 */
	public Methodik() {
		super();
	}

	/**
	 * Erstellt eine Methodik mit einem Namen.
	 * @param name der Name der Methodik
	 */
	public Methodik(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	
}
