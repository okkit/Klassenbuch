package objekte;

/**
 * Abstrakte Basisklasse für alle Objekte im Klassenbuch.
 * Jedes Objekt bekommt eine eindeutige ID, die dem Primary Key
 * in einer relationalen Datenbank entspricht.
 */
public abstract class MutterObjekt {

	private int id; // entspicht dem primary key in der relationalen datenbank

	/**
	 * Gibt die ID des Objekts zurück.
	 * @return die ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setzt die ID des Objekts.
	 * @param id die neue ID
	 */
	public void setId(int id) {
		this.id = id;
	}
}
