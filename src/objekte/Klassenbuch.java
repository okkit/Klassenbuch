package objekte;

import java.util.ArrayList;
import java.util.List;

public class Klassenbuch extends MutterObjekt {

	private Modul modul;
	private Gruppe gruppe;

	List<Eintrag> eintraege;

	public Klassenbuch(Modul modul, Gruppe gruppe) {
		super();
		this.modul = modul;
		this.gruppe = gruppe;
	}

	public void addEintrag(Eintrag eintrag) {
		if (eintrag == null) // Wir wollen kein null-Objekt in der Liste haben
			return;

		if (eintraege == null) {
			eintraege = new ArrayList<Eintrag>();
		}
	}
	
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
