package persistence;

import objekte.Eintrag;

public interface DataSaver {
	
	/**
	 * Speichern eine Instanz der Klasse Eintrag in eine Text-Datei.
	 * @param eintrag
	 * @return Fehlermeldung, wenn das Speichern misslingt, sonst null.
	 */
	public String save(Eintrag eintrag);

}
