package persistence;

import java.io.FileOutputStream;
import java.io.IOException;

import objekte.Eintrag;

/**
 * Speichert Einträge als einfache Textdateien im Ordner data/simple/.
 * Der Dateiname setzt sich aus dem Gruppennamen und dem Datum zusammen.
 */
public class SimpleFileSaver implements DataSaver{

	private static final String FOLDER = "./data/simple/";

	/**
	 * Speichert einen Eintrag als Textdatei.
	 * @param eintrag der zu speichernde Eintrag
	 * @return Fehlermeldung bei Misserfolg, sonst null
	 */
	@Override
	public String save(Eintrag eintrag) {
		
		String fileName = "dummy";
		if (eintrag.getKlassenbuch() != null)
			fileName = eintrag.getKlassenbuch().getGruppe().getName();
		fileName += eintrag.getDatum();
		
		try (FileOutputStream fileOutputStream = new FileOutputStream(FOLDER + fileName)) {
			fileOutputStream.write(eintrag.toString().getBytes());
		} catch (IOException e) {
			return e.getMessage();
		}
		return null;
	}

}
