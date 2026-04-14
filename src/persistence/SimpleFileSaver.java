package persistence;

import java.io.FileOutputStream;
import java.io.IOException;

import objekte.Eintrag;

public class SimpleFileSaver implements DataSaver{
	
	private static final String FOLDER = "./data/simple/";

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
