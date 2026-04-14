package objekte;

import java.util.ArrayList;
import java.util.List;

/**
 * Ein Klassenbuch gehört zu einem Modul und einer Gruppe.
 * Es enthält eine Liste von Einträgen, die den Unterrichtsverlauf dokumentieren.
 */
public class Klassenbuch extends MutterObjekt {

	private Modul modul;
	private Gruppe gruppe;

	private List<Eintrag> eintraege;

	/**
	 * Erstellt ein neues Klassenbuch für das angegebene Modul und die Gruppe.
	 * @param modul das Modul (z.B. Java)
	 * @param gruppe die Gruppe (z.B. U29)
	 */
	public Klassenbuch(Modul modul, Gruppe gruppe) {
		super();
		this.modul = modul;
		this.gruppe = gruppe;
	}

	/**
	 * Fügt einen Eintrag zum Klassenbuch hinzu.
	 * Null-Werte werden ignoriert.
	 * @param eintrag der neue Eintrag
	 */
	public void addEintrag(Eintrag eintrag) {
		if (eintrag == null) // Wir wollen kein null-Objekt in der Liste haben
			return;

		if (eintraege == null) {
			eintraege = new ArrayList<Eintrag>();
		}
		
		eintrag.setKlassenbuch(this);
		eintraege.add(eintrag);
	}
	
	/**
	 * Entfernt einen Eintrag aus dem Klassenbuch.
	 * @param eintrag der zu entfernende Eintrag
	 * @return true wenn der Eintrag entfernt wurde, sonst false
	 */
	public boolean removeEintrag(Eintrag eintrag) {
		
		if (eintraege == null)
			return false;
		return eintraege.remove(eintrag);
	}

	@Override
	public String toString() {
		return "Klassenbuch [modul=" + modul + ", gruppe=" + gruppe + ", eintraege=" + eintraege
				+ "]";
	}

	public Modul getModul() {
		return modul;
	}

	public void setModul(Modul modul) {
		this.modul = modul;
	}

	public Gruppe getGruppe() {
		return gruppe;
	}

	public void setGruppe(Gruppe gruppe) {
		this.gruppe = gruppe;
	}

	public List<Eintrag> getEintraege() {
		return eintraege;
	}

}
